package ejercicio03HistorialWeb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Historial {
	
	private ArrayList<VisitaPaginaWeb>historial;

	public Historial() {
		this.historial = new ArrayList<VisitaPaginaWeb>();
	}

	/**
	 * Añade una nueva entrada al historial
	 * @param visitaWeb
	 * @throws VisitaPaginaWebException Si la fecha hora
	 * de la nueva entrada es anterior a la última entrada
	 */
	public void nuevaVisitaPaginaWeb(VisitaPaginaWeb visitaWeb) throws VisitaPaginaWebException {
		
		if (!esPosibleInsertarVisita(visitaWeb)) {
			throw new VisitaPaginaWebException("Error, no puedes introducir una pagina con fecha anterior a la ultima");
		}
		
		historial.add(visitaWeb);
	}

	/**
	 * @param nueva
	 * @return true si la nueva visita tiene fecha posterior
	 * a la última y por tanto puede insertarse en el historial
	 * false en caso contrario
	 */
	private boolean esPosibleInsertarVisita(VisitaPaginaWeb nuevaVisitaWeb) {

		boolean esValida = true;
		VisitaPaginaWeb ultima;
		
		ultima = ultimaEntrada();
		
		if (ultima != null) {
			System.out.println("Resultado " + nuevaVisitaWeb.compareTo(ultima));
			
			if (nuevaVisitaWeb.compareTo(ultima) <= 0) {
				esValida = false;
			}
		}
		
		return esValida;
	}

	/**
	 * Devuelve la última entrada de la coleccion
	 * @return null si la colección esta vacía y la
	 * ultima entrada en caso contrario
	 */
	private VisitaPaginaWeb ultimaEntrada() {

		VisitaPaginaWeb ultima = null;		
		int posicionUltimo = historial.size() -1;
		
		if (posicionUltimo >= 0) {
			ultima = historial.get(posicionUltimo);
		}
		
		return ultima;
	}
	
	public String consultarHistorialPorDia(LocalDate fecha) throws VisitaPaginaWebException {
		
		StringBuilder sbHistorialPorDia = new StringBuilder();
		VisitaPaginaWeb paginaWeb;
		boolean impresionTerminada = false;
		int resultadoComparacion;		
		Iterator <VisitaPaginaWeb> it = historial.iterator();
		
		while (it.hasNext() && !impresionTerminada) {
			paginaWeb = it.next();
			
			//Se convierte la hora y fecha local en solo fecha para poder comparar las fechas
			resultadoComparacion = paginaWeb.getFechaHora().toLocalDate().compareTo(fecha);
			
			if (resultadoComparacion == 0) {//Coinciden las fechas
				sbHistorialPorDia.append(paginaWeb + "\n");
			}
			else {
				if (resultadoComparacion > 0) { //Si la fecha es mayor que la buscada, finaliza. Eficiencia
					impresionTerminada = true;
				}
			}
		}
		
		if (sbHistorialPorDia.length() == 0) {
			throw new VisitaPaginaWebException("No hay registros para el dia " + fecha);
		}
		
		return sbHistorialPorDia.toString();	
	}

	@Override
	public String toString() {
		
		StringBuilder historialCompleto = new StringBuilder();
		
		for (VisitaPaginaWeb pagina : historial) {
			historialCompleto.append(pagina + "\n");
		}
		
		if (historialCompleto.length() == 0) {
			historialCompleto.append("Historial vacio");
			
		}
		return historialCompleto.toString();
	}
	

	public void borrarHistorial() {
		
		historial.clear();
	}
}
