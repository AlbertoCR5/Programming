package practicasExamenes;

import java.util.Scanner;

public class RecuperacionB2Ejercicio01 {

	private static final int DIVISOR = 10;
	private static final int VALOR_MINIMO = 0;
	private static final char PALITO = 'I';
	private static final char SEPARADOR = '-';

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;
		String palitos;

		numero = solicitarNumero();
		palitos = convierteCifraAPalito(numero);

		System.out.println(palitos);

	}

	private static int solicitarNumero() {

		int numero;

		System.out.print("Introduce un numero: ");
		numero = Integer.parseInt(teclado.nextLine());

		return numero;
	}

	private static String convierteCifraAPalito(int numero) {

		StringBuilder palitos = new StringBuilder();
		int cifra;

		while (numero != VALOR_MINIMO) {
			cifra = numero % DIVISOR;
			numero = numero / DIVISOR;
			for (int i = VALOR_MINIMO; i < cifra; i++) {
				palitos.append(PALITO);
			}
			if (numero != VALOR_MINIMO) {
				palitos.append(SEPARADOR);
			}
		}

		return palitos.reverse().toString();
	}
}
