package relacion05;

import java.util.Scanner;

public class Ejercicio07CuentaVocalesDiferentes {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String texto;

		int vocalesDistintas;

		texto = introducirCadena("Introduce frase");
		vocales();
		vocalesDistintas = buscarVocal(texto);
		
		System.out.println(vocalesDistintas);
	}

	private static String vocales() {
		
		String vocales = "AEIOU¡…Õ”⁄";
		
		return vocales;
	}

	private static String introducirCadena(String msg) {

		String cadena;

		System.out.println(msg);
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}
	
	private static int buscarVocal(String texto) {
		
		char vocal;
		int vocalesDistintas = 0;

			for (int j = 0; j < vocales().length(); j++) {
				vocal = vocales().charAt(j);
				
				if (texto.indexOf(vocal) !=-1) {
					vocalesDistintas++;
				}
			}
		
		
		return vocalesDistintas;
	}
}