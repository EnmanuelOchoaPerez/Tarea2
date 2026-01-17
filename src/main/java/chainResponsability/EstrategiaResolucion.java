package chainResponsability;

import chainResponsability.Reporte;

public interface EstrategiaResolucion {
    boolean puedeResolver(Reporte r);
    void resolver(Reporte r);
}
