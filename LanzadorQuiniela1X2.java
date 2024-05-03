package jcolonia.daw2023.quiniela;

/**
 * Lanzador de la aplicación de gestión de resultados deportivos de tipo 1X2.
 * 
 * @see ControladorQuiniela1X2
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class LanzadorQuiniela1X2 {
	/**
	 * Inicia el programa creando una instancia de la clase y activando el bucle
	 * principal de opciones. Abre el lector asociado a la entrada estándar.
	 * 
	 * @param args no se usa
	 * @throws Partido1X2Exception 
	 */
	public static void main(String[] args) throws Partido1X2Exception {
		ControladorQuiniela1X2 control = new ControladorQuiniela1X2();
		control.buclePrincipal();
	}
}
