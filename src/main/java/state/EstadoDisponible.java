package state;

import decorator.Asiento;

public class EstadoDisponible implements EstadoAsiento {
    @Override
    public void reservar(Asiento asiento) {
        System.out.println("Asiento " + asiento.getIdAsiento().getValue() + " ahora está EN PROCESO DE COMPRA.");
        asiento.setEstado(new EstadoEnProceso());
    }

    @Override
    public void confirmar(Asiento asiento) {
        System.out.println("No se puede confirmar un asiento que no ha sido seleccionado.");
    }

    @Override
    public void cancelar(Asiento asiento) {
        System.out.println("El asiento ya está libre.");
    }
}