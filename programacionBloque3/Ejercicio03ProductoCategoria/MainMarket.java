package Ejercicio03ProductoCategoria;

import java.util.Scanner;

public class MainMarket {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Producto producto = null;
		Categoria categoria;
		
		try {
			categoria = new Categoria("Drogueria", 21);
			producto = crearProducto(categoria);
			System.out.println(producto.precioConIVA());
			
		} catch (MarketException e) {
			mostrarMensaje(e.getMessage());
		}
		
		mostrarMensaje(producto.toString());
		
	}

	private static Producto crearProducto(Categoria categoria) throws MarketException {
		
		Producto crearProducto = null;
		double precioSinIVA;
		String descripcion;
		boolean error;
		
		do {
			error = false;
			try {
				mostrarMensaje("Introduce la descripcion del producto");
				descripcion = teclado.nextLine();
				mostrarMensaje("Introduce el precio del producto");
				precioSinIVA = Double.parseDouble(teclado.nextLine());
				crearProducto = new Producto (precioSinIVA, descripcion, categoria);
			} catch (NumberFormatException e) {
				mostrarMensaje(e.getMessage());
				error = true;
			}
			
		} while (error);
		
		return crearProducto;
	}

	private static void mostrarMensaje(String message) {
		
		System.out.println(message);
		
	}

}