package factory;

import decorator.Asiento;
import decorator.AsientoBase;

public class FactoryAsientoEstandar extends SeatFactory {
    @Override
    public Asiento crearAsiento(int id, double precioBase) {
        return new AsientoBase(id, precioBase); 
    }
}