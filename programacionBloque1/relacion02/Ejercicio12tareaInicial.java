package relacion02;

import java.util.Scanner;

public class Ejercicio12tareaInicial {

	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroInicio;
		int numeroFin;

		do {
			System.out.println("Introduce dos numeros");
			numeroInicio = teclado.nextInt();
			numeroFin = teclado.nextInt();
		} while (numeroInicio <= MINIMO_NUMERO || numeroFin <= MINIMO_NUMERO);

		if (numeroInicio < numeroFin) {
			numeroInicio = numeroInicio + 1;
			while (numeroInicio < numeroFin) {
				System.out.println(numeroInicio);
				numeroInicio++;
			}

		} else {
			numeroInicio = numeroInicio - 1;

			while (numeroInicio > numeroFin) {
				System.out.println(numeroInicio);
				numeroInicio--;
			}

		}

	}

}