package relacion03;

import java.util.Scanner;

public class Ejercicio2Ex4Nov {

	private static final char PARTIDO_A = 'A';
	private static final char PARTIDO_B = 'B';
	private static final char PARTIDO_C = 'C';
	private static final char AFIRMATIVO = 'S';

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		char partido, respuesta;
		int votantesA = 0, totalVotantes = 0;
		double porcentaje;
		
		do {
			
			do {	
				System.out.println("A qué partido vas a votar?");
				partido = teclado.nextLine().charAt(0);
				partido = Character.toUpperCase(partido);
			} while (!(partido == PARTIDO_A || partido == PARTIDO_B || partido == PARTIDO_C));
			
			totalVotantes++;
			
			if (partido == PARTIDO_A) {
				votantesA++;
			}
				
			System.out.println("Hay mas encuestados?");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);
		} while (respuesta == AFIRMATIVO);
		
		porcentaje =(double) votantesA / totalVotantes * 100;
		
		System.out.println("El porcentaje de personas que votarán al A es del " + porcentaje + "%.");
	}

}