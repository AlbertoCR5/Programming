package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio18BinarioADecimal {

	private static final char APAGADO = '0';
	private static final char ENCENDIDO = '1';

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadenaBinario;
		int numeroDecimal;

		cadenaBinario = solicitarNumeroBinario("Introduce un numero binario");
		numeroDecimal = binarioADecimal(cadenaBinario);

		System.out.println("El numero " + cadenaBinario + " en decimal es el " + numeroDecimal);

	}

	private static String solicitarNumeroBinario(String binario) {

		String cadenaBinario;
		boolean esBinarioValido;

		do {
			System.out.println(binario);
			cadenaBinario = teclado.nextLine();
			esBinarioValido = comprobarCadenaIntroducida(cadenaBinario);
		} while (!esBinarioValido);

		return cadenaBinario;
	}

	private static boolean comprobarCadenaIntroducida(String numeroBinario) {

		boolean esBinarioValido = true;
		char caracter;

		for (int i = 0; i < numeroBinario.length() && esBinarioValido; i++) {
			caracter = numeroBinario.charAt(i);

			if (caracter != APAGADO && caracter != ENCENDIDO) {
				esBinarioValido = false;
			}

		}

		return esBinarioValido;
	}

	private static int binarioADecimal(String cadenaBinario) {

		int numeroDecimal = 0, digito, suma;
		char caracterDigito;

		for (int i = 0; i < cadenaBinario.length(); i++) {
			caracterDigito = cadenaBinario.charAt(i);
			if (caracterDigito == APAGADO) {
				suma = 0;
			} else {
				digito = Integer.parseInt(String.valueOf(caracterDigito));
				suma = 1;
				for (int j = cadenaBinario.length() - 1; j > i; j--) {
					suma = digito * 2 * suma;
				}
			}

			numeroDecimal = numeroDecimal + suma;

		}
		return numeroDecimal;
	}
}