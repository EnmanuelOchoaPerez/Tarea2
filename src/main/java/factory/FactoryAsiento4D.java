package factory;

import decorator.Asiento;
import decorator.AsientoBase;
import decorator.MovimientoDecorator;
import decorator.VibracionDecorator;

public class FactoryAsiento4D extends SeatFactory {
    @Override
    public Asiento crearAsiento(int id, double precioBase) {
        // El 4D combina ambos efectos especiales
        Asiento asiento = new AsientoBase(id, precioBase);
        return new MovimientoDecorator(new VibracionDecorator(asiento)); 
    }
}