package chainResponsability;
import config.ConfiguracionSistema;

public class AgenteSoporte extends ManejadorReporte {
    @Override
    public void procesarReporte(Reporte r) {
        if (r.getComplejidad() <= ConfiguracionSistema.COMPLEJIDAD_MAXIMA_AGENTE_SOPORTE) {
            System.out.println("Agente Soporte: Reporte resuelto (" + r.getDescripcion() + ")");
        } else if (siguiente != null) {
            System.out.println("Agente Soporte: Reporte demasiado complejo, pasando al siguiente...");
            siguiente.procesarReporte(r);
        }
    }
}
