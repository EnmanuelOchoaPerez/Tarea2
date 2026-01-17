package chainResponsability;

public class ManejadorReporteImposible extends ManejadorReporte {
    @Override
    public void procesarReporte(Reporte r) {
        System.err.println("[FALLBACK] Ningún manejador pudo resolver el reporte: " + r.getDescripcion());
        try {
            System.err.println("[FALLBACK] Complejidad: " + r.getComplejidad().getValue());
        } catch (Exception e) {
            System.err.println("[FALLBACK] Complejidad: (desconocida)");
        }
        // Aquí se podría persistir el reporte o abrir un ticket.
    }
}
