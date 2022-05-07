package relacionArraysEjercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio05GeneraNumerosDiferentesArray {

	private static final int VALOR_MINIMO = 0;
	private static final int CANTIDAD_NUMEROS = 6;
	private static final int NUMERO_MAXIMO = 49;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[CANTIDAD_NUMEROS];

		generarNumeros(numeros);
		mostrarNumerosLoteria(numeros);

	}

	private static void generarNumeros(int[] numeros) {

		Random serie = new Random();
		boolean esNumeroRepetido = false;

		for (int i = 0; i < numeros.length; i++) {
			do {
				numeros[i] = serie.nextInt(NUMERO_MAXIMO)+1;
				if (i != VALOR_MINIMO) {
					esNumeroRepetido = comprobarNumero(numeros, i);
				}

			} while (esNumeroRepetido);

		}

	}

	private static boolean comprobarNumero(int[] numeros, int i) {

		boolean esRepetido = false;

		for (int j = 0; j < i && esRepetido == false; j++) {

			if (numeros[i] == numeros[j]) {
				esRepetido = true;
			}
		}

		return esRepetido;
	}

	private static void mostrarNumerosLoteria(int[] numeros) {

		Arrays.sort(numeros);
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}

	}

}