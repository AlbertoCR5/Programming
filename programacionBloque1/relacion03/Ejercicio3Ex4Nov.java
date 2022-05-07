package relacion03;

import java.util.Scanner;

public class Ejercicio3Ex4Nov {

	private static final int ANTIGUEDAD_CORTA = 2;
	private static final int ANTIGUEDAD_LONGEVA = 5;
	private static final double PRECIO_ALTO = 4;
	private static final double PRECIO_MEDIO = 3.2;
	private static final double PRECIO_BAJO = 2;
	private static final double DESCUENTO_VIP = 0.05;
	private static final double DESCUENTO_SUPERVIP = 0.1;
	private static final char CLIENTE_VIP = 'V';
	private static final char CLIENTE_SUPERVIP = 'S';
	private static final int ANIO_ACTUAL = 2021;
	

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int anioVideojuego;
		double precioAlquiler;
		char tipoCliente;
		
		System.out.print("Introduce el año del videojuego: ");
		anioVideojuego = Integer.parseInt(teclado.nextLine());
		
		anioVideojuego = ANIO_ACTUAL - anioVideojuego;
		
		if (anioVideojuego < ANTIGUEDAD_CORTA) {
			precioAlquiler = PRECIO_ALTO;
		}
		else {
			if (anioVideojuego > ANTIGUEDAD_LONGEVA) {
				precioAlquiler = PRECIO_BAJO;
			}
			else {
				precioAlquiler = PRECIO_MEDIO;
			}
			
		}
		
		System.out.print("Introduce el tipo de cliente (N-normal, V-Vip S-SuperVip): ");
		tipoCliente = teclado.nextLine().charAt(0);
		tipoCliente = Character.toUpperCase(tipoCliente);
		
		if (tipoCliente == CLIENTE_SUPERVIP) {
			precioAlquiler = precioAlquiler - precioAlquiler * DESCUENTO_SUPERVIP;
		}
		else {
			if (tipoCliente == CLIENTE_VIP){
				precioAlquiler = precioAlquiler - precioAlquiler * DESCUENTO_VIP;
			}
			else {
				 //Preguntar precioAlquiler = precioAlquiler;
			}
		}
		
		System.out.println("El precio del alquiler es: " + precioAlquiler + " euros.");
	}

}