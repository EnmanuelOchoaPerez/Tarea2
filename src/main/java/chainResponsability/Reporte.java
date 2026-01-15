package chainResponsability;

public class Reporte {
    private String descripcion;
    private int complejidad;

    public Reporte(String descripcion, int complejidad) {
        this.descripcion = descripcion;
        this.complejidad = complejidad;
    }

    public int getComplejidad() { return complejidad; }
    public String getDescripcion() { return descripcion; }

}
