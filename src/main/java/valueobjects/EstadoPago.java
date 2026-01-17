package valueobjects;

/**
 * Encapsula el estado de pago de una reserva.
 */
public final class EstadoPago {
    private boolean pagada;

    public EstadoPago(boolean pagada) { this.pagada = pagada; }

    public boolean isPagada() { return pagada; }

    public void marcarPagada() { this.pagada = true; }
}
