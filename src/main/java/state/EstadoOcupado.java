package state;

import decorator.Asiento;

public class EstadoOcupado implements EstadoAsiento {
    @Override
    public void reservar(Asiento asiento) {
        System.out.println("Error: El asiento ya está ocupado definitivamente.");
    }

    @Override
    public void confirmar(Asiento asiento) {
        System.out.println("El asiento ya fue pagado anteriormente.");
    }

    @Override
    public void cancelar(Asiento asiento) {
        System.out.println("No se puede cancelar una reserva ya pagada sin autorización administrativa.");
    }
}