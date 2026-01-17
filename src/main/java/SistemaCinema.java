import java.time.LocalDateTime;
import chainResponsability.*;
import decorator.AsientoBase;
import observer.*;
import factory.*;
import decorator.Asiento;
import valueobjects.Complejidad;
import valueobjects.IdAsiento;

public class SistemaCinema {
    //Esta clase es para comprobar el funcionamiento en conjunto del sistema.
    public static void main(String[] args) {
        ConfiguradorSistema.inicializar();

        System.out.println("=== INICIO DE PRUEBAS DE ESCENARIO ===\n");

        pruebaConflictoAsientos();

        System.out.println("\n--------------------------------------\n");

        pruebaExpiracionTiempo();

        System.out.println("\n--------------------------------------\n");

        pruebaCancelacionManual();

        System.out.println("\n=== FIN DE PRUEBAS ===");
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

    private static void pruebaConflictoAsientos() {
        System.out.println("[TEST] Escenario: Conflicto de Asientos (Concurrency)");

        Asiento asiento = new AsientoBase(new IdAsiento(1).getValue(), 10);
        Usuario user1 = new Usuario("U1", "Ana", "ana@mail.com");
        Usuario user2 = new Usuario("U2", "Bob", "bob@mail.com");

        System.out.println("Acción: Ana intenta reservar A1");
        asiento.getEstado().reservar(asiento);

        System.out.println("Acción: Bob intenta reservar A1 inmediatamente después");
        asiento.getEstado().reservar(asiento);
    }

    private static void pruebaExpiracionTiempo() {
        System.out.println("[TEST] Escenario: Expiración de Tiempo de Reserva");

        Usuario user = new Usuario("U3", "Carlos", "carlos@mail.com");
        Reserva reserva = new Reserva(user);
        reserva.agregarAsiento(new AsientoBase(new IdAsiento(2).getValue(), 50));

        System.out.println("Estado inicial pagada: " + reserva.isPagada());

        System.out.println("Simulando espera de 20 minutos...");

        reserva.confirmarPago();
    }

    private static void pruebaCancelacionManual() {
        System.out.println("[TEST] Escenario: Liberación Manual de Asientos");

        Asiento asiento = new AsientoBase(new IdAsiento(3).getValue(), 20);
        asiento.getEstado().reservar(asiento);
        System.out.println("Estado actual: " + asiento.getEstado().getClass().getSimpleName());

        System.out.println("Acción: Usuario cancela la operación");
        asiento.cancelar();
        System.out.println("Estado final: " + asiento.getEstado().getClass().getSimpleName());
    }
}