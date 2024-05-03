package jcolonia.daw2023.quiniela;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un conjunto de resultados de quiniela 1X2.
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class ConjuntoQuiniela1X2 {
    /**
     * pasamos elemento partido tipo lista
     */
    private List<ElementoPartido1X2> lista;

    /**
     * Constructor por defecto que inicializa la lista de resultados.
     */
    public ConjuntoQuiniela1X2() {
        lista = new ArrayList<>();  
    }

    /**
     * Obtiene el elemento de la posición especificada.
     *
     * @param pos la posición del elemento que se quiere obtener
     * @return el elemento en la posición especificada
     */
    public ElementoPartido1X2 getElemento(int pos) {
        return lista.get(pos);  
    }

    /**
     * Agrega un nuevo elemento al conjunto de resultados.
     *
     * @param nuevo el nuevo elemento a agregar
     */
    public void agregarElemento(ElementoPartido1X2 nuevo) {
        lista.add(nuevo);
    }

    /**
     * Elimina el elemento en la posición especificada.
     *
     * @param posiciónBorrable la posición del elemento que se quiere eliminar
     * @throws IndexOutOfBoundsException si la posición está fuera de rango
     */
    public void eliminarElemento(int posiciónBorrable) throws IndexOutOfBoundsException {
        if (posiciónBorrable < 0 || posiciónBorrable >= lista.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + posiciónBorrable);
        }
        lista.remove(posiciónBorrable);
    }

    /**
     * Obtiene el tamaño del conjunto de resultados.
     *
     * @return el tamaño del conjunto de resultados
     */
    public int tamaño() {
        return lista.size();
    }

    /**
     * Vacía el conjunto de resultados.
     */
    public void vaciar() {
        lista.clear();
    }

    /**
     * Genera un listado de los resultados en formato de texto.
     *
     * @return una lista de cadenas de texto representando los resultados
     */
    public List<String> generarListado() {
        List<String> listaTextos = new ArrayList<>(lista.size());
        for (ElementoPartido1X2 resultado : lista) {
            listaTextos.add(resultado.toString());
        }
        return listaTextos;
    }

    /**
     * Genera un listado de los resultados en formato CSV (valores separados por comas).
     *
     * @return una lista de cadenas de texto en formato CSV representando los resultados
     * @throws Partido1X2Exception si ocurre algún error al generar el listado CSV
     */
    public List<String> generarListadoCSV() throws Partido1X2Exception {
        List<String> listaTextos = new ArrayList<>(lista.size());
        for (ElementoPartido1X2 resultado : lista) {
            listaTextos.add(resultado.toStringCSV());
        }
        return listaTextos;
    }
}
