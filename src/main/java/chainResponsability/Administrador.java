package chainResponsability;

public class Administrador extends ManejadorReporte {
    @Override
    public void procesarReporte(Reporte r) {
        if (r.getComplejidad() > 5) {
            System.out.println("Administrador: Reporte crítico resuelto (" + r.getDescripcion() + ")");
        } else if (siguiente != null) {
            siguiente.procesarReporte(r);
        }
    }
}
