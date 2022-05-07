package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio03CalculaNota {

	private static final int VALOR_MINIMO = 0;
	private static final int TOTAL_NOTAS = 2;
	private static final int NOTA_MEDIA = 5;
	private static final char APTO = 'A';
	private static final char NO_APTO = 'N';

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double notas;
		double media = 0;
		char resultado;
		
		for (int i = 1; i <= TOTAL_NOTAS; i++) {
			do {
				System.out.println("Introduce la nota del examen " + i + "/" + TOTAL_NOTAS);
				notas = Double.parseDouble(teclado.nextLine());
			} while (notas <= VALOR_MINIMO );
			
			media = media + notas;
		}
		
		media = media / TOTAL_NOTAS;

		if (media < NOTA_MEDIA) {
			do {
				System.out.println("Cual ha sido el resultado de la recuperacion? A/N");
				resultado = teclado.nextLine().toUpperCase().charAt(0);
			} while (resultado != APTO && resultado != NO_APTO);
			
			if (resultado == APTO) {
				media = NOTA_MEDIA;
			}

		}
		
		
		System.out.println("La nota final del trimestre en programacion es de un " + media);
	}

}
