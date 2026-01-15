package observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
    private String nombre;
    private LocalDateTime horario;
    private List<Observador> observadores;
    public Funcion(String nombre, LocalDateTime horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.observadores = new ArrayList<>();
    }

    public void agregarSuscriptor(Observador o) {
        observadores.add(o);
    }

    public void eliminarSuscriptor(Observador o) {
        observadores.remove(o);
    }

    public void notificarCambio(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar("Función " + nombre + ": " + mensaje);
        }
    }

    public void cambiarHorario(LocalDateTime nuevoHorario) {
        this.horario = nuevoHorario;
        notificarCambio("El horario ha sido cambiado a " + nuevoHorario.toString());
    }
    
}
