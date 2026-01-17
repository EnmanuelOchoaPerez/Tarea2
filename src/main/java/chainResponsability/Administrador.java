package chainResponsability;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends ManejadorReporte {
    private final List<EstrategiaResolucion> estrategias = new ArrayList<>();

    public Administrador() {
        estrategias.add(new ResolucionAdministrador());
    }

    @Override
    public void procesarReporte(Reporte r) {
        for (EstrategiaResolucion e : estrategias) {
            if (e.puedeResolver(r)) {
                e.resolver(r);
                return;
            }
        }

        if (siguiente != null) {
            siguiente.procesarReporte(r);
        }
    }
}
