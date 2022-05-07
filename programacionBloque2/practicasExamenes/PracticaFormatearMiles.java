package practicasExamenes;

import java.util.Scanner;

public class PracticaFormatearMiles {

	private static final String MILES = ".";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena, cadenaFormateada;
		boolean esNumerica;
		cadena = introducirCadena("Introduce una cadena numerica: ");
		esNumerica = comporbarCadena(cadena);
		
		if (esNumerica) {
			cadenaFormateada = formatearCadena(cadena);
			System.out.println(cadenaFormateada);
		}
		else {
			System.out.println("Error. La cadena no es numérica\r\n");
		}	

	}

	private static String formatearCadena(String cadena) {
		
		StringBuilder sbNumerica = new StringBuilder(cadena);		
		sbNumerica.reverse();
		
		for (int i = 3; i < sbNumerica.length(); i = i + 4) {
			sbNumerica.insert(i, MILES);
		}
		sbNumerica.reverse();
		
		return sbNumerica.toString();
	}


	private static boolean comporbarCadena(String cadena) {
		
		boolean esNumerica = true;
		char caracter;
		
		for (int i = 0; i < cadena.length() && esNumerica; i++) {
			caracter = cadena.charAt(i);
			if (!(Character.isDigit(caracter))) {
				esNumerica = false;
			}
		}
		return esNumerica;
	}


	private static String introducirCadena(String msg) {

		String cadena;

		System.out.print(msg);
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}

}