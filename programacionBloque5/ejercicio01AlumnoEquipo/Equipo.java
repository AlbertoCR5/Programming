package ejercicio01AlumnoEquipo;

import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombreEquipo) throws EquipoException {
		
		setNombreEquipo(nombreEquipo);
		conjuntoAlumnos = new HashSet<Alumno>();		
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) throws EquipoException {
		if (nombreEquipo.length() < 2) {
			throw new EquipoException("ERROR, el nombre del equipo " + nombreEquipo + ", es incorrecto");
		}
		this.nombreEquipo = nombreEquipo;
	}
	
	public String listadoDeAlumnos() {
		StringBuilder cadena = new StringBuilder(conjuntoAlumnos.size());
		
		for (Alumno alumno : conjuntoAlumnos) {
			cadena.append(alumno + "\n");
		}
		
		return cadena.toString();
	}
	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {

		boolean esInsertado;
		
		esInsertado = conjuntoAlumnos.add(nuevoAlumno);
		
		if (!esInsertado) {
			throw new EquipoException("ERROR, No se ha podido añadir al alumno " + nuevoAlumno + ", ya que ya estaba incluido");
		}
		
	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {
		
		if (!conjuntoAlumnos.contains(alumnoABorrar)) {
			throw new EquipoException("ERROR, No se ha podido eliminar al alumno " + alumnoABorrar + ", ya que no esta inscrito");
		}
		conjuntoAlumnos.remove(alumnoABorrar);
		
	}
	
	public Alumno buscarAlumno(Alumno alumnoBuscado){
		
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
		return alumno;	
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro
	 *            Otro equipo que se va a unir
	 * @param nombre
	 *            Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 * @throws EquipoException 
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) throws EquipoException{
		
		Equipo nuevoEquipo = new Equipo(nombre);
		
		for (Alumno alumno : this.conjuntoAlumnos) {
			try {
				nuevoEquipo.insertarAlumno(alumno);
			} catch (EquipoException e) {
				
			}
		}
		
		for (Alumno alumno : otro.conjuntoAlumnos) {
			try {
				nuevoEquipo.insertarAlumno(alumno);
			} catch (EquipoException e) {
			
			}
		}
		
		return nuevoEquipo;

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
	 * @throws EquipoException 
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) throws EquipoException {
		
		Equipo nuevoEquipo = new Equipo(nombre);
		
		for (Alumno alumno : this.conjuntoAlumnos) {
			if (otro.conjuntoAlumnos.contains(alumno)) {
				try {
					nuevoEquipo.insertarAlumno(alumno);
				} catch (EquipoException e) {
				
				}
			}
		}
		return nuevoEquipo;

	}

	@Override
	public String toString() {
		return "Nombre Equipo: " + nombreEquipo +  "\nAlumnos: \n" + listadoDeAlumnos();	
	}

}
