package relacionArraysEjercicios;

import java.util.Scanner;

public class Ejercicio01MostrarArrayInverso {

	private static final int CANTIDAD_NUMEROS = 5;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[CANTIDAD_NUMEROS];

		solicitarNumeros(numeros);
		mostrarNumerosInverso(numeros);
	}

	public static void solicitarNumeros(int[] numeros) {

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce numero " + (i + 1) + "/" + CANTIDAD_NUMEROS);
			numeros[i] = Integer.parseInt(teclado.nextLine());
		}

	}

	private static void mostrarNumerosInverso(int[] numeros) {

		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.print(numeros[i] + " ");
		}

	}

}
