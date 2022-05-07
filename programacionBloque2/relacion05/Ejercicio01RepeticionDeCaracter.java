package relacion05;

import java.util.Scanner;

public class Ejercicio01RepeticionDeCaracter {

	public static Scanner teclado = new Scanner (System.in);
	
	public static void main(String[] args) {

		int cantidadApariciones;

		cantidadApariciones = buscarCaracter();

		System.out.println("El caracter buscado aparece en " + cantidadApariciones + " veces.");
	}

	private static int buscarCaracter() {
	
		int cantidadApariciones = 0;
		char caracter;
		char caracterBuscado;
		String cadena;
		
		System.out.println("Introduce una cadena de caracteres");
		cadena = teclado.nextLine().toUpperCase();
		
		System.out.println("Introduce caracter a buscar");
		caracterBuscado = teclado.nextLine().toUpperCase().charAt(0);	
		
		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			
			if (caracter == caracterBuscado) {
				cantidadApariciones++;
			}
		}
		
		return cantidadApariciones;
				
	}


}