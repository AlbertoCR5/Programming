package relacion02;
import java.util.Scanner;

public class Ejercicio02tablaMultiplicar {

	private final static int MINIMO_NUMERO = 0;
	private final static int LIMITE_NUMERO = 10;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;
		int contador = 0;

		do {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();

			while (contador <= LIMITE_NUMERO) {
				System.out.println(numero + " * " + contador + " = " + numero * contador);
				contador++;
			}

		} while (numero < MINIMO_NUMERO || numero > LIMITE_NUMERO);

	}

}
