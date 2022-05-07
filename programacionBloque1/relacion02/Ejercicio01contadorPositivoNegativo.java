package relacion02;
import java.util.Scanner;

public class Ejercicio01contadorPositivoNegativo {

	private final static int CANTIDAD_NUMEROS = 10;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double numero;
		int contador = 1;

		while (contador <= CANTIDAD_NUMEROS) {
			System.out.println("Introduce un número");
			numero = teclado.nextDouble();
			
			if (numero < 0) {
				System.out.println("Número negativo");
			} else {
				System.out.println("Número positivo");
			}
			contador++;
		}

	}

}
