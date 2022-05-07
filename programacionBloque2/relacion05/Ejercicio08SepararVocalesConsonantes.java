package relacion05;

import java.util.Scanner;

public class Ejercicio08SepararVocalesConsonantes {

	private static final String VOCALES = "AEIOUÁEÍÓÚaeiouáéíóú";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena, nuevaCadena;

		cadena = introducirCadena("Introduce frase");
		nuevaCadena = consonantesYVocales(cadena);

		System.out.println(nuevaCadena);
	}

	private static String consonantesYVocales(String cadena) {

		StringBuilder sbConsonantes = new StringBuilder();
		StringBuilder sbVocales = new StringBuilder();
		char caracter;

		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);

			if (Character.isLetter(caracter)) {

				if (esVocal(caracter)) {
					sbVocales.append(caracter);
				} else {
					sbConsonantes.append(caracter);
				}
			}
		}
		sbConsonantes.append(sbVocales);

		return sbConsonantes.toString();
	}

	private static boolean esVocal(char caracter) {

		String vocal = VOCALES;
		boolean esVocal = false;

		if (vocal.contains(String.valueOf(caracter))) {
			esVocal = true;
		}
//		if (vocal.indexOf(caracter) >= 0) { Tambien funciona, pero no necesitas convertir el caracter en un String
//			esVocal = true;
//		}
		return esVocal;
	}

	private static String introducirCadena(String msg) {

		String cadena;

		System.out.println(msg);
		cadena = teclado.nextLine();

		return cadena;
	}
}