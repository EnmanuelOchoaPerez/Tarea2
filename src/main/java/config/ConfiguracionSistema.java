package config;

public class ConfiguracionSistema {
    
    // Configuración de Reservas
    public static final int MINUTOS_LIMITE_RESERVA = 10;
    
    // Configuración de Reportes
    public static final int COMPLEJIDAD_MAXIMA_AGENTE_SOPORTE = 5;
    
    // Configuración de Decoradores de Asientos
    public static final double PRECIO_EXTRA_MOVIMIENTO = 10.0;
    public static final double PRECIO_EXTRA_VIBRACION = 5.0;
    
    private ConfiguracionSistema() {
        // Clase utilitaria, no instanciar
    }
}
