package relacion02;
import java.util.Scanner;

public class Ejercicio01contadorPositivoNegativo {

	private final static int CANTIDAD_NUMEROS = 10;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double numero;
		int contador = 1;

		while (contador <= CANTIDAD_NUMEROS) {
			System.out.println("Introduce un n�mero");
			numero = teclado.nextDouble();
			
			if (numero < 0) {
				System.out.println("N�mero negativo");
			} else {
				System.out.println("N�mero positivo");
			}
			contador++;
		}

	}

}
