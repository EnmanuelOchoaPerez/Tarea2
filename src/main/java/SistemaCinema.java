import java.time.LocalDateTime;

import ChainOfResponsability.Administrador;
import ChainOfResponsability.AgenteSoporte;
import ChainOfResponsability.ManejadorReporte;
import ChainOfResponsability.Reporte;
import factory.*;
import decorator.Asiento;

public class SistemaCinema {
    public static void main(String[] args) {
        // 1. Prueba del Factory y Decorator
        System.out.println("--- PRUEBA DE ASIENTOS (FACTORY & DECORATOR) ---");
        SeatFactory factory4D = new FactoryAsiento4D();
        Asiento asiento4D = factory4D.crearAsiento();
        System.out.println("Precio Asiento 4D (Base + Vibra + Movimiento): " + asiento4D.calcularPrecio());

        // 2. Prueba de Observer
        System.out.println("\n--- PRUEBA DE OBSERVER ---");
        Funcion funcionTarde = new Funcion(1, LocalDateTime.now().plusHours(2));
        Usuario user1 = new Usuario(1, "Juan Perez", "juan@mail.com");
        
        funcionTarde.suscribir(user1);
        funcionTarde.notificarCambio("La función se ha retrasado 10 minutos.");

        // 3. Prueba de Reserva y State
        System.out.println("\n--- PRUEBA DE RESERVA & STATE ---");
        Reserva reserva = new Reserva(999);
        reserva.agregarAsiento(asiento4D); // Esto debería cambiar el estado a Ocupado
        user1.realizarReserva(reserva);
        
        // Intentar reservar el mismo asiento de nuevo
        Asiento mismoAsiento = asiento4D;
        mismoAsiento.reservar(); // Debería decir que ya está ocupado

        // 4. Prueba Chain of Responsibility
        System.out.println("\n--- PRUEBA CHAIN OF RESPONSIBILITY ---");
        ManejadorReporte agente = new AgenteSoporte();
        ManejadorReporte admin = new Administrador();
        
        // Configurar la cadena: Agente -> Admin
        agente.setSiguiente(admin);

        Reporte reporteFacil = new Reporte(1, "No encuentro mi asiento", 2);
        Reporte reporteDificil = new Reporte(2, "El proyector explotó", 10);

        System.out.println("Procesando reporte fácil:");
        agente.procesarReporte(reporteFacil);
        
        System.out.println("Procesando reporte difícil:");
        agente.procesarReporte(reporteDificil);
    }
    
}
