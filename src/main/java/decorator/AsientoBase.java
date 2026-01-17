package decorator;

import state.EstadoAsiento;
import valueobjects.IdAsiento;
import valueobjects.Precio;

public class AsientoBase extends Asiento {
    public AsientoBase(int id, double precio) {
        super(new IdAsiento(id), new Precio(precio));
    }

    @Override
    public double calcularPrecio() { return getPrecioBaseObj().getValue(); }
}