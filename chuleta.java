import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import historialWeb.VisitaPaginaWeb;
import historialWeb.VisitaPaginaWebException;

public class chuleta {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;
	public Equipo(String nombreEquipo) {	
		setNombreEquipo(nombreEquipo);
		conjuntoAlumnos = new HashSet<Alumno>();
	}	
//INSERTAR
	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {
		boolean esInsertado;		
		esInsertado = conjuntoAlumnos.add(nuevoAlumno);		
		if (!esInsertado) {
			throw new EquipoException("Error");
		}	
	}
//BORRAR
	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {
		if (!conjuntoAlumnos.contains(alumnoABorrar)) {
			throw new EquipoException("Error");
		}		
		conjuntoAlumnos.remove(alumnoABorrar);
	}
BUSCAR	
	public Alumno buscarAlumno(Alumno alumnoBuscado) throws EquipoException{		
		Alumno alumno = null;
		boolean esEncontrado = false;
		Iterator<Alumno> iterator = conjuntoAlumnos.iterator();		
		while (iterator.hasNext() && !esEncontrado) {
			alumno = (Alumno) iterator.next();
			if (alumno.equals(alumnoBuscado)) {
				esEncontrado = true;
				alumno = alumnoBuscado;
			}			
		}		
		if (!esEncontrado) {
			throw new EquipoException("Error");
		}		
		return alumno;
	}
//FUSION
	public Equipo fusionDeEquipos(Equipo otro, String nombre) throws EquipoException {		
		Equipo nuevoEquipo = new Equipo(nombre);		
		for (Alumno alumno : this.conjuntoAlumnos) {
			nuevoEquipo.insertarAlumno(alumno);
		}		
		for (Alumno alumno : otro.conjuntoAlumnos) {
			nuevoEquipo.insertarAlumno(alumno);
		}
		return nuevoEquipo;
	}
//INTERSECCION
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) throws EquipoException {
			Equipo nuevoEquipo = new Equipo(nombre);
		
		for (Alumno alumno : this.conjuntoAlumnos) {
			if (otro.conjuntoAlumnos.contains(alumno)) {
				nuevoEquipo.insertarAlumno(alumno);
			}
		}
		return nuevoEquipo;
	}
//LISTADO
	public String listadoAlumnos() {		
		StringBuilder sbListadoAlumnos = new StringBuilder();		
		for (Alumno alumno : conjuntoAlumnos) {
			sbListadoAlumnos.append(alumno + "\n");
		}		
		return sbListadoAlumnos.toString();
	}
	@Override
	public String toString() {
		
		return "Nombre Equipo: " + nombreEquipo + "\nAlumnos: \n" + listadoAlumnos();
	}
}

public class Historial {

	private ArrayList<VisitaPaginaWeb>historial;
	
	public Historial() {

		this.historial = new ArrayList<VisitaPaginaWeb>();
	}

	public void annadirNuevaVisitaPaginaWeb(VisitaPaginaWeb visita) throws VisitaPaginaWebException {	
		if (!esPosibleInsertarVisita(visita)) {
			throw new VisitaPaginaWebException("Error");
		}	
		historial.add(visita);		
	}

	private boolean esPosibleInsertarVisita(VisitaPaginaWeb visita) {
		boolean esValida = true;
		VisitaPaginaWeb ultima;		
		ultima = ultimaEntrada();	
		if (ultima != null) {
			System.out.println("Resultado " + visita.compareTo(ultima));			
			if (visita.compareTo(ultima) <= 0) {
				esValida = false;
			}
		}	
		return esValida;
	}
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
		Iterator<VisitaPaginaWeb> iterator = historial.iterator();
		
		while (iterator.hasNext() && !impresionTerminada) {
			paginaWeb = (VisitaPaginaWeb) iterator.next();			
			resultadoComparacion = paginaWeb.getFechaHora().toLocalDate().compareTo(fecha);		
			if (resultadoComparacion == 0) {
				sbHistorialPorDia.append(paginaWeb + "\n");
			}
			else {
				if (resultadoComparacion > 0) {
					impresionTerminada = true;
				}
			}
		}		
		if (sbHistorialPorDia.length() == 0) {
			throw new VisitaPaginaWebException("Error");
		}		
		return sbHistorialPorDia.toString();
	}
//BOORAR TODO
	public void borrarHistorial() {
		historial.clear();		
	}

	@Override
	public String toString() {
		
		StringBuilder sbHistorialCompleto = new StringBuilder();
		
		for (VisitaPaginaWeb visitaPaginaWeb : historial) {
			sbHistorialCompleto.append(visitaPaginaWeb + "\n");
		}
		
		if (sbHistorialCompleto.length() == 0) {
			sbHistorialCompleto.append("Historial Vacio");
		}
		return sbHistorialCompleto.toString();
	}

