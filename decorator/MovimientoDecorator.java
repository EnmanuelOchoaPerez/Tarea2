package decorator;

public class MovimientoDecorator extends AsientoDecorator{
    @Override
    public double calcularPrecio() {
        return precioBase + 2;
    }
}
