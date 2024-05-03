package jcolonia.daw2023.quiniela;

import static java.lang.System.out;

import java.io.IOException;
import java.util.List;

/**
 * Controlador: Aplicación de gestión de resultados deportivos de tipo 1X2.
 * Gestiona las distintas funciones del menú principal.
 * 
 * @see ElementoPartido1X2
 * 
 * @version 1.1 (20240502000)
 * @author <a href="mailto:rodrigo.ortpar.1@educa.jcyl.es">Rodrigo Ortega Pardo</a>
 */
public class ControladorQuiniela1X2 {
	/** Nombre del archivo de datos para impotación/exportación. */
	private static final String NOMBRE_ARCHIVO = "Almacén Quiniela1X2.txt";
	/** Opciones del menú principal. */
	private static final String[] TXT_MENÚ_PRINCIPAL = { "Alta", "Baja", "Listado", "Exportación", "Importación",
			"Borrado", "Acerca De" };
	/** Colección principal de resultados. */
	ConjuntoQuiniela1X2 listaResultados;

	/**
	 * Inicializa la lista/colección donde se irán guardando los partidos.
	 */
	public ControladorQuiniela1X2() {
		listaResultados = new ConjuntoQuiniela1X2();
	}

	/**
	 * Bucle principal ligado al menú de entrada.
	 * @throws Partido1X2Exception 
	 */
	public void buclePrincipal() throws Partido1X2Exception {
	    VistaMenu menú;
	    int opción;
	    int n = 0;
	    boolean salir = false;

	    menú = new VistaMenu("Quiniela 1-X-2", TXT_MENÚ_PRINCIPAL);

	    do {
	        menú.mostrarTituloPrincipal();  
	        menú.mostrarMenu();
	        opción = menú.pedirOpcion();
	        n++;

			switch (opción) {
			case 1: 
				alta();
				break;
			case 2: 
				baja();
				break;
			case 3: 
				listado();
				break;
			case 4: 
				exportación(NOMBRE_ARCHIVO);
				break;
			case 5: 
				importación(NOMBRE_ARCHIVO);
				break;
			case 0:
				finalizar(); 
				salir = true;
				break;
			default:
				stub(opción, n);
				break;
			}
		} while (!salir);
	}

	/**
	 * Crea un partido vacío para rellenarlo y eventualmente almacenarlo. El partido
	 * se envía al diálogo de altas, y si este responde positivamente se almacena.
	 * @throws Partido1X2Exception 
	 */
	private void alta() throws Partido1X2Exception {
	    VistaDiálogoAltaPartido1X2 dlg = new VistaDiálogoAltaPartido1X2();
	    try {
	        ElementoPartido1X2 nuevo = dlg.entradaQuiniela1X2();
	        if (dlg.confirmarAlta(nuevo.toString())) {
	            listaResultados.agregarElemento(nuevo);
	            System.out.println("Partido agregado exitosamente.");
	        } else {
	            System.out.println("Alta cancelada por el usuario.");
	        }
	    } catch (DatoPartido1X2Exception e) {
	        System.out.println("Error al crear el partido: " + e.getMessage());
	    }
	    listado();
	}


	/**
	 * Abre el diálogo de bajas y recibe de él un partido de la lista para su
	 * eliminación.
	 */
	private void baja() {
	    try {
	        VistaDiálogoBajaPartido1X2 dlg = new VistaDiálogoBajaPartido1X2();
	        int posiciónBorrable = dlg.bajaQuiniela1X2(listaResultados.generarListado());

	        if (posiciónBorrable >= 0 && posiciónBorrable < listaResultados.tamaño()) {
	            ElementoPartido1X2 partidoBorrable = listaResultados.getElemento(posiciónBorrable);
	            if (dlg.confirmarBaja("¿Está seguro de querer eliminar el siguiente partido? " + partidoBorrable.toString())) {
	                listaResultados.eliminarElemento(posiciónBorrable);
	                System.out.println("Partido eliminado correctamente.");
	            } else {
	                System.out.println("Eliminación cancelada.");
	            }
	        } else {
	            System.out.println("No se ha seleccionado un índice válido.");
	        }
	    } catch (Exception e) {
	        System.err.println("Error durante la eliminación: " + e.getMessage());
	    }
	    listado();
	}


	/**
	 * Genera una pantalla con el listado completo de partidos almacenados.
	 */
	private void listado() {
		VistaListado dlg;
		dlg = new VistaListado("Lista de Resultados");

		dlg.mostrar(listaResultados.generarListado());
		VistaGeneral.preguntaSeguir();
	}

	/**
	 * Realiza el volcado de todas las partidos almacenados a un archivo de texto.
	 * Emplea un formato propio –de estilo CSV con separador «#»– que puede ser
	 * recuperado posteriormente (ver {@link #importación(String)}). En caso de
	 * producirse algún error de acceso se envía el mensaje a la salida de error
	 * estándar y el programa continua.
	 * 
	 * @param rutaArchivo el nombre o ruta al archivo
	 * @throws Partido1X2Exception 
	 */
	private void exportación(String rutaArchivo) throws Partido1X2Exception {
	    List<String> listaTextosCSV = listaResultados.generarListadoCSV();
	    int númElementos = listaTextosCSV.size();

	    if (númElementos == 0) {
	        VistaGeneral.mostrarAviso("No hay ningún resultado que exportar");
	    } else {
	        AccesoArchivo archivo = new AccesoArchivo(rutaArchivo);
	        boolean bienGrabado = archivo.escribir(listaTextosCSV);

	        if (bienGrabado) {
	            String mensaje = String.format("%d resultados exportados con éxito a %s", númElementos, rutaArchivo);
	            VistaGeneral.mostrarTexto(mensaje);
	        } else {
	            VistaGeneral.mostrarAviso("Error al intentar escribir en el archivo.");
	        }
	    }
	}


	/**
	 * Importa partidos almacenados en un archivo de texto reemplazando el contenido
	 * actual del programa. Emplea un formato propio –de estilo CSV con separador
	 * «#»– producido por una exportación previa (ver {@link #exportación(String)}).
	 * En caso de producirse algún error de acceso o por el propio formato del
	 * archivo, se envía el mensaje a la salida de error estándar y el programa
	 * continúa sin perder el contenido anterior.
	 * 
	 * @param rutaArchivo el nombre o ruta al archivo
	 * @throws Partido1X2Exception 
	 */
	private void importación(String rutaArchivo) throws Partido1X2Exception {
	    AccesoArchivo archivo;
	    ConjuntoQuiniela1X2 nuevaLista;
	    ElementoPartido1X2 nuevoElemento;
	    List<String> contenido;
	    int númElementos;
	    String mensaje;

	    try {
	        archivo = new AccesoArchivo(rutaArchivo);
	        contenido = archivo.leer(); 
	        númElementos = contenido.size();

	        if (númElementos == 0) {
	            VistaGeneral.mostrarAviso("No hay ningún elemento que importar");
	        } else {
	            nuevaLista = new ConjuntoQuiniela1X2();
	            for (String línea : contenido) {
	                try {
	                    nuevoElemento = ElementoPartido1X2.of(línea);
	                    nuevaLista.agregarElemento(nuevoElemento);
	                } catch (DatoPartido1X2Exception ex) {
	                    System.err.printf("Error al procesar la línea '%s': %s%n", línea, ex.getLocalizedMessage());
	                    continue;
	                }
	            }
	            listaResultados = nuevaLista;

	            mensaje = String.format("%d resultados importados", númElementos);
	            VistaGeneral.mostrarTexto(mensaje);
	            listado();
	        }
	    } catch (IOException e) {
	        System.err.printf("Error al acceder al archivo %s: %s%n", rutaArchivo, e.getMessage());
	    }
	}


	/**
	 * Muestra un mensaje temporal, de relleno, para opciones pendientes de
	 * implementar.
	 * 
	 * @param entrada la opción elegida
	 * @param n       el número de secuencia en el historial de opciones cursadas
	 */
	private void stub(int entrada, int n) {
		out.printf("(%02d) → %d [Opción sin desarrollar]%n", n, entrada);
	}

	/**
	 * Finaliza el programa. Muestra un mensaje final y cierra la conexión con la
	 * entrada estándar.
	 */
	private void finalizar() {
		out.println("*** FIN ***");
		VistaGeneral.close();
	}
}

