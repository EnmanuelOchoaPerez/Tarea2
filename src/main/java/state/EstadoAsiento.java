package state;

import decorator.Asiento;

public interface EstadoAsiento {
    void manejar(Asiento asiento);
}
