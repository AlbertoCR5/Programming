package examen19MayoEjercicio1;
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
		
		boolean esEncontrado = false;
		Iterator<Grupo> it = grupos.iterator();
		Grupo grupoEncontrado = null;
		
		while (it.hasNext() && !esEncontrado) {
			Grupo grupo = (Grupo) it.next();
			if (grupo.getNivel() == nivel && grupo.getLetra() == letra) {
				grupoEncontrado = grupo;
				esEncontrado = true;
			}
			
		}
		return grupoEncontrado;
	}
	
	//TODO
	public void annadirGrupo (Grupo grupoNuevo) throws ColegioException {
		
		if (grupos.contains(grupoNuevo)) {
			throw new ColegioException("Grupo ya existente");
		}
		int posicion = buscarPosicion(grupoNuevo);
		grupos.add(posicion, grupoNuevo);
		
	}
	
	private int buscarPosicion(Grupo grupoNuevo) {
		
		int posicion = 0;
		boolean esEncontrado = false;
		Iterator<Grupo> it = grupos.iterator();
		
		while (it.hasNext() && !esEncontrado) {
			Grupo grupo = (Grupo) it.next();
			if (grupo.getNivel() > grupoNuevo.getNivel()) {
				esEncontrado = true;
			}
			else {
				posicion++;
			}
			
		}
		
		return posicion;
	}

	//TODO
	public List<Grupo> gruposDeUnNivel( int nivel) throws ColegioException{
		
		ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
		
		for (Grupo grupo : listaGrupos) {
			if (grupo.getNivel() == nivel) {
				listaGrupos.add(grupo);
			}
		}
		
		if (listaGrupos.size() == 0) {
			throw new ColegioException("No se encuentra ningun grupo del nivel " + nivel);
		}
		
		Collections.sort(listaGrupos);
		
		return listaGrupos;
	}
	
	//TODO
	public void cambiarAlumnoDeGrupo(int numero, char letra, String dniAlumno, 
			int numeroGrupoNuevo, char letraGrupoNuevo) throws ColegioException{
		
		Grupo grupoOriginal = localizarGrupo(numero, letra);
		Grupo grupoNuevo = localizarGrupo(numeroGrupoNuevo, letraGrupoNuevo);
		
		if (grupoOriginal == null) {
			throw new ColegioException("No se encuentra el grupo " + numero + letra);
		}
		
		if (grupoNuevo == null) {
			throw new ColegioException("No se encuentra el grupo " + numero + letra);
		}
		
		Alumno alumno = grupoOriginal.localizarAlumnoPorDni(dniAlumno);
		
		if (alumno == null) {
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
