package historialWeb;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Historial {
	
	private ArrayList<PaginaWeb>historial;

	public Historial() {
		
	}

	/**
	 * A�ade una nueva entrada al historial
	 * @param visitaWeb
	 * @throws VisitaPaginaWebException Si la fecha hora
	 * de la nueva entrada es anterior a la �ltima entrada
	 */
	public void nuevaVisitaPaginaWeb(PaginaWeb visitaWeb) throws VisitaPaginaWebException {
		
		
	}

	/**
	 * @param nueva
	 * @return true si la nueva visita tiene fecha posterior
	 * a la �ltima y por tanto puede insertarse en el historial
	 * false en caso contrario
	 */
	private boolean esPosibleInsertarVisita(PaginaWeb nuevaVisitaWeb) {
		return false;

		
	}

	/**
	 * Devuelve la �ltima entrada de la coleccion
	 * @return null si la colecci�n esta vac�a y la
	 * ultima entrada en caso contrario
	 */
	private PaginaWeb ultimaEntrada() {
		return null;

		
	}
	
	public String consultarHistorialPorDia(LocalDate fecha) throws VisitaPaginaWebException {
		
		
		return sbHistorialPorDia.toString();	
	}

	@Override
	public String toString() {
		return null;
		
		
	}
	

	public void borrarHistorial() {
		
		
	}
}
