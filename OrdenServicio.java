public abstract class OrdenServicio {
    protected String codigo;
    protected String cliente;
    protected String direccion;
    protected double horasEstimadas;
    protected Zona zona;
    protected EstadoOrden estado;
    protected int visitasRealizadas;

    public OrdenServicio(String codigo, String cliente, String direccion, double horasEstimadas, Zona zona) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.direccion = direccion;
        this.horasEstimadas = horasEstimadas;
        this.zona = zona;
        this.estado = EstadoOrden.PENDIENTE;
        this.visitasRealizadas = 0;
    }

    public abstract double calcularCostoBase();
    public abstract int getDiasEstimadosAtencion();
    public abstract int getVisitasMaximas();

    public boolean esCompatibleConCuadrilla(Cuadrilla cuadrilla) {
        return true;
    }

    public void registrarVisitaAcceso() {
        this.visitasRealizadas++;
    }

    public String getCodigo() { return codigo; }
    public EstadoOrden getEstado() { return estado; }
    public void setEstado(EstadoOrden estado) { this.estado = estado; }
    public int getVisitasRealizadas() { return visitasRealizadas; }
    public double getHorasEstimadas() { return horasEstimadas; }
    public Zona getZona() { return zona; }
}

enum Zona { METROPOLITANA, PERIFERICA }
enum EstadoOrden { PENDIENTE, EN_ATENCION, COMPLETADA, CANCELADA }
enum EstadoJornada { EN_PREPARACION, INICIADA, CERRADA }