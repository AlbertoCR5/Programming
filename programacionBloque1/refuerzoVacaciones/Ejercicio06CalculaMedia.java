package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio06CalculaMedia {

	private static final int FINALIZAR_PROGRAMA = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, cantidadNumeros = -1;
		double media = 0;

		do {
			System.out.print("Introduce un numero (" + FINALIZAR_PROGRAMA + " para terminar): ");
			numero = Integer.parseInt(teclado.nextLine());
			cantidadNumeros++;
			media = media + numero;
		} while (numero != FINALIZAR_PROGRAMA);

		media = media / cantidadNumeros;

		System.out.println("La media de los numeros es " + media);
	}

}