package observer;

import decorator.Asiento;
import config.ConfiguracionSistema;
import java.time.LocalDateTime;
import java.time.Duration;
import valueobjects.EstadoPago;
import observer.CarritoCompra;
import java.util.List;

public class Reserva {
    private Usuario cliente;
    private CarritoCompra carrito;
    private LocalDateTime fechaCreacion;
    private EstadoPago pagada;

    public Reserva(Usuario cliente) {
        this.cliente = cliente;
        this.carrito = new CarritoCompra();
        this.fechaCreacion = LocalDateTime.now();
        this.pagada = new EstadoPago(false);
    }

    public void agregarAsiento(Asiento asiento) {
        carrito.agregarAsiento(asiento);
    }

    public double calcularTotal() {
        return carrito.calcularTotal();
    }

    public void confirmarPago() {
        if (estaExpirada()) {
            System.out.println("Error: La reserva ha expirado. Debe liberar los asientos.");
            cancelarReserva();
            return;
        }

        this.pagada.marcarPagada();
        carrito.confirmarPago();
        System.out.println("Pago de $" + calcularTotal() + " procesado para " + cliente.getNombre());
    }

    public void cancelarReserva() {
        carrito.cancelar();
    }

    public boolean estaExpirada() {
        if (pagada.isPagada()) return false;
        long minutosTranscurridos = Duration.between(fechaCreacion, LocalDateTime.now()).toMinutes();
        return minutosTranscurridos >= ConfiguracionSistema.MINUTOS_LIMITE_RESERVA;
    }

    // Getters
    public boolean isPagada() { return pagada.isPagada(); }
    public List<Asiento> getAsientos() { return carrito.getAsientos(); }
}