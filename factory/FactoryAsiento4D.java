package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.MovimientoDecorator;

class FactoryAsiento4D extends SeatFactory {
    @Override
    public Asiento crearAsiento() {
        Asiento asiento = new AsientoBase(301, 100.0);
        return new MovimientoDecorator(new VibracionDecorator(asiento)); 
    }
}