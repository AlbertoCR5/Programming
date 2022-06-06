package MaterialEjercicio1;
import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {
		
		boolean esInsertado;
		
		esInsertado = conjuntoAlumnos.add(nuevoAlumno);
		
		if (!esInsertado) {
			throw new EquipoException("No se ha podido insertar al alumno");
		}
		
	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {

		if (!conjuntoAlumnos.contains(alumnoABorrar)) {
			throw new EquipoException("No se ha podido eliminar al alumno");
		}
		conjuntoAlumnos.remove(alumnoABorrar);
	}

	public Alumno buscarAlumno(Alumno alumnoBuscado){
		
		Alumno alumnoEncontrado = null;
		Alumno alumnoColeccion = null;
		boolean esEncontrado = false;
		Iterator<Alumno> iterator = conjuntoAlumnos.iterator();
		
		while (iterator.hasNext() && !esEncontrado) {
			alumnoColeccion = (Alumno) iterator.next();
			
			if (alumnoColeccion.equals(alumnoBuscado)) {
				alumnoEncontrado = alumnoColeccion;
				esEncontrado = true;
			}
		}
		
		return alumnoEncontrado;				
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro
	 *            Otro equipo que se va a unir
	 * @param nombre
	 *            Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) {
		
		Equipo equipoFusionado = new Equipo(nombre);
		
		for (Alumno alumno : conjuntoAlumnos) {
			equipoFusionado.conjuntoAlumnos.add(alumno);
		}
		
		for (Alumno alumno : otro.conjuntoAlumnos) {
			equipoFusionado.conjuntoAlumnos.add(alumno);
		}
		
		return equipoFusionado;
		

	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this
	 * y otro)
	 * 
	 * @param otro
	 *            Otro equipo
	 * @param nombre
	 *            Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) {
		
		Equipo equipoIntersecionado = new Equipo(nombre);
		
		for (Alumno alumno : conjuntoAlumnos) {
			if (otro.conjuntoAlumnos.contains(alumno)) {
				equipoIntersecionado.conjuntoAlumnos.add(alumno);
			}
		}
		
		return equipoIntersecionado;
	}

	@Override
	public String toString() {
		
		return "Nombre equipo: " + nombreEquipo + "\nAlumnos:\n" + listadoDeAlumnos();		
	}

	private String listadoDeAlumnos() {

		StringBuilder sbListadoAlumnos = new StringBuilder();
		
		for (Alumno alumno : conjuntoAlumnos) {
			sbListadoAlumnos.append(alumno + "\n");
		}
		return sbListadoAlumnos.toString();
	}

}
