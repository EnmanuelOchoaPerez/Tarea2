package factory;
import decorator.Asiento;

public abstract class SeatFactory {
    public abstract Asiento crearAsiento();
}