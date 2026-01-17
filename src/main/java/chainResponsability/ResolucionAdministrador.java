package chainResponsability;

public class ResolucionAdministrador implements EstrategiaResolucion {
    @Override
    public boolean puedeResolver(Reporte r) {
        // Administrador es el nivel final de soporte: intenta resolver cuando llega hasta aquí.
        return true;
    }

    @Override
    public void resolver(Reporte r) {
        System.out.println("Administrador: Reporte crítico resuelto (" + r.getDescripcion() + ")");
    }
}
