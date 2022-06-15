package practicasExamenes;
import java.util.Scanner;

public class Practica01 {
	
	private final static int EXAMENES_EVALUACION = 2;
	private final static int NOTA_MINIMA = 0;
	private final static int NOTA_MAXIMA = 10;
	private final static int NOTA_CORTE = 3;
	private final static int PUNTOS_NO_APTO = -2;
	private final static char APTO = 'A';
	private final static char NO_APTO = 'N';
	
	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		double notaExamen1, notaExamen2, notaFinal;
		char trabajoEntregado;

		do {
			System.out.println("Introduce las notas de los examenes");
			notaExamen1 = Double.parseDouble(teclado.nextLine()); 
			notaExamen2 = Double.parseDouble(teclado.nextLine()); 
		} while ((notaExamen1 < NOTA_MINIMA) || (notaExamen1 > NOTA_MAXIMA) || (notaExamen2 < NOTA_MINIMA) || (notaExamen2 > NOTA_MAXIMA));

		do {
			System.out.println("Introduce la valoraci�n del trabajo");
			trabajoEntregado = teclado.nextLine().charAt(0);
			trabajoEntregado = Character.toUpperCase(trabajoEntregado);
		} while (trabajoEntregado != APTO && trabajoEntregado != NO_APTO);
		
		if (notaExamen1 > NOTA_CORTE && notaExamen2 > NOTA_CORTE) {
			notaFinal = (notaExamen1 + notaExamen2) / EXAMENES_EVALUACION; 
		}
		else {
			if (notaExamen1 < notaExamen2) {
				notaFinal = notaExamen1;
			}
			else {
				notaFinal = notaExamen2;
			}	
		}
		
		if (trabajoEntregado == NO_APTO) {
			notaFinal = PUNTOS_NO_APTO + notaFinal;
		}
		if (notaFinal < NOTA_MINIMA) {
			notaFinal = NOTA_MINIMA;
		}
		System.out.println("La nota final del alumno es: " + notaFinal);
	}

}
