package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio08MuestraNumeros {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroA, numeroB;
	
		System.out.print("Introduce un numero: ");
		numeroA = Integer.parseInt(teclado.nextLine());
		
		do {
			System.out.print("Introduce un numero (distinto del anterior): ");
			numeroB = Integer.parseInt(teclado.nextLine());
		} while (numeroA == numeroB);
		
		System.out.println("Los numeros de mayor a menor son:");
		if (numeroA > numeroB) {
			for (int i = numeroA; i >= numeroB; i--) {
				System.out.print(i + " ");
			}
		}
		else {
			for (int i = numeroB; i >= numeroA; i--) {
				System.out.print(i + " ");
			}
		}
	}

}
