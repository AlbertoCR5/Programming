package relacion03;

import java.util.Scanner;

public class EjercicioBaloncestoExamen2020 {
	
	private final static int PARTIDOS = 3;
	private final static int PUNTUACION_DIFERENCIA = 10;
	private final static int PUNTUACION_MAXIMA = 200;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int puntosLocal, puntosVisitante, partidosConDiferencia = 0;
		double porcentaje = 0;
		
		for (int i = 1; i <= PARTIDOS; i++) {
			
			do {
				System.out.println("Partido " + i);
				System.out.println("Introduce los puntos del equipo local");
				puntosLocal = teclado.nextInt();
				System.out.println("Introduce los puntos del equipo visitante");
				puntosVisitante = teclado.nextInt();
			} while ((puntosLocal + puntosVisitante) > PUNTUACION_MAXIMA || puntosLocal == puntosVisitante);
			
			if ((puntosLocal - puntosVisitante) > PUNTUACION_DIFERENCIA || (puntosVisitante - puntosLocal ) > PUNTUACION_DIFERENCIA) {
				partidosConDiferencia++;
			}
			
			if (puntosLocal > puntosVisitante) {
				porcentaje++;
			}
		}
			
		porcentaje = porcentaje / PARTIDOS * 100;
				
		System.out.println("El número de partidos en los que hay  más de 10 puntos de diferencia es: " + partidosConDiferencia);
		System.out.println("El porcentaje de partidos donde gana el local es: " + porcentaje);		
		
	}

}
