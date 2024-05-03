package jcolonia.daw2023.quiniela;

import java.util.Scanner;
import java.util.List;

/**
 * Clase Vista baja que sirve para las dar de baja alguna opcion que queramos.
 * 
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */

public class VistaDiálogoBajaPartido1X2 {
    /**
     * scaner
     */
    private Scanner scanner;

    /**
     * vistadialogo baja
     */
    public VistaDiálogoBajaPartido1X2() {
        scanner = new Scanner(System.in);
    }

    /**
     * baja quiniela pasa tipo list string
     * 
     * @param listadoPartidos
     * @return -1
     */
    public int bajaQuiniela1X2(List<String> listadoPartidos) {
        if (listadoPartidos.isEmpty()) {
            System.out.println("No hay partidos disponibles para eliminar.");
            return -1;
        }

        System.out.println("Listado de Partidos:");
        for (int i = 0; i < listadoPartidos.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, listadoPartidos.get(i));
        }

        System.out.println("Ingrese el número del partido a eliminar o presione '0' para cancelar:");
        int índice = -1;
        while (true) {
            try {
                índice = Integer.parseInt(scanner.nextLine());
                if (índice == 0) {
                    System.out.println("Operación cancelada.");
                    return -1;
                } else if (índice < 1 || índice > listadoPartidos.size()) {
                    System.out.println("Índice inválido, por favor intente de nuevo:");
                } else {
                    return índice - 1; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, por favor ingrese un número:");
            }
        }
    }

    /**
     * para confirmar la baja, si deseamos de verdad confirmarla
     * 
     * @param datos
     * @return si la confirmamos la baja
     */
    public boolean confirmarBaja(String datos) {
        System.out.println("¿Confirma que desea eliminar el siguiente partido? " + datos + " (S/N)");
        String respuesta;
        while (true) {
            respuesta = scanner.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                return true;
            } else if (respuesta.equals("N")) {
                return false;
            } else {
                System.out.println("Respuesta inválida, por favor ingrese 'S' o 'N':");
            }
        }
    }
}


