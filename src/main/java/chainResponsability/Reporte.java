package chainResponsability;

import valueobjects.Complejidad;

public class Reporte {
    private String descripcion;
    private Complejidad complejidad;

    public Reporte(String descripcion, Complejidad complejidad) {
        this.descripcion = descripcion;
        this.complejidad = complejidad;
    }

    public Complejidad getComplejidad() { return complejidad; }
    public String getDescripcion() { return descripcion; }

}
