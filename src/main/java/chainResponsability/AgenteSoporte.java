package chainResponsability;

import java.util.ArrayList;
import java.util.List;

public class AgenteSoporte extends ManejadorReporte {
    private final List<EstrategiaResolucion> estrategias = new ArrayList<>();

    public AgenteSoporte() {
        // Por defecto incluye la estrategia del agente
        estrategias.add(new ResolucionAgenteSoporte());
    }

    public void addEstrategia(EstrategiaResolucion e) { estrategias.add(e); }

    @Override
    public void procesarReporte(Reporte r) {
        for (EstrategiaResolucion e : estrategias) {
            if (e.puedeResolver(r)) {
                e.resolver(r);
                return;
            }
        }

        if (siguiente != null) {
            System.out.println("Agente Soporte: Reporte demasiado complejo, pasando al siguiente...");
            siguiente.procesarReporte(r);
        }
    }
}
