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
//BUSCAR	
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
