package jcolonia.daw2023.quiniela;

/**
 * Excepción específica para errores relacionados con el manejo de partidos en el formato 1X2.
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
@SuppressWarnings("serial")
public class Partido1X2Exception extends Exception {

    /**
     * Construye una nueva excepción con el mensaje de error especificado.
     * 
     * @param message el mensaje que detalla la razón de la excepción.
     */
    public Partido1X2Exception(String message) {
        super(message);  // Llama al constructor de la superclase Exception con el mensaje de error.
    }

    /**
     * Construye una nueva excepción con el mensaje de error especificado y una causa.
     * 
     * @param message el mensaje que detalla la razón de la excepción.
     * @param cause la causa (que se guarda para su posterior recuperación por el método getCause()).
     */
    public Partido1X2Exception(String message, Throwable cause) {
        super(message, cause);  
    }
}

