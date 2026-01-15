package ChainOfResponsability;

public class Reporte {
    private int idReporte;
    private String descripcion;
    private int complejidad;

    public Reporte(int idReporte, String descripcion, int complejidad) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.complejidad = complejidad;
    }

    public int getComplejidad() { return complejidad; }
    public String getDescripcion() { return descripcion; }

}
