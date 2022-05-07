package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio11ImprimePares {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroA, numeroB;

		
		System.out.print("Introduce el primer numero: ");
		numeroA = Integer.parseInt(teclado.nextLine());

		System.out.print("Introduce el segundo numero: ");
		numeroB = Integer.parseInt(teclado.nextLine());
	
		System.out.println("Los numeros pares comprendidos entre los numeros introducidos son:");
		
		for (int i = numeroA; i <= numeroB; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
			
	}

}
