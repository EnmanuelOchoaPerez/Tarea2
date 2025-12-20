package factory;
import decorator.Asiento;

abstract class SeatFactory {
    public abstract Asiento crearAsiento();
}