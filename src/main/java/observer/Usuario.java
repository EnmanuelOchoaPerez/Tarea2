package observer;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observador {
    private final valueobjects.UsuarioId id;
    private final String nombre;
    private final valueobjects.Email email;
    private final List<Reserva> misReservas;

    public Usuario(String id, String nombre, String email) {
        this.id = new valueobjects.UsuarioId(id);
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre;
        this.email = new valueobjects.Email(email);
        this.misReservas = new ArrayList<>();
    }

    @Override
    public void actualizar(String mensaje) {
        enviarNotificacion(mensaje);
    }

    public void enviarNotificacion(String mensaje) {
        System.out.println("--- NOTIFICACIÓN PARA " + nombre.toUpperCase() + " ---");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("------------------------------------------");
    }

    public void agregarReserva(Reserva reserva) {
        this.misReservas.add(reserva);
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email.getValue(); }
    public valueobjects.Email getEmailObj() { return email; }
    public List<Reserva> getMisReservas() { return List.copyOf(misReservas); }
}