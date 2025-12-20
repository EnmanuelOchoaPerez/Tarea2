package decorator;

public abstract class AsientoDecorator extends Asiento {
    protected Asiento asientoDecorado;

    public AsientoDecorator(Asiento asientoDecorado) {
        this.asientoDecorado = asientoDecorado;
    }

    @Override
    public double calcularPrecio() {
        return asientoDecorado.calcularPrecio();
    }
}
