package decorator;

public class AsientoBase extends Asiento {
    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
