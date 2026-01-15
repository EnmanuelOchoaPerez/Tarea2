package decorator;

import state.EstadoAsiento;

public class AsientoBase extends Asiento {
    public AsientoBase(int id, double precio) {
        this.idAsiento = id;
        this.precioBase = precio;
    }

    @Override
    public double calcularPrecio() { return precioBase; }

    @Override
    public int getIdAsiento() { return idAsiento; }

    @Override
    public EstadoAsiento getEstado() { return estado; }

    @Override
    public void setEstado(EstadoAsiento estado) { this.estado = estado; }
}