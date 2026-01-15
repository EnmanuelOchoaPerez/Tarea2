package decorator;

public class MovimientoDecorator extends AsientoDecorator {
    public MovimientoDecorator(Asiento asientoDecorado) {
        super(asientoDecorado);
    }

    @Override
    public double calcularPrecio() {
        return super.calcularPrecio() + 10.0;
    }
}