package chainResponsability;

public abstract class ManejadorReporte {
    protected ManejadorReporte siguiente;

    public void setSiguiente(ManejadorReporte m) {
        this.siguiente = m;
    }

    public abstract void procesarReporte(Reporte r);
}
