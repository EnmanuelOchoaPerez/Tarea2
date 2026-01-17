package decorator;

import state.EstadoAsiento;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public class AsientoBase extends Asiento {
    public AsientoBase(int id, double precio) {
        this.idAsiento = new IdAsiento(id);
        this.precioBase = new Precio(precio);
    }

    @Override
    public double calcularPrecio() { return precioBase.getValue(); }

    @Override
    public IdAsiento getIdAsiento() { return idAsiento; }

    @Override
    public EstadoAsiento getEstado() { return estado; }

    @Override
    public void setEstado(EstadoAsiento estado) { this.estado = estado; }
}