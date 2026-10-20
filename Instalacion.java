public class Instalacion extends OrdenServicio {
    protected int puntos;

    public Instalacion(String codigo, String cliente, String direccion, double horasEstimadas, Zona zona, int puntos) {
        super(codigo, cliente, direccion, horasEstimadas, zona);
        if (puntos <= 0) throw new IllegalArgumentException("Los puntos deben ser un entero positivo.");
        this.puntos = puntos;
    }

    @Override
    public double calcularCostoBase() {
        double tarifaBase = (zona == Zona.METROPOLITANA) ? 100.0 : 175.0;
        double horasPuntos = puntos * 0.75;
        double horasFacturables = Math.ceil(Math.max(horasEstimadas, horasPuntos));
        return tarifaBase + (horasFacturables * 90.0);
    }

    @Override
    public int getDiasEstimadosAtencion() {
        return (zona == Zona.METROPOLITANA) ? 3 : 5;
    }

    @Override
    public int getVisitasMaximas() { return 3; }
}