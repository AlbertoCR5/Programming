package ejercicioExtra01Pizzeria;

import java.util.LinkedList;

public class ColaPedidos {
	private LinkedList<Pedido> listaDePedidos;
	
	public ColaPedidos(){
		listaDePedidos = new LinkedList<Pedido>();
	}
	
	public void agregarPedido(Pedido nuevoPedido){
		listaDePedidos.offer(nuevoPedido);
	}
	
	public Pedido atenderPedido() throws PizzaException{
		
		Pedido pedido;
		
		if(listaDePedidos.size() == 0) {
			throw new PizzaException("Error, no hay ningun pedido en cola");
		}
		pedido = listaDePedidos.poll();
		
		return pedido;	
	}

	
	public int numeroDePedidosEnCola() {
		
		return listaDePedidos.size();	
	}
	
	

}
