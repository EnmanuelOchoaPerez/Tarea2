package decorator;

public class VibracionDecorator extends AsientoDecorator{
    @Override
    public double calcularPrecio() {
        return precioBase + 2.5;
    }
}
