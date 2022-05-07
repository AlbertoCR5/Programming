package practicasExamenes;

import java.util.Scanner;

public class ExamenCifraEnPosicion {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, posicion;
		char cifra;

		numero = solicitarNumero("Introduce un numero");
		posicion = solicitarNumero("Introduce una posicion");
		cifra = cifraEnPosicion(numero, posicion);

		if (cifra == 'n') {
			System.out.println("-1");
		} else {
			System.out.println("("+ numero + ", " + posicion + ") " + cifra);
		}

	}

	private static int solicitarNumero(String msg) {

		int numeroEntero;

		System.out.println(msg);
		numeroEntero = teclado.nextInt();

		return numeroEntero;
	}

	private static char cifraEnPosicion(int numero, int posicion) {

		char cifra;
		String cadena = String.valueOf(numero);
		StringBuilder sbCadena = new StringBuilder(cadena);
		sbCadena.reverse();

		if (posicion < 1 || posicion > sbCadena.length()) {
			cifra = 'n';
		} else {
			cifra = sbCadena.charAt(posicion - 1);
		}

		return cifra;
	}

}