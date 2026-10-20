class MantenimientoAC extends OrdenServicio {
    private int btu;

    public MantenimientoAC(String codigo, String cliente, String direccion, double horasEstimadas, Zona zona, int btu) {
        super(codigo, cliente, direccion, horasEstimadas, zona);
        if (zona != Zona.METROPOLITANA) {
            throw new IllegalArgumentException("Mantenimiento A/C solo se permite en Zona Metropolitana.");
        }
        if (btu < 9000 || btu > 60000) {
            throw new IllegalArgumentException("Capacidad BTU debe estar entre 9,000 y 60,000.");
        }
        this.btu = btu;
    }

    public int getBtu() {
        return btu;
    }

    @Override
    public double calcularCostoBase() {
        return 100.0 + (horasEstimadas * 110.0) + 80.0;
    }

    @Override
    public int getDiasEstimadosAtencion() { return 2; }

    @Override
    public int getVisitasMaximas() { return 1; }

    @Override
    public boolean esCompatibleConCuadrilla(Cuadrilla cuadrilla) {
        return cuadrilla.isCertificadaRefrigeracion();
    }
}