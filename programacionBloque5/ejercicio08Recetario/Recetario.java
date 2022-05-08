package ejercicio08Recetario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class Recetario {

	private HashMap<String, Receta> recetas;
	
	public Recetario() {
		
		recetas=new HashMap<String,Receta>();	
	}
	
	public void annadirReceta( Receta nuevaReceta) throws RecetaException {
		
		if(recetas.containsKey(nuevaReceta.getNombreReceta())) {
			throw new RecetaException("Receta ya existente");
		}
		
		recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
	}
	
	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		
		StringBuilder sbListaRecetas = new StringBuilder();
		LinkedList<Receta> listaRecetasOrdenadas = new LinkedList<Receta>(recetas.values());
		
		Collections.sort(listaRecetasOrdenadas);
		
		for (Receta receta : listaRecetasOrdenadas) {
			sbListaRecetas.append(receta + "\n");
		}
		
		return sbListaRecetas.toString();	
	}
	
	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException{
		
		StringBuilder sbListaRecetasOrdenadasTiempo = new StringBuilder();
		ArrayList<Receta> listaRecetasConIngrediente = new ArrayList<Receta>();
		
		for (Receta receta : recetas.values()) {
			if (receta.necesitaIngrediente(ingrediente)) {
				listaRecetasConIngrediente.add(receta);
			}
		}
		
		Collections.sort(listaRecetasConIngrediente, new Comparator<Receta>() {
			
			public int compare(Receta receta1, Receta otra) {
				
				return Integer.compare(receta1.getMinutosDePreparacion(), otra.getMinutosDePreparacion());
			}
		});
		
		for (Receta receta : listaRecetasConIngrediente) {
			sbListaRecetasOrdenadasTiempo.append(receta + "\n");
		}
		
		return sbListaRecetasOrdenadasTiempo.toString();
		
	}
}
