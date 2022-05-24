package ejercicio1;
import java.util.HashMap;


public class Grupo {
	private static final int NIVEL_INFERIOR = 1;
	private static final int NIVEL_SUPERIOR = 6;
	private int nivel; 
	private char letra;
	private HashMap<String, Alumno> alumnos;
	
	public Grupo(int numero, char letra) throws ColegioException {
		if ( numero < NIVEL_INFERIOR || numero > NIVEL_SUPERIOR)
			throw new ColegioException("Nivel incorrecto " + numero);
		this.nivel = numero;
		this.letra = letra;
		alumnos=new HashMap<String,Alumno>();
	}
	public char getLetra() {
		return letra;
	}

	public int getNivel() {
		return nivel;
	}
	public void annadirAlumnoAGrupo(Alumno alumnoNuevo) throws ColegioException {
		if (alumnos.containsKey(alumnoNuevo.getDni())){
			throw new ColegioException("Ya existe el alumno en el grupo");
		}
		
		alumnos.put(alumnoNuevo.getDni(), alumnoNuevo);
	
	}

	public Alumno localizarAlumnoPorDni( String dni) {
		return alumnos.get(dni);
	}
	public boolean estaElAlumno ( String dni) {
		return alumnos.containsKey(dni);
	}
	
	//TODO
	public void eliminarAlumnoDeGrupo(String dniAlumnoAEliminar)  throws ColegioException{
		
	}
	
	
	//TODO
	public String toString() {
		return null;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + letra;
		result = prime * result + nivel;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (letra != other.letra)
			return false;
		if (nivel != other.nivel)
			return false;
		return true;
	}
	
	
	
	
}
