package relacion02;

import java.util.Scanner;

public class Ejercicio08numeroMenor {

	private static final char SI = 'S';
	private static final char NO = 'N';

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;
		int numeroMenor = Integer.MAX_VALUE;
		char respuesta;

		do {
			System.out.println("introduce un número");
			numero = teclado.nextInt();
			
			do {
				System.out.println("¿Desea introducir mas numeros?");
				respuesta = teclado.next().charAt(0);
				respuesta = Character.toUpperCase(respuesta);
			} while (!(respuesta == SI || respuesta == NO));

			if (numero < numeroMenor) {
				numeroMenor = numero;
			}
			
		} while (respuesta == SI);

		System.out.println("El numero de menor valor introducido es el: " + numeroMenor);
	}

}
