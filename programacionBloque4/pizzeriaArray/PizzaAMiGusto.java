package pizzeriaArray;

public class PizzaAMiGusto {

	private static final int MAXIMO_INGREDIENTES = 5;
	private Ingrediente[] ingredientes;
	
	public PizzaAMiGusto() {
		ingredientes=new Ingrediente[MAXIMO_INGREDIENTES];
	}
	
	//TODO
	/**
	 * 
	 * @param nuevoIngrediente
	 * @throws PizzaException si ya no se pueden añadir más ingredientes
	 */
	public void annadirIngrediente(Ingrediente nuevoIngrediente) throws PizzaException {
		
		boolean esAnnadible = false;
		
		for (int i = 0; i < ingredientes.length && !esAnnadible; i++) {
			
			if (ingredientes[i] == null) {
				ingredientes[i] = nuevoIngrediente;
				esAnnadible = true;
			}
		}
	}
	
	//TODO
	/**
	 * 
	 * @param ingredienteAEliminar
	 * @throws PizzaException si no se encuentra el ingrediente a eliminar
	 */
	public void eliminarIngrediente(Ingrediente ingredienteAEliminar) throws PizzaException{
		
		boolean esIngrediente = false;
		
		for (int i = 0; i < ingredientes.length; i++) {
			
			if (ingredientes[i].equals(ingredienteAEliminar)) {
				ingredientes[i] = null;
				esIngrediente = true;
			}
		}
		
		if (!esIngrediente) {
			throw new PizzaException("ERROR, El ingrediente " + ingredienteAEliminar + " no esta añadido");
		}
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();

		sb.append("Pizza con ingredientes: ");
		for (int i = 0; i < ingredientes.length; i++) {
			
			if (ingredientes[i]!=null) {
				sb.append(ingredientes[i] + " ");
			}
		}
		return sb.toString();
	}
	
}
