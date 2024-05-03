package jcolonia.daw2023.quiniela;

import java.util.Scanner;

/**
 * Esta clase maneja la entrada y salida de datos para el alta de partidos de fútbol 1X2.
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class VistaDiálogoAltaPartido1X2 {
    /**
     * scanner
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Permite al usuario ingresar los datos de un partido y devuelve un objeto ElementoPartido1X2.
     * @return Objeto ElementoPartido1X2 con los datos del partido.
     * @throws DatoPartido1X2Exception Si hay un error en los datos ingresados.
     * @throws Partido1X2Exception Si hay un error al crear el objeto ElementoPartido1X2.
     */
    public ElementoPartido1X2 entradaQuiniela1X2() throws DatoPartido1X2Exception, Partido1X2Exception {
        System.out.println("Ingrese el nombre del equipo local: ");
        String local = scanner.nextLine();
        System.out.println("Ingrese el nombre del equipo visitante: ");
        String visitante = scanner.nextLine();
        System.out.println("Ingrese el resultado del partido (1, X, 2):");
        String resultado = scanner.nextLine();

        return ElementoPartido1X2.of(local, visitante, resultado);
    }

    /**
     * Solicita confirmación al usuario para dar de alta un partido.
     * @param datos Los datos del partido a confirmar.
     * @return true si el usuario confirma el alta, false de lo contrario.
     */
    public boolean confirmarAlta(String datos) {
        System.out.println("Confirmar alta del partido: " + datos + " (S/N)");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("S");
    }
}



