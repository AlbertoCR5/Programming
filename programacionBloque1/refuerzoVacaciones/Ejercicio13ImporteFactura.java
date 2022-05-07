package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio13ImporteFactura {

	private static final char NEGATIVO = 'N';

	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int cantidadArticulos;
		double precioArticulo, factura = 0;
		char respuesta;
		
		do {
			do {
				System.out.print("Introduce la cantidad de articulos vendidos: ");
				cantidadArticulos = Integer.parseInt(teclado.nextLine());
			} while (cantidadArticulos <= VALOR_MINIMO);
			
			do {
				System.out.print("Introduce el precio unitario del articulo anterior: ");
				precioArticulo = Double.parseDouble(teclado.nextLine());
			} while (precioArticulo <= VALOR_MINIMO);
			
			factura = factura + cantidadArticulos * precioArticulo;
			
			System.out.print("Desea introducir mas articulos?: ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta != NEGATIVO);

		System.out.println("La factura total ascienda a " + factura + "€.");
		
	}

}
