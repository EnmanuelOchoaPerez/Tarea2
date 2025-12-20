package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.VibracionDecorator;

class FactoryAsientoVip extends SeatFactory {
    @Override
    public Asiento crearAsiento() {
        Asiento asiento = new AsientoBase(201, 80.0);
        return new VibracionDecorator(asiento);
    }
}