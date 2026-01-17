package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.VibracionDecorator;

public class FactoryAsientoVip extends SeatFactory {
    @Override
    public Asiento crearAsiento(int id, double precioBase) {
        Asiento baseAsiento = new AsientoBase(id, precioBase);
        return new VibracionDecorator(baseAsiento);
    }
}