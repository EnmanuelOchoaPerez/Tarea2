package state;

import decorator.Asiento;

public class EstadoLibre implements EstadoAsiento{
    @Override
    public void manejar(Asiento asiento) {
        System.out.println("El asiento ahora está RESERVADO.");
        asiento.setEstado(new EstadoOcupado());
    }
}
