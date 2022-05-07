package ejercicio04ProfesorAlumno;

import java.util.Comparator;

public class ComparadorPorFechaHora implements Comparator<Mensaje>{

	@Override
	public int compare(Mensaje mensaje1, Mensaje mensaje2) {
		
		return mensaje2.getHora().compareTo(mensaje1.getHora());
	}

}
