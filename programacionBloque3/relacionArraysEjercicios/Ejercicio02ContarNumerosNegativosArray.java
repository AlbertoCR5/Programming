package relacionArraysEjercicios;

import java.util.Scanner;

public class Ejercicio02ContarNumerosNegativosArray {
	
	private static final int VALOR_MINIMO = 0;
	private static final int CANTIDAD_NUMEROS = 20;
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numeros[] = new int [CANTIDAD_NUMEROS];

		Ejercicio01MostrarArrayInverso.solicitarNumeros(numeros);
		contarNegativos(numeros);
	}


	private static void contarNegativos(int[] numeros) {
		
		int negativos = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < VALOR_MINIMO) {
				negativos++;
			}
		}
		System.out.println("Hay un total de " + negativos + " numeros negativos");
	}

}
