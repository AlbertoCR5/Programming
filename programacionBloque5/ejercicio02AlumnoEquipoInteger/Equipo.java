package ejercicio02AlumnoEquipoInteger;

import java.util.*;

public class Equipo<T> {
	private String nombreEquipo;
	private HashSet<T> conjuntoMiembros;

	public Equipo(String nombreEquipo) throws EquipoException {
		
		setNombreEquipo(nombreEquipo);
		conjuntoMiembros = new HashSet<T>();		
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
		StringBuilder cadena = new StringBuilder(conjuntoMiembros.size());
		
		for (T alumno : conjuntoMiembros) {
			cadena.append(alumno + "\n");
		}
		
		return cadena.toString();
	}
	public void insertarAlumno(T nuevoAlumno) throws EquipoException {

		if (conjuntoMiembros.contains(nuevoAlumno)) {
			throw new EquipoException("ERROR, No se ha podido añadir al alumno " + nuevoAlumno + ", ya que ya estaba incluido");
		}
		conjuntoMiembros.add(nuevoAlumno);
		
	}

	public void borrarAlumno(T alumnoABorrar) throws EquipoException {
		
		if (!conjuntoMiembros.contains(alumnoABorrar)) {
			throw new EquipoException("ERROR, No se ha podido eliminar al alumno " + alumnoABorrar + ", ya que no esta inscrito");
		}
		conjuntoMiembros.remove(alumnoABorrar);
		
	}
	
	public T buscarAlumno(T alumnoBuscado){
		
		T alumno = null;
		boolean esEncontrado = false;
		Iterator<T> iterator = conjuntoMiembros.iterator();
		
		while (iterator.hasNext() && !esEncontrado) {
			
			alumno = iterator.next();
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
	public Equipo<T> fusionDeEquipos(Equipo<T> otro, String nombre) throws EquipoException{
		
		Equipo<T> nuevoEquipo = new Equipo<T>(nombre);
		
		for (T alumno : this.conjuntoMiembros) {
			try {
				nuevoEquipo.insertarAlumno(alumno);
			} catch (EquipoException e) {
				
			}
		}
		
		for (T alumno : otro.conjuntoMiembros) {
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
	public Equipo<T> intersecionDeEquipos(Equipo<T> otro, String nombre) throws EquipoException {
		
		Equipo<T> nuevoEquipo = new Equipo<T>(nombre);
		
		for (T alumno : this.conjuntoMiembros) {
			if (otro.conjuntoMiembros.contains(alumno)) {
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
