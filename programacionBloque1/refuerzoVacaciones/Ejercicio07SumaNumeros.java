package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio07SumaNumeros {

	private static final int VALOR_MINIMO = 0;
	private static final int CANTIDAD_SUMAS = 100;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;

		do {
			System.out.print("Introduce un numero positivo: ");
			numero = Integer.parseInt(teclado.nextLine());
		} while (numero < VALOR_MINIMO);

		System.out.print("La suma de los numeros del " + numero + " al " + (numero + CANTIDAD_SUMAS) + " es ");

		for (int i = 0; i < CANTIDAD_SUMAS; i++) {
			numero = numero + i;
		}

		System.out.println(numero);
	}

}
