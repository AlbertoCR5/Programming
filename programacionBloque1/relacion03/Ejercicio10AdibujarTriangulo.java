package relacion03;

import java.util.Scanner;

public class Ejercicio10AdibujarTriangulo {
	
	private static final int VALOR_MINIMO = 0;
	private static final char CARACTER = '*';
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int base;
		
		do {
			System.out.println("Introduce un numero impar");
			base = teclado.nextInt();
		} while (base % 2 == VALOR_MINIMO);
		
		for (int i = 1; i <= base; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(CARACTER);
			}
			i++;
			System.out.println();
		}
	}

}
