package decorator;

import state.EstadoAsiento;
import state.EstadoLibre;

public abstract class Asiento {
    protected int idAsiento;
    protected double precioBase;
    protected EstadoAsiento estado;

    public Asiento() {
        this.estado = new EstadoLibre(); // Estado inicial por defecto
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    public void reservar() {
        this.estado.manejar(this);
    }

    public abstract double calcularPrecio();

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }

}
