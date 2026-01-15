package chainResponsability;

public class Administrador extends ManejadorReporte {
    @Override
    public void procesarReporte(Reporte r) {
        System.out.println("Administrador: Reporte crítico resuelto (" + r.getDescripcion() + ")");
    }
}
