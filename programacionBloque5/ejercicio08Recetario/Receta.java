package ejercicio08Recetario;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Receta implements Comparable<Receta>{
	
	private String nombreReceta;
	private int minutosDePreparacion;
	private HashSet<Ingrediente> ingredientes;
	private LinkedList<String> pasos;
	
	public Receta(String nombreReceta, int minutosPreparacion) throws RecetaException {
		this.nombreReceta = nombreReceta.toUpperCase();
		setMinutosDePreparacion(minutosPreparacion);
		ingredientes=new HashSet<Ingrediente>();
		pasos=new LinkedList<String>();
	}

	public int getMinutosDePreparacion() {
		return minutosDePreparacion;
	}

	public void setMinutosDePreparacion(int minutosDePreparacion) throws RecetaException {
		if (minutosDePreparacion <=0) {
			throw new RecetaException("Minutos incorrectos");
		}
		this.minutosDePreparacion = minutosDePreparacion;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}
	
	public void annadirPasoAlFinal(String paso) {
		pasos.add(paso.toUpperCase());
	}

	public void annadirIngrediente(Ingrediente ingredienteNuevo) {

		boolean esAnadido = false;
		Ingrediente ingredienteColeccion;
		int nuevaCantidad;
		Iterator<Ingrediente> iterator = ingredientes.iterator();
		
		while (iterator.hasNext() && !esAnadido) {
			ingredienteColeccion = iterator.next();
			
			if (ingredienteNuevo.equals(ingredienteColeccion)) {
				nuevaCantidad = ingredienteNuevo.getCantidad() + ingredienteColeccion.getCantidad();
				ingredienteColeccion.setCantidad(nuevaCantidad);
				esAnadido = true;
			}
		}
		
		if (!esAnadido) {
			ingredientes.add(ingredienteNuevo);
		}
	}
	
	public boolean necesitaIngrediente(String nombreIngrediente) {
		
		Ingrediente ingredienteBuscado = new Ingrediente(nombreIngrediente);
		
		return ingredientes.contains(ingredienteBuscado);
	}
	
	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{
		
		String paso;
		
		if (!ingredientes.contains(ingredienteABorrar)) {
			throw new RecetaException("Error, no se encuentra el ingrediente buscado");
		}
		
		ingredientes.remove(ingredienteABorrar);
		
		Iterator<String> it = pasos.iterator();
		
		while (it.hasNext()) {
			paso =  it.next();
			
			if (paso.contains(ingredienteABorrar.getNombreIngrediente())) {
				it.remove();
			}
		}
	}
	

	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{
		
		int indice = pasos.indexOf(pasoExistente);

		if (indice == -1) {
			throw new RecetaException("Error, no se encuentra el paso " + pasoExistente);
		}
		
		pasos.add(indice+1, pasoNuevo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReceta == null) ? 0 : nombreReceta.hashCode());
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
		Receta other = (Receta) obj;
		if (nombreReceta == null) {
			if (other.nombreReceta != null)
				return false;
		} else if (!nombreReceta.equals(other.nombreReceta))
			return false;
		return true;
	}

	@Override
	public int compareTo(Receta otro) {
		
		return this.getNombreReceta().compareTo(otro.getNombreReceta());
	}
	
}