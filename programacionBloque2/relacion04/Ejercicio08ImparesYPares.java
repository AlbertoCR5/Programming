package relacion04;

import java.util.Scanner;

public class Ejercicio08ImparesYPares {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables
		// int numero;
		char respuesta;
		// boolean resultado;

		do {
			// numero = solicitarNumero();
			comprobarNumero(solicitarNumero());
			respuesta = solicitarMasNumeros();
		} while (respuesta == 'S');

		System.out.println("Adios");
	}

	private static char solicitarMasNumeros() {

		char respuesta;

		System.out.println("Desea introducir mas numeros");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

	private static void comprobarNumero(int numero) {

		if (numero % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}

	}

	private static int solicitarNumero() {

		int numero;

		System.out.println("Introduce un numero");
		numero = Integer.parseInt(teclado.nextLine());

		return numero;

	}

}
