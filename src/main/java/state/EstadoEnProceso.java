package state;

import decorator.Asiento;

public class EstadoEnProceso implements EstadoAsiento {
    @Override
    public void reservar(Asiento asiento) {
        System.out.println("El asiento ya está en proceso de compra por otro usuario.");
    }

    @Override
    public void confirmar(Asiento asiento) {
        System.out.println("Pago recibido. Asiento " + asiento.getIdAsiento() + " ahora está RESERVADO.");
        asiento.setEstado(new EstadoOcupado());
    }

    @Override
    public void cancelar(Asiento asiento) {
        System.out.println("Tiempo agotado o compra cancelada. Liberando asiento " + asiento.getIdAsiento() + ".");
        asiento.setEstado(new EstadoDisponible());
    }
}