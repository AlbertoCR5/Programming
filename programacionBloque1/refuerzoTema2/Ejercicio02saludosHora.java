package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio02saludosHora {

	private static final int VALOR_MINIMO = 0;
	private static final int HORA_MAXIMA = 24;
	private static final int TRAMO_DIA = 6;
	private static final int TRAMO_TARDE = 13;
	private static final int TRAMO_NOCHE = 21;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int hora;

		do {
			System.out.println("Introduce la hora");
			hora = teclado.nextInt();
		} while (hora < VALOR_MINIMO || hora >= HORA_MAXIMA);

		if (hora >= TRAMO_DIA && hora < TRAMO_TARDE) {
			System.out.println("Buenos días");
		} else {
			if (hora >= TRAMO_TARDE && hora < TRAMO_NOCHE) {
				System.out.println("Buenas tardes");
			} else {
				System.out.println("Buenas noches");
			}
		}

	}

}
