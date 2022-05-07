package refuerzoTema1;
/*Realizar un programa que pregunte el número de partidos jugados en esta jornada.
Luego para cada uno de las jornadas debe preguntar el número de goles del
equipo local y del equipo visitante y el programa debe determinar el resultado de la
quiniela. Debe asegurarse que los valores son correctos.*/

import java.util.Scanner;

public class Tema1Refuerzo07 {

	private static final char VICTORIA = '1';
	private static final char EMPATE = 'X';
	private static final char DERROTA = '2';
	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int partidos, golesLocal, golesVisitante;
		char resultado;

		do {
			System.out.println("Introduce el numero de partidos que se han jugado");
			partidos = teclado.nextInt();
		} while (partidos <= VALOR_MINIMO);

		for (int i = 1; i <= partidos; i++) {
			do {
				System.out.println("introduce los goles del equipo local del partido " + i);
				golesLocal = teclado.nextInt();

				System.out.println("introduce los goles del equipo visitante del partido " + i);
				golesVisitante = teclado.nextInt();
			} while (golesLocal < VALOR_MINIMO || golesVisitante < VALOR_MINIMO);

			if (golesLocal > golesVisitante) {
				resultado = VICTORIA;
			} else {
				if (golesLocal < golesVisitante) {
					resultado = DERROTA;
				} else {
					resultado = EMPATE;
				}
			}
			System.out.println("EL resultado de la quiniela del partido " + i + " es:" + resultado);
		}

	}

}
