package ejercicioExtra01Pizzeria;

import java.util.HashSet;

public class Pedido {
	private String direccion;
	private HashSet<Pizza> pizzas;
	
	public Pedido(String direccion){
		setDireccion(direccion);
		pizzas = new HashSet<Pizza>();
	}
	
	public void agregarPizza(Pizza pizzaPedida){
		pizzas.add(pizzaPedida);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		
		StringBuilder sbInfo = new StringBuilder();
		
		sbInfo.append("Direccion del pedido: " + direccion);
		
			for (Pizza pizza : pizzas) {
				sbInfo.append("\n" + pizza + "\n");
			}
			
		return sbInfo.toString();		
	}	
}
