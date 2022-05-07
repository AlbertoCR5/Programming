package EjemplosOrientacionObjetos.EjemploArrayAlumnos;


public class Alumno implements Comparable<Alumno> {
	private String dni;
	private String nombre;
	private String direccion;
	private int notaFinal;
	
	
	public Alumno(String dni, String nombre, String direccion, int notaFinal) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.notaFinal=notaFinal;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}

	public int getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", notaFinal=" + notaFinal
				+ "]";
	}
	@Override
	public int compareTo(Alumno otroAlumno) {
		
//		Comparacion creciente por nota
//		int comparacion=0;
//		if ( this.notaFinal > otroAlumno.notaFinal) {
//			comparacion=1;
//		}
//		else {
//			if ( this.notaFinal < otroAlumno.notaFinal) {
//				comparacion=-1;
//			}
//		}
//		
//		return comparacion;
	
//		Comparacion creciente por nota, de otra forma
		return Integer.compare(this.notaFinal, otroAlumno.notaFinal);

//		Comparación decreciente por nombre del alumno
		//return (-1)*this.nombre.compareTo( otroAlumno.nombre);
		
		
	}
	
}
