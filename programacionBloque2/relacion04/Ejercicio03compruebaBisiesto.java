package relacion04;

import java.util.Scanner;

public class Ejercicio03compruebaBisiesto {
	
	private static final int VALOR_MINIMO = 0;
	private static final int MULTIPLO_4 = 4;
	private static final int MULTIPLO_100 = 100;
	private static final int MULTIPLO_400 = 400;
	private static final char AFIRMATIVO = 'S';
	

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		char respuesta;

		do {
			comprobarAnio(soliciarAnio());
			respuesta = solicitarMasAnio();
		} while (respuesta == AFIRMATIVO);
		
		System.out.println("Adios");
	}

	private static char solicitarMasAnio() {
		
		char respuesta;
		
		System.out.println("Quiere introducir mas años?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

	private static void comprobarAnio(int anio) {
	

		if (anio % MULTIPLO_400 == VALOR_MINIMO) {
			System.out.println("Es bisiesto");
		} else {
			if (anio % MULTIPLO_4 != VALOR_MINIMO || anio % MULTIPLO_100 == 0) {
				System.out.println("No es bisiesto");
			} else {
				System.out.println("Es bisiesto");
			}
		}

	}

	private static int soliciarAnio() {

		int anio;

		do {
			System.out.println("Introduce un año y te diré si es bisiesto");
			anio = Integer.parseInt(teclado.nextLine());
		} while (anio < VALOR_MINIMO);

		return anio;
	}

}