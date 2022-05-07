package relacionArraysEjercicios;

import java.util.Scanner;

public class Ejercicio03DesgloseNumerosAleatoriosArray {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Introduce la cantidad de numeros que se van a solicitar");
		int cantidadNumeros = Integer.parseInt(teclado.nextLine());
		int numeros[] = new int[cantidadNumeros];

		Ejercicio01MostrarArrayInverso.solicitarNumeros(numeros);
		desglosarNumeros(numeros);
		calcularMedia(numeros);

	}

	private static void desglosarNumeros(int[] numeros) {

		int numeroMayor = Integer.MIN_VALUE;
		int numeroMenor = Integer.MAX_VALUE;

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < numeroMenor) {
				numeroMenor = numeros[i];
			}

			if (numeros[i] > numeroMayor) {
				numeroMayor = numeros[i];
			}
		}
		System.out.println("El " + numeroMayor + " es el mayor numero introducido");
		System.out.println("El " + numeroMenor + " es el menor numero introducido");
		comprobarRepeticionesNumeroMenorYMayor(numeros, numeroMenor, numeroMayor);
	}

	public static void calcularMedia(int[] numeros) {

		int media = 0;

		for (int i = 0; i < numeros.length; i++) {
			media = media + numeros[i];
		}
		media = media / numeros.length;

		System.out.println("La media de los numeros introducidos es: " + media);
	}

	private static void comprobarRepeticionesNumeroMenorYMayor(int[] numeros, int numeroMenor, int numeroMayor) {

		int repeticionesNumeroMayor = 0;
		int repeticionesNumeroMenor = 0;

		for (int i = 0; i < numeros.length; i++) {

			if (numeros[i] == numeroMenor) {
				repeticionesNumeroMenor++;
			}

			if (numeros[i] == numeroMayor) {
				repeticionesNumeroMayor++;
			}
		}

		if (repeticionesNumeroMenor > 1) {
			System.out.println("El " + numeroMenor + " se repite " + repeticionesNumeroMenor + " veces.");
		}

		if (repeticionesNumeroMayor > 1) {
			System.out.println("El " + numeroMayor + " se repite " + repeticionesNumeroMayor + " veces.");
		}

	}

}