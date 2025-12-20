package decorator;

public class AsientoBase extends Asiento {
    public AsientoBase(int id, double precio) {
        super();
        this.idAsiento = id;
        this.precioBase = precio;
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
