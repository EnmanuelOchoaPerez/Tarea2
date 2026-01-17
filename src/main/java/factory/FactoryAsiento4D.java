package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.MovimientoDecorator;
import decorator.VibracionDecorator;

public class FactoryAsiento4D extends SeatFactory {
    @Override
    public Asiento crearAsiento(int id, double precioBase) {
        Asiento baseAsiento = new AsientoBase(id, precioBase);
        return new MovimientoDecorator(new VibracionDecorator(baseAsiento)); 
    }
}