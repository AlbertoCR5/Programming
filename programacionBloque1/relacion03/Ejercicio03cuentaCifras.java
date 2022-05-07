package relacion03;

import java.util.Scanner;

public class Ejercicio03cuentaCifras {

	private static final int DIVISOR = 10;
	private static final int NUMERO_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, cuentaCifras = 0;

		System.out.println("Introduce un número");
		numero = teclado.nextInt();

		if (numero == 0) {
			cuentaCifras = 1;
		} else {
			
			while (numero > NUMERO_MINIMO) {
				numero = numero / DIVISOR;
				cuentaCifras++;
			}
		}

		System.out.println("El número introducido tiene " + cuentaCifras + " cifras");

	}

}
