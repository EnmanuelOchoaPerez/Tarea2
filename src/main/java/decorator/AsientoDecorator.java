package decorator;

import state.EstadoAsiento;

public abstract class AsientoDecorator extends Asiento {
    protected Asiento asientoDecorado;

    public AsientoDecorator(Asiento asientoDecorado) {
        this.asientoDecorado = asientoDecorado;
    }

    @Override
    public double calcularPrecio() {
        return asientoDecorado.calcularPrecio();
    }

    @Override
    public int getIdAsiento() {
        return asientoDecorado.getIdAsiento();
    }

    @Override
    public EstadoAsiento getEstado() {
        return asientoDecorado.getEstado();
    }

    @Override
    public void setEstado(EstadoAsiento estado) {
        asientoDecorado.setEstado(estado);
    }
}