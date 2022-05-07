package relacion02;
import java.util.Scanner;

public class Ejercicio03contadorNumerosParEImpar {

	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;
		int cantidadNumeros;
		int contador = 0;

		do {
			System.out.println("Introduce cantidad de números a introducir");
			cantidadNumeros = teclado.nextInt();
		} while (cantidadNumeros <= MINIMO_NUMERO);
		
			while (contador < cantidadNumeros) {
				System.out.println("Introduce un número");
				numero = teclado.nextInt();
				if (numero % 2 == 0) {
					System.out.println(numero + " Número par");
				
				}
				else {
					System.out.println(numero + " Número impar");
				}
				contador++;
			}

		

	}

}
