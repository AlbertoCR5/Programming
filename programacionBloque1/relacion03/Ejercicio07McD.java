package relacion03;

import java.util.Scanner;

public class Ejercicio07McD {

	private static final int VALOR_MINIMO = 0;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int dividendo, divisor, numero, numero2, resto = 1;

		do {
			System.out.println("Introduce dos números");
			numero = teclado.nextInt();
			numero2 = teclado.nextInt();
		} while (numero <= VALOR_MINIMO || numero2 <= VALOR_MINIMO);
		

		if (numero < numero2) {

			divisor = numero2;
			dividendo = numero;
		} else {
			dividendo = numero2;
			divisor = numero;
		}
		while (resto != VALOR_MINIMO) {

			resto = divisor - (divisor / dividendo) * dividendo;

			divisor = dividendo;
			dividendo = resto;
		
		}
		System.out.println("El M.c.d de " + numero + " y " + numero2 + " es " + divisor);

	}

}
