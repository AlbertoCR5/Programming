package relacion04;

import java.util.Scanner;

public class Ejercicio03compruebaBisiestoB {

	private static final int ANIO_ACTUAL = 2021;
	private static final int VALOR_MINIMO = 0;
	private static final int ANIO_MINIMO = 1582;
	private static final int ANIO_MAXIMO = 3882;
	private static final int MULTIPLO_4 = 4;
	private static final int MULTIPLO_100 = 100;
	private static final int MULTIPLO_400 = 400;
	private static final int CANTIDAD_COLUMNAS = 5;

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int columnas = 0;
		boolean esBisiesto;
		for (int i = 1300; i <= ANIO_ACTUAL; i++) {
			esBisiesto = comprobarAnio(i);

			if (esBisiesto) {
				columnas++;
				System.out.print(i + " ");
			}

			if (columnas == CANTIDAD_COLUMNAS) {
				System.out.println();
				columnas = 0;
			}
		}

	}

	public static boolean comprobarAnio(int i) {

		boolean esBisiesto = true;

		if (i < ANIO_MINIMO || i > ANIO_MAXIMO) {
			esBisiesto = false;
		} else {
			if (i % MULTIPLO_400 == VALOR_MINIMO) {
			} else {
				if (i % MULTIPLO_4 != VALOR_MINIMO || i % MULTIPLO_100 == 0) {
					esBisiesto = false;
				} else {
				}
			}
		}

		return esBisiesto;
	}

}