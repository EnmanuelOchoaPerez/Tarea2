import java.time.LocalDateTime;
import chainResponsability.*;
import observer.*;
import factory.*;
import decorator.Asiento;
import valueobjects.Complejidad;

public class SistemaCinema {
    //Esta clase es para comprobar el funcionamiento en conjunto del sistema.
    public static void main(String[] args) {
        ManejadorReporte agente = buildReportHandlers();
        SeatFactory factory4D = createFactory4D();


        Usuario user1 = new Usuario("U1", "Carlos", "carlos@mail.com");
        Usuario user2 = new Usuario("U2", "Ana", "ana@mail.com");
        System.out.println("=== PRUEBA 1: CONFLICTO DE ASIENTOS ===");
        Reserva reservaCarlos = new Reserva(user1);
        Reserva reservaAna = new Reserva(user2);
        Asiento a4D = factory4D.crearAsiento(500, 100.0);

        reservaCarlos.agregarAsiento(a4D);
        reservaAna.agregarAsiento(a4D);

        System.out.println("\n=== PRUEBA 2: EXPIRACIÓN DE TIEMPO ===");
        if (reservaCarlos.estaExpirada()) {
             System.out.println("Cronómetro: Tiempo agotado para la reserva de " + user1.getNombre());
        }
        reservaCarlos.cancelarReserva();

        System.out.println("\n=== PRUEBA 3: SEGUNDO INTENTO TRAS LIBERACIÓN ===");
        reservaAna.agregarAsiento(a4D);
        reservaAna.confirmarPago();

        System.out.println("\n=== PRUEBA 4: REPORTE DE SOPORTE ===");
        Reporte fallo = new Reporte("El proyector de la sala 4D no enciende", new Complejidad(10));
        agente.procesarReporte(fallo);
    }

    private static ManejadorReporte buildReportHandlers() {
        ManejadorReporte agente = new AgenteSoporte();
        ManejadorReporte administrador = new Administrador();
        agente.setSiguiente(administrador);
        ManejadorReporte fallback = new ManejadorReporteImposible();
        agente.appendFinal(fallback);
        return agente;
    }

    private static SeatFactory createFactory4D() {
        return new FactoryAsiento4D();
    }
}