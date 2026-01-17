package observer;

import decorator.Asiento;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsula la gestión de los asientos asociados a una reserva.
 */
public class CarritoCompra {
    private final List<Asiento> asientos;

    public CarritoCompra() {
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        asiento.seleccionar();
        asientos.add(asiento);
    }

    public double calcularTotal() {
        return asientos.stream().mapToDouble(Asiento::calcularPrecio).sum();
    }

    public void confirmarPago() {
        for (Asiento a : asientos) {
            a.confirmarPago();
        }
    }

    public void cancelar() {
        for (Asiento a : asientos) {
            a.cancelar();
        }
        asientos.clear();
    }

    public List<Asiento> getAsientos() {
        return List.copyOf(asientos);
    }
}
