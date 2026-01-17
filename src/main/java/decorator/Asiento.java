package decorator;

import state.EstadoAsiento;
import state.EstadoDisponible;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public abstract class Asiento {
    protected IdAsiento idAsiento;
    protected Precio precioBase;
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

    public abstract IdAsiento getIdAsiento();
    public abstract EstadoAsiento getEstado();
    public void setIdAsiento(int idAsiento) { this.idAsiento = new IdAsiento(idAsiento); }

}