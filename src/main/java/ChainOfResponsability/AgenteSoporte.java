package ChainOfResponsability;

public class AgenteSoporte extends ManejadorReporte{
    @Override
    public void procesarReporte(Reporte r) {
        if (r.getComplejidad() <= 5) {
            System.out.println("Agente Soporte: Reporte resuelto (" + r.getDescripcion() + ")");
        } else if (siguiente != null) {
            System.out.println("Agente Soporte: Reporte demasiado complejo, pasando al siguiente...");
            siguiente.procesarReporte(r);
        } else {
            System.out.println("Nadie pudo procesar el reporte.");
        }
    }
}
