package chainResponsability;

public abstract class ManejadorReporte {
    protected ManejadorReporte siguiente;

    public void setSiguiente(ManejadorReporte m) {
        this.siguiente = m;
    }

   
    public void appendFinal(ManejadorReporte m) {
        ManejadorReporte cur = this;
        while (cur.siguiente != null) {
            cur = cur.siguiente;
        }
        cur.siguiente = m;
    }

    public abstract void procesarReporte(Reporte r);
}
