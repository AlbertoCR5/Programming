package relacion03;

import java.util.Scanner;

public class Ejercicio08dibujarRectangulo {
	
	private static final int VALOR_MINIMO = 0;
	private static final char CARACTER = '*';
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int base, altura;
		
		do {
			System.out.println("Introduce dos números");
			base = teclado.nextInt();
			altura = teclado.nextInt();
		} while (base <= VALOR_MINIMO || altura <= VALOR_MINIMO);

		for (int i = 1; i <= altura; i++) {
			
			for (int j = 1; j <= base; j++) {
				System.out.print(CARACTER);	
			}
			
			System.out.println();
		}
		
	}

}
