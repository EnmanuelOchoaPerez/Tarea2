package decorator;

import state.EstadoAsiento;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public abstract class AsientoDecorator extends Asiento {
    protected Asiento asientoDecorado;

    public AsientoDecorator(Asiento asientoDecorado) {
        super(asientoDecorado.getIdAsiento(), new Precio(asientoDecorado.calcularPrecio()));
        this.asientoDecorado = asientoDecorado;
    }

    @Override
    public double calcularPrecio() {
        return asientoDecorado.calcularPrecio();
    }

    @Override
    public IdAsiento getIdAsiento() {
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