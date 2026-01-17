package decorator;

import state.EstadoAsiento;
import state.EstadoDisponible;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public abstract class Asiento {
    private final IdAsiento idAsiento;
    private final Precio precioBase;
    private EstadoAsiento estado;

    protected Asiento(IdAsiento idAsiento, Precio precioBase) {
        if (idAsiento == null) throw new IllegalArgumentException("IdAsiento requerido");
        if (precioBase == null) throw new IllegalArgumentException("Precio requerido");
        this.idAsiento = idAsiento;
        this.precioBase = precioBase;
        this.estado = new EstadoDisponible();
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
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