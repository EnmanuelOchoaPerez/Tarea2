package decorator;

import state.EstadoAsiento;
import state.EstadoDisponible;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public abstract class Asiento {
    private final IdAsiento idAsiento;
    private final Precio precioBase;
    private EstadoAsiento estado;

    public Asiento(IdAsiento idAsiento, Precio precioBase) {
        if (idAsiento == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        if (precioBase.getValue() < 0) throw new IllegalArgumentException("El precio no puede ser negativo");

        this.idAsiento = idAsiento;
        this.precioBase = precioBase;
        this.estado = new EstadoDisponible();
    }

    public void setEstado(EstadoAsiento nuevoEstado) {
        if (nuevoEstado == null) throw new IllegalArgumentException("El estado no puede ser nulo");
        this.estado = nuevoEstado;
    }

    public void seleccionar() {
        estado.reservar(this);
    }

    public void confirmarPago() {
        estado.confirmar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    protected Precio getPrecioBaseObj() { return precioBase; }

    public abstract double calcularPrecio();

    public IdAsiento getIdAsiento() { return idAsiento; }
    public EstadoAsiento getEstado() { return estado; }
}