package chainResponsability;

import config.ConfiguracionSistema;

public class ResolucionAgenteSoporte implements EstrategiaResolucion {
    @Override
    public boolean puedeResolver(Reporte r) {
        return r.getComplejidad().getValue() <= ConfiguracionSistema.COMPLEJIDAD_MAXIMA_AGENTE_SOPORTE;
    }

    @Override
    public void resolver(Reporte r) {
        System.out.println("Agente Soporte: Reporte resuelto (" + r.getDescripcion() + ")");
    }
}
