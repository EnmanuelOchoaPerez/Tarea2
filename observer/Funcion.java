package observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Funcion {
    private int idFuncion;
    private LocalDateTime horario;
    private ArrayList<Observador> observadores;

    public Funcion(int idFuncion, LocalDateTime horario) {
        this.idFuncion = idFuncion;
        this.horario = horario;
        this.observadores = new ArrayList<>();
    }

    public void suscribir(Observador o) {
        observadores.add(o);
    }

    public void desuscribir(Observador o) {
        observadores.remove(o);
    }

    public void notificarCambio(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar("Función " + idFuncion + ": " + mensaje);
        }
    }
}