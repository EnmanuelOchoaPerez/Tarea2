package decorator;

import state.EstadoAsiento;
import state.EstadoDisponible;

public abstract class Asiento {
    protected int idAsiento;
    protected double precioBase;
    protected EstadoAsiento estado;

    public Asiento() {
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

    public abstract double calcularPrecio();

    public abstract int getIdAsiento();
    public abstract EstadoAsiento getEstado();
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }

}