package relacion03;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio05cajaFuerte {

	private static final int NUMERO_MINIMO = 1000;
	private static final int LIMITE_INTENTOS = 5;
	private static final int NUMERO_LIMITE = 9999;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int combinacion, numero;
		boolean abrirCaja = false;
		Random serieAleatoria = new Random();

		combinacion = serieAleatoria.nextInt(NUMERO_LIMITE-1000) + NUMERO_MINIMO;
		System.out.println(combinacion);

		for (int i = 1; i <= LIMITE_INTENTOS && abrirCaja == false; i++) {

			System.out.println("Tienes " + (LIMITE_INTENTOS - i + 1) + " intentos");
			System.out.println("Introduce un número");
			numero = teclado.nextInt();

			if (numero != combinacion) {
				System.out.println("Lo siento, esa no es la combinación");
			} else {
				System.out.println("La caja fuerte se ha abierto satisfactoriamente");
				abrirCaja = true;
			}

		}
		
		if (!(abrirCaja)) {
			System.out.println("La caja fuerte se ha bloqueado definitivamente, llame al cerrajero");
		}
		
	}

}
