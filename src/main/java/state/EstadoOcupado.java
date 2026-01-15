package state;

import decorator.Asiento;

public class EstadoOcupado implements EstadoAsiento{
    @Override
    public void manejar(Asiento asiento) {
        System.out.println("El asiento ya está ocupado. No se puede reservar.");
    }
}
