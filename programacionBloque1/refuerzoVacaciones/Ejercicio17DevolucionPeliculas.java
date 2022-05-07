package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio17DevolucionPeliculas {

	private static final int VALOR_MINIMO = 0;
	private static final int DIAS_ALQUILADO = 3;
	private static final int MESES = 12;
	private static final int DIAS_MES = 30;
	private static final double PRECIO_NORMAL = 1.20;
	private static final double PRECIO_REDUCIDO = 0.75;
	private static final double INCREMENTO_NOVEDAD = 0.04;
	private static final char AFIRMATIVO = 'S';
	private static final char NEGATIVO = 'N';
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double saldo, precio;
		int diaInicial, mesInicial, diaFinal, mesFinal, diferenciaFechas;
		char respuesta;

		do {
			System.out.println("Introduce el saldo inicial de la tarjeta");
			saldo = Integer.parseInt(teclado.nextLine());
		} while (saldo < VALOR_MINIMO);

		do {

			do {
				System.out.println("Introduce el dia del inicio del alquiler");
				diaInicial = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce el mes del inicio del alquiler");
				mesInicial = Integer.parseInt(teclado.nextLine());
			} while (diaInicial <= VALOR_MINIMO || diaInicial > DIAS_MES || mesInicial <= VALOR_MINIMO
					|| mesInicial > MESES);

			diferenciaFechas = diaInicial + mesInicial * DIAS_MES;

			do {
				System.out.println("Introduce el dia del fin del alquiler");
				diaFinal = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce el mes del fin del alquiler");
				mesFinal = Integer.parseInt(teclado.nextLine());
			} while (diaInicial <= VALOR_MINIMO || diaInicial > DIAS_MES || mesInicial <= VALOR_MINIMO
					|| mesInicial > MESES);

			diferenciaFechas = diaFinal + mesFinal * DIAS_MES - diferenciaFechas;

		} while (diferenciaFechas <= VALOR_MINIMO);

		do {
			System.out.println("Es una pelicula de estreno?");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta != AFIRMATIVO && respuesta != NEGATIVO);

		if (diferenciaFechas <= DIAS_ALQUILADO) {
			precio = diferenciaFechas * PRECIO_NORMAL;
		} else {
			precio = diferenciaFechas * PRECIO_REDUCIDO;
		}

		if (respuesta == AFIRMATIVO) {
			precio = precio + precio * INCREMENTO_NOVEDAD;
		}

		if (saldo >= precio) {
			System.out.println("Pelicula devuelta. Su saldo restante es " + (saldo - precio) + "€");
		} else {
			System.err.println("No se pudo devolver por falta de saldo");
		}
	}
}