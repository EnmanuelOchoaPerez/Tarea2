package chainResponsability;

import valueobjects.Complejidad;

public class Reporte {
    private final String descripcion;
    private final Complejidad complejidad;

    public Reporte(String descripcion, Complejidad complejidad) {
        if (descripcion == null || descripcion.trim().isEmpty()) throw new IllegalArgumentException("Descripcion vacía");
        if (complejidad == null) throw new IllegalArgumentException("Complejidad requerida");
        this.descripcion = descripcion;
        this.complejidad = complejidad;
    }

    public Complejidad getComplejidad() { return complejidad; }
    public String getDescripcion() { return descripcion; }

    public boolean necesitaEscalamiento(int umbral) {
        return complejidad.getValue() > umbral;
    }

}
