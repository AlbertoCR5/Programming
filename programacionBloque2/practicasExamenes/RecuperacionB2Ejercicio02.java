package practicasExamenes;

import java.util.Scanner;

public class RecuperacionB2Ejercicio02 {

	private static final String VOCALES = "aeiouAEIOU";

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena, nuevaCadena;

		cadena = solicitarCadena();
		nuevaCadena = desglosarCadena(cadena);

		System.out.print("La cadena resultado es: " + nuevaCadena);

	}

	private static String solicitarCadena() {

		String cadena;

		System.out.print("Introduce una cadena: ");
		cadena = teclado.nextLine();

		return cadena;
	}

	private static String desglosarCadena(String cadena) {

		String nuevaCadena;
		StringBuilder consonantes = new StringBuilder();
		StringBuilder vocales = new StringBuilder();
		boolean esVocal;
		char caracter;

		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);

			if (Character.isLetter(caracter)) {
				esVocal = comprobarCaracter(caracter);

				if (esVocal) {
					vocales.append(caracter);
				} else {
					consonantes.append(caracter);
				}
			}

		}

		if (consonantes.length() > 0) {
			consonantes.delete(1, consonantes.length());
		}
		if (vocales.length() > 0) {
			vocales.delete(0, vocales.length() - 1);
		}

		nuevaCadena = consonantes.toString().concat(vocales.toString());

		return nuevaCadena;
	}

	private static boolean comprobarCaracter(char caracter) {

		boolean esVocal = false;

		for (int i = 0; i < VOCALES.length(); i++) {

			if (VOCALES.contains(String.valueOf(caracter))) {
				esVocal = true;
			} else {
				esVocal = false;
			}
		}

		return esVocal;

	}
}