package relacion05;

import java.util.Scanner;

public class Ejercicio09SumaDeNumerosEnUnaCadenaV2 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena;
		int sumaNumerosEnCadena;

		cadena = solicitarCadena();
		sumaNumerosEnCadena = tratarCadena(cadena);

		System.out.println("La suma de los numeros que se encuentran en la cadena es: " + sumaNumerosEnCadena);
	}

	/**
	 * Metodo que solicita una cadena de caracters
	 * @return cadena
	 */
	private static String solicitarCadena() {

		String cadena;

		System.out.println("Introduce una cadena de caracteres");
		cadena = teclado.nextLine();

		return cadena;
	}

	/**
	 * Metodo que recibe una cadena como parametro, y esta la desglosa en caracteres, añadiendo a un StringBuilder si son numeros,
	 * y borrandolo una vez que se encuentra con un caracter distinto de digito
	 * @param cadena
	 * @return sumaNumerosEnCadena
	 */
	private static int tratarCadena(String cadena) {

		int numero = 0, sumaNumerosEnCadena = 0;
		char caracterRecogido;
		boolean esDigito;
		StringBuilder sbNumero = new StringBuilder();

		for (int i = 0; i < cadena.length(); i++) {

			caracterRecogido = recogerCaracterDeLaCadena(cadena, i);
			esDigito = comprobarCaracter(caracterRecogido);

			if (!esDigito) {
				sumaNumerosEnCadena = sumaNumerosEnCadena + numero;
				numero = 0;
				sbNumero.delete(0, sbNumero.length());
			} else {
				sbNumero.append(caracterRecogido);
				numero = Integer.parseInt(sbNumero.toString());
			}
		}
		sumaNumerosEnCadena = sumaNumerosEnCadena + numero;

		return sumaNumerosEnCadena;
	}

	/**
	 * metodo que recibe la cadena, y la posicion del contador
	 * @param cadena
	 * @param i
	 * @return caracter
	 */
	private static char recogerCaracterDeLaCadena(String cadena, int i) {

		char caracter;

		caracter = cadena.charAt(i);

		return caracter;
	}
	
	/**
	 * Metodo que comprueba si el caracter es digito o no
	 * @param caracterRecogido
	 * @return esDigito, true o false
	 */
	private static boolean comprobarCaracter(char caracterRecogido) {

		boolean esDigito = false;

		if (Character.isDigit(caracterRecogido)) {
			esDigito = true;
		}

		return esDigito;
	}
}