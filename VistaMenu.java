package jcolonia.daw2023.quiniela;

import java.util.Scanner;

/**
 * Clase Vista Menu que sirve para las diferentes opciones de nuestro programa
 * 
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class VistaMenu {
    /**
     * titulo tipo string que es el nombre
     */
    private String titulo;
    /**
     * opciones tipo string que sera las opciones que nos deje elegir
     */
    private String[] opciones;
    /**
     * scanner
     */
    private Scanner scanner;  

    /**
     * Vista menu, inicializa el scanner al final
     * @param titulo
     * @param opciones
     */
    public VistaMenu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
        this.scanner = new Scanner(System.in);  
    }

    /**
     * nos muestra el titulo principal
     */
    public void mostrarTituloPrincipal() {
        System.out.println("\n" + titulo + "\n");
    }

    /**
     * opcion para mostrar Menu
     */
    public void mostrarMenu() {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println("0. Salir");
    }

    /**
     * para poder pedir opcion
     * @return opcion
     */
    public int pedirOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();  
    }
    
    /**
     * Método para cerrar el scanner, llamar al finalizar el uso de VistaMenu
     */
    
    public void cerrar() {
        scanner.close();
    }
}

