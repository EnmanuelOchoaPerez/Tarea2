package observer;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observador {
    private String id;
    private String nombre;
    private String email;
    private List<Reserva> misReservas;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.misReservas = new ArrayList<>();
    }

    @Override
    public void actualizar(String mensaje) {
        // Simulación de envío de correo o mensaje de aplicación
        System.out.println("--- NOTIFICACIÓN PARA " + nombre.toUpperCase() + " ---");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("------------------------------------------");
    }

    public void agregarReserva(Reserva reserva) {
        this.misReservas.add(reserva);
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public List<Reserva> getMisReservas() { return List.copyOf(misReservas); }
}