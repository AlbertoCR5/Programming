package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio15SerieDobleMasUno {

	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;
		int dobleMasUno = 0;
		
		do {
			System.out.println("Introduce el termino a obtener");
			numero = Integer.parseInt(teclado.nextLine());
		} while (numero <= VALOR_MINIMO);
		
		System.out.print("La serie seria:");
		
		for (int i = 1; i <= numero; i++) {

			dobleMasUno = dobleMasUno * 2 + 1;
			System.out.print(" " +dobleMasUno + ",");

		}
		System.out.println("...");
		System.out.println("El termino " + numero + " de la serie es el " + dobleMasUno);
	}
}