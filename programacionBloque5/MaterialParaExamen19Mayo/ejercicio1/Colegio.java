package ejercicio1;
import java.util.LinkedList;
import java.util.List;

public class Colegio {

	private String nombre;
	private LinkedList<Grupo> grupos;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Colegio(String nombre) {
	
		this.nombre = nombre;
		grupos=new LinkedList<Grupo>();
		
	}
	
	//TODO
	public Grupo localizarGrupo( int nivel, char letra) {
		
		return null;
	}
	
	//TODO
	public void annadirGrupo (Grupo grupoNuevo) throws ColegioException {
		
	}
	
	//TODO
	public List<Grupo> gruposDeUnNivel( int nivel) throws ColegioException{
		
		return null;
	}
	
	//TODO
	public void cambiarAlumnoDeGrupo(int numero, char letra, String dniAlumno, 
			int numeroGrupoNuevo, char letraGrupoNuevo) throws ColegioException{
		
	}
	
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for ( Grupo grupo: grupos) {
			sb.append(grupo + "\n");
		}
		return sb.toString();
		
	}
	
}
