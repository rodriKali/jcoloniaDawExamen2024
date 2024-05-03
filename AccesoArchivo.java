package jcolonia.daw2023.quiniela;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase proporciona métodos para leer y escribir en un archivo de texto.
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class AccesoArchivo {
    /**
     * Ruta archivo de tipo String
     */
    private String rutaArchivo;

    /**
     * Construye un objeto AccesoArchivo con la ruta del archivo especificada.
     *
     * @param rutaArchivo la ruta del archivo que se va a leer o escribir.
     */
    public AccesoArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Lee el contenido del archivo línea por línea y lo devuelve como una lista de cadenas.
     *
     * @return una lista de cadenas que representa el contenido del archivo.
     * @throws IOException si ocurre un error de E/S al leer el archivo.
     */
    public List<String> leer() throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    /**
     * Escribe el contenido proporcionado en el archivo, sobrescribiendo su contenido anterior si lo hubiera.
     *
     * @param contenido el contenido que se va a escribir en el archivo.
     * @return true si la escritura es exitosa, false si ocurre un error.
     */
    public boolean escribir(List<String> contenido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (String linea : contenido) {
                writer.println(linea);
            }
            return true;  
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false;  
        }
    }
}

