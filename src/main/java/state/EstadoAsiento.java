package state;

import decorator.Asiento;

public interface EstadoAsiento {
    void reservar(Asiento asiento);
    void confirmar(Asiento asiento);
    void cancelar(Asiento asiento);
}