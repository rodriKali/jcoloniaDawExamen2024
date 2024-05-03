package jcolonia.daw2023.quiniela;

import java.util.List;

/**
 * La clase VistaListado se encarga de mostrar un listado de partidos.
 * 
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class VistaListado {
    /**
     * Titulo tipo String
     */
    private String título; 

    /**
     * Constructor de la clase VistaListado.
     * @param título El título que se mostrará junto al listado de partidos.
     */
    public VistaListado(String título) {
        this.título = título;
    }

    /**
     * Muestra el listado de partidos.
     * @param partidos La lista de partidos a mostrar.
     */
    public void mostrar(List<String> partidos) {
        System.out.println(título); 
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
        } else {
            for (String partido : partidos) {
                System.out.println(partido);
            }
        }
    }
}
