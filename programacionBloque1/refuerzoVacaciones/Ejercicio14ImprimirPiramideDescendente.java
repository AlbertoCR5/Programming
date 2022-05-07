package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio14ImprimirPiramideDescendente {

	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;

		do {
			System.out.println("Introduce un numero no negativo");
			numero = Integer.parseInt(teclado.nextLine());
		} while (numero < VALOR_MINIMO);

		for (int i = numero; i > VALOR_MINIMO; i--) {

			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}

			System.out.println();
			System.out.println();

		}
	}
}