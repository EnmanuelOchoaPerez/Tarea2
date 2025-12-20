package factory;

import decorator.Asiento;
import decorator.AsientoBase;

public class FactoryAsientoEstandar extends SeatFactory {
    @Override
    public Asiento crearAsiento() {
        return new AsientoBase(101, 50.0); 
    }
}
