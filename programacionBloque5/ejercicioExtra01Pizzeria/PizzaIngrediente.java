package ejercicioExtra01Pizzeria;

import java.util.*;

public class PizzaIngrediente extends Pizza {

	private HashSet<Ingredientes> listaIngredientes;
	
	public PizzaIngrediente(Tamanho tamanho) {
		super(tamanho);
		listaIngredientes = new HashSet<Ingredientes>();
	}
	
	public void agregarIngrediente(Ingredientes ingrediente){
		listaIngredientes.add(ingrediente);
	}

	public String toString() {
		
		StringBuilder info = new StringBuilder();
		
		for (Ingredientes ingredientes : listaIngredientes) {
			info.append(ingredientes + "\n");
		}
		
		return super.toString() + "\nIngredientes:\n" + info.toString();
	}
	
}