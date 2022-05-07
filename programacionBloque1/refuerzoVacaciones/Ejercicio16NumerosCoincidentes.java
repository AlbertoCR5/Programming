package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio16NumerosCoincidentes {

	private static final int DIVISOR = 10;
	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroA, numeroB, coincidenteA = 0, coincidenteB = 0;
		int cantidadCifras;
		
		do {
			System.out.println("Introduce un numero positivo");
			numeroA = Integer.parseInt(teclado.nextLine());
		} while (numeroA <= VALOR_MINIMO);
		int auxiliarA = numeroA;
		
		do {
			System.out.println("Introduce otro numero positivo");
			numeroB = Integer.parseInt(teclado.nextLine());
		} while (numeroB <= VALOR_MINIMO);
		int auxiliarB = numeroB;
		
		do {
			System.out.println("Introduce las cifras para comprobar si estas son n-coincidentes");
			cantidadCifras = Integer.parseInt(teclado.nextLine());
		} while (cantidadCifras <= VALOR_MINIMO);
		
		for (int i = 1; i <= cantidadCifras; i++) {
			
			coincidenteA = coincidenteA + numeroA % DIVISOR;
			coincidenteB = coincidenteB + numeroB % DIVISOR;
			numeroA = numeroA / DIVISOR;
			numeroB = numeroB / DIVISOR;

		}
		
		if (coincidenteA == coincidenteB) {
			System.out.println(auxiliarA + " y " + auxiliarB + " son n-coincidentes");
		}
		else {
			System.out.println(auxiliarA + " y " + auxiliarB + " no son n-coincidentes");
		}

	}
}