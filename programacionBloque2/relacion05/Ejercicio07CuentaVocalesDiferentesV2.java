package relacion05;

import java.util.Scanner;

public class Ejercicio07CuentaVocalesDiferentesV2 {

	private static final String VOCALES = "AEIOU¡…Õ”⁄";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String texto;

		int vocalesDistintas;

		texto = introducirCadena("Introduce frase");
		vocalesDistintas = buscarVocal(texto);

		System.out.println(vocalesDistintas);
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

		for (int i = 0; i < VOCALES.length(); i++) {
			vocal = recogerVocal(texto, i);

			if (texto.contains(String.valueOf(vocal))) {
				vocalesDistintas++;
			}
		}

		return vocalesDistintas;
	}

	private static char recogerVocal(String texto, int i) {
		char vocal;

		vocal = VOCALES.charAt(i);

		return vocal;
	}
}