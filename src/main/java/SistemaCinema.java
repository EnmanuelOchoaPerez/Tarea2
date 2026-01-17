import java.time.LocalDateTime;
import chainResponsability.*;
import observer.*;
import factory.*;
import decorator.Asiento;
import valueobjects.Complejidad;

public class SistemaCinema {
    //Esta clase es para comprobar el funcionamiento en conjunto del sistema.
    public static void main(String[] args) {
        // 1. CONFIGURACIÓN INICIAL
        ManejadorReporte agente = new AgenteSoporte();
        ManejadorReporte administrador = new Administrador();
        agente.setSiguiente(administrador);

        SeatFactory factory4D = new FactoryAsiento4D();
        Asiento a4D = factory4D.crearAsiento(500, 100.0);
        
        Usuario user1 = new Usuario("U1", "Carlos", "carlos@mail.com");
        Usuario user2 = new Usuario("U2", "Ana", "ana@mail.com");

        System.out.println("=== PRUEBA 1: CONFLICTO DE ASIENTOS ===");
        Reserva reservaCarlos = new Reserva(user1);
        reservaCarlos.agregarAsiento(a4D); // Carlos lo pone en "En Proceso"

        Reserva reservaAna = new Reserva(user2);
        reservaAna.agregarAsiento(a4D); // Ana intenta, pero el EstadoEnProceso dirá que ya está ocupado

        System.out.println("\n=== PRUEBA 2: EXPIRACIÓN DE TIEMPO ===");
        /* Simulamos que Carlos nunca pagó. 
           Aquí forzamos la lógica de cancelación:
        */
        if (reservaCarlos.estaExpirada()) { // Esto daría true si pasaran 10 min
             System.out.println("Cronómetro: Tiempo agotado para la reserva de " + user1.getNombre());
        }
        reservaCarlos.cancelarReserva(); // Liberamos los asientos manualmente para la prueba
        
        System.out.println("\n=== PRUEBA 3: SEGUNDO INTENTO TRAS LIBERACIÓN ===");
        reservaAna.agregarAsiento(a4D); // Ahora Ana sí puede porque el estado volvió a "Libre"
        reservaAna.confirmarPago();     // Pasa a "Ocupado" definitivo

        System.out.println("\n=== PRUEBA 4: REPORTE DE SOPORTE ===");
        Reporte fallo = new Reporte("El proyector de la sala 4D no enciende", new Complejidad(10));
        agente.procesarReporte(fallo);
    }
}