package relacion03;

import java.util.Scanner;

public class Ejercicio06alumnosAprobados {
	
	private static final int VALOR_MINIMO = 0;
	private static final int NOTA_CORTE = 5;
	private static final int NOTA_MAXIMA = 10;
	private static final int MAXIMO_ALUMNOS = 30;
	private static final int POR_CIENTO = 100;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numeroAlumnos, aprobado, suspenso = 0; 
		double nota, porcentaje;

		do {
			System.out.println("Introduce el numero de alumnos de la clase");
			numeroAlumnos = Integer.parseInt(teclado.nextLine());
		} while (numeroAlumnos <= VALOR_MINIMO || numeroAlumnos > MAXIMO_ALUMNOS);

		
		for (int i = 1; i <= numeroAlumnos; i++) {
			do {
				System.out.println("Introduce la nota del alumno " + i + "/" + numeroAlumnos);
				nota = Integer.parseInt(teclado.nextLine());			
			} while (nota < VALOR_MINIMO || nota > NOTA_MAXIMA);
			
			if (nota < NOTA_CORTE) {
				suspenso++;
			}
		
		}
		
		aprobado = numeroAlumnos - suspenso;
		
		porcentaje = aprobado * POR_CIENTO / numeroAlumnos;
		System.out.println("Han aprobado un total de " + aprobado + " alumnos. El " + porcentaje + "% de los alumnos.");
		
		porcentaje = POR_CIENTO - porcentaje;
		System.out.println("Han suspendido un total de " + suspenso + " alumnos. El " + porcentaje + "% de los alumnos.");
	}

}
