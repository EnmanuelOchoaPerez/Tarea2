package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.VibracionDecorator;

public class FactoryAsientoVip extends SeatFactory {
    @Override
    public Asiento crearAsiento(int id, double precioBase) {
        // Un VIP es un asiento base con un extra de comodidad (Vibración)
        Asiento asiento = new AsientoBase(id, precioBase);
        return new VibracionDecorator(asiento);
    }
}