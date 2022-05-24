package ejercicio1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		boolean encontrado=false;
		Iterator<Grupo> it=grupos.iterator();
		Grupo grupoEncontrado=null;
		
		while (it.hasNext() && !encontrado) {
			Grupo grupo = it.next();
			if (grupo.getNivel()==nivel && grupo.getLetra()==letra) {
				grupoEncontrado=grupo;
				encontrado=true;
			}
			
		}
		
		return grupoEncontrado;
	}
	
	//TODO
	public void annadirGrupo (Grupo grupoNuevo) throws ColegioException {
		
		if ( grupos.contains(grupoNuevo)) {
			throw new ColegioException("Ya existe el grupo ");
		}
		
		int pos=buscarPosicion(grupoNuevo);
		grupos.add( pos, grupoNuevo);
		
	}
	
	private int buscarPosicion(Grupo grupoNuevo) {
		int pos=0;
		boolean encontrado=false;
		
		Iterator<Grupo> it=grupos.iterator();
		
		
		while (it.hasNext() && !encontrado) {
			Grupo grupo = it.next();
			if ( grupo.getNivel() > grupoNuevo.getNivel()) {
				encontrado=true;
			}
			else {
				pos++;
			}
		}
			
		return pos;
	}

	//TODO
	public List<Grupo> gruposDeUnNivel( int nivel) throws ColegioException{
		
		
		ArrayList<Grupo> listGrupos=new ArrayList<Grupo>();
		for ( Grupo grupo: grupos ) {
			if (grupo.getNivel()==nivel) {
				listGrupos.add(grupo);

			}
		}
		
		if (listGrupos.size() ==0) {
			throw new ColegioException("No se encuentra ningún grupo del nivel " + nivel);
		}
		Collections.sort(listGrupos);
		
		return listGrupos;
	}
	
	//TODO
	public void cambiarAlumnoDeGrupo(int numero, char letra, String dniAlumno, 
			int numeroGrupoNuevo, char letraGrupoNuevo) throws ColegioException{
		
		
		Grupo grupoOriginal=localizarGrupo(numero,letra);
		Grupo grupoNuevo=localizarGrupo(numeroGrupoNuevo,letraGrupoNuevo);
		
		if ( grupoOriginal==null) {
			throw new ColegioException("No se encuentra el grupo " +  numero + " - " + letra);
		}
		
		if ( grupoNuevo==null) {
			throw new ColegioException("No se encuentra el grupo " +  numeroGrupoNuevo + " - " + letraGrupoNuevo);
		}
		
		Alumno alumno=grupoOriginal.localizarAlumnoPorDni(dniAlumno);
		if (alumno==null) {
			throw new ColegioException("No se encuentra el alumno " + dniAlumno);
		}
		
		grupoOriginal.eliminarAlumnoDeGrupo(dniAlumno);
		grupoOriginal.annadirAlumnoAGrupo(alumno);
		
		
	}
	
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for ( Grupo grupo: grupos) {
			sb.append(grupo + "\n");
		}
		return sb.toString();
		
	}
	
}
