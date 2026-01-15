package decorator;

public class VibracionDecorator extends AsientoDecorator {
    public VibracionDecorator(Asiento asientoDecorado) {
        super(asientoDecorado);
    }

    @Override
    public double calcularPrecio() {
        return super.calcularPrecio() + 5.0;
    }
}