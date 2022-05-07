package practicasExamenes;

import java.util.Scanner;

public class ExamenCambiaConsonantesMayusMinus {

	private static final String VOCALES = "aeiouáéíóúAEIOUÁÉÍÓÚ";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena, nuevaCadena;

		cadena = "Este examen es MUY FACIL";
		nuevaCadena = cambiaConsonantesMayusculasMinusculas(cadena);

		System.out.println(nuevaCadena);

	}

	private static String cambiaConsonantesMayusculasMinusculas(String cadena) {

		StringBuilder sbNuevaCadena = new StringBuilder();
		char caracter;

		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			if (esConsonante(caracter) && Character.isUpperCase(caracter)) {
				caracter = Character.toLowerCase(caracter);
				sbNuevaCadena.append(caracter);
			}
			else {
				if (esConsonante(caracter) && Character.isLowerCase(caracter)) {
					caracter = Character.toUpperCase(caracter);
					sbNuevaCadena.append(caracter);
				}
				else {
					sbNuevaCadena.append(caracter);
				}
			}
			

		}

		return sbNuevaCadena.toString();
	}

	private static boolean esConsonante(char caracter) {

		boolean esConsonante = true;
		String vocal = VOCALES;

		if (vocal.contains(String.valueOf(caracter))) {
			esConsonante = false;
		}

		return esConsonante;
	}

}