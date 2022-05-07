package relacion03;

import java.util.Scanner;

public class Ejercicio10BdibujarPiramide {
	

	private static final int VALOR_MINIMO = 0;
	private static final char CARACTER = '*';
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int base;
		
		do {
			System.out.println("Introduce un numero impar");
			base = teclado.nextInt();
		} while (base % 2 == VALOR_MINIMO);	

		for (int i = base; i >= 1; i--) {
			System.out.print(CARACTER);
			for (int j = 1; j <= i; j++) {
				System.out.print("p");
			}
			System.out.println();
			
		}
	}

}
