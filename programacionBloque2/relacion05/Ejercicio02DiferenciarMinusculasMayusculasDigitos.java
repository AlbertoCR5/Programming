package relacion05;

import java.util.Scanner;

public class Ejercicio02DiferenciarMinusculasMayusculasDigitos {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena;

		System.out.println("Introduce una cadena de caracteres");
		cadena = teclado.nextLine();

		diferenciarCaracteres(cadena);

	}

	/**
	 * Metodo que recoge una cadena de caracteres y diferencia minusculas, mayusculas y digitos.
	 * @param cadena
	 */
	private static void diferenciarCaracteres(String cadena) {

		int cantidadMayusculas = 0, cantidadMinusculas = 0, cantidadDigitos = 0, noAlfanumericos = 0;
		char caracter;

		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			// *Importante diferenciar digito de letras, xq los digitos los recoge como mayusculas.
			if (Character.isLetter(caracter)) {

				if (Character.isLowerCase(caracter)) {
					cantidadMinusculas++;
				} else {
					cantidadMayusculas++;
				}
			} else {
				if (Character.isDigit(caracter)) {
					cantidadDigitos++;
				} else {
					noAlfanumericos++;
				}
			}

		}

		System.out.println("Cantidad digitos: " + cantidadDigitos);
		System.out.println("Cantidad minusculas: " + cantidadMinusculas);
		System.out.println("Cantidad mayusculas: " + cantidadMayusculas);

		if (noAlfanumericos > 0) {
			System.out.println("Tambien hay " + noAlfanumericos + " caracter/es no alfanumerico/s");
		}

	}

}