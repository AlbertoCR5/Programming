package relacionArraysEjercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio04MenorMayorRepetidoMediaArray {

	private static final int VALOR_MINIMO = 0;
	private static final int CANTIDAD_NUMEROS = 60;
	private static final int DIVISOR = 10;
	private static final int NUMERO_MAXIMO = 100;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[CANTIDAD_NUMEROS];

		generarNumeros(numeros);
		Ejercicio03DesgloseNumerosAleatoriosArray.calcularMedia(numeros);
		comprobarUltimoDigito(numeros);

	}

	private static void generarNumeros(int[] numeros) {

		Random serie = new Random();

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = serie.nextInt(NUMERO_MAXIMO);
			System.out.println(numeros[i]);
		}

	}

	private static void comprobarUltimoDigito(int[] numeros) {

		int digitoMasRepetido = 0, auxiliarRepeticiones = 0;

		System.out.println();
		for (int j = 0; j < DIVISOR; j++) {
			int repeticionDigito = 0;
			for (int i = 0; i < numeros.length; i++) {

				if (numeros[i] % DIVISOR == j) {
					repeticionDigito++;
				}

			}

			if (repeticionDigito >= VALOR_MINIMO) {
				System.out.println("Ningun numero termina en " + j);
			} else {
				if (repeticionDigito > 1) {
					System.out.println("La ultima cifra " + j + " se repite " + repeticionDigito + " veces.");
				}
			}

			if (repeticionDigito > auxiliarRepeticiones) {
				auxiliarRepeticiones = repeticionDigito;
				digitoMasRepetido = j;
			}
		}
		System.out.println();
		System.out.println("La ultima cifra mas repetida es el " + digitoMasRepetido);

	}

}