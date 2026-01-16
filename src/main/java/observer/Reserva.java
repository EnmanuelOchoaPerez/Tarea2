package observer;
import decorator.Asiento;
import config.ConfiguracionSistema;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Duration;

public class Reserva {
    private Usuario cliente;
    private List<Asiento> asientos;
    private LocalDateTime fechaCreacion;
    private boolean pagada;

    public Reserva(Usuario cliente) {
        this.cliente = cliente;
        this.asientos = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
        this.pagada = false;
    }

    public void agregarAsiento(Asiento asiento) {
        // El asiento intenta pasar a "En Proceso"
        asiento.seleccionar(); 
        asientos.add(asiento);
    }

    public double calcularTotal() {
        return asientos.stream().mapToDouble(Asiento::calcularPrecio).sum();
    }

    public void confirmarPago() {
        if (estaExpirada()) {
            System.out.println("Error: La reserva ha expirado. Debe liberar los asientos.");
            cancelarReserva();
            return;
        }
        
        this.pagada = true;
        for (Asiento a : asientos) {
            a.confirmarPago(); // Cambia a EstadoOcupado
        }
        System.out.println("Pago de $" + calcularTotal() + " procesado para " + cliente.getNombre());
    }

    public void cancelarReserva() {
        for (Asiento a : asientos) {
            a.cancelar(); // Cambia a EstadoLibre
        }
        asientos.clear();
    }

    public boolean estaExpirada() {
        if (pagada) return false;
        long minutosTranscurridos = Duration.between(fechaCreacion, LocalDateTime.now()).toMinutes();
        return minutosTranscurridos >= ConfiguracionSistema.MINUTOS_LIMITE_RESERVA;
    }

    // Getters
    public boolean isPagada() { return pagada; }
    public List<Asiento> getAsientos() { return asientos; }
}