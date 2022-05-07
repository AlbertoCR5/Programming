package relacion02;
import java.util.Scanner;

public class Ejercicio04sumaNumerosEnCadena {
	
	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numero, suma = 0;
		

		do {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
		} while (numero <= MINIMO_NUMERO);
		
		for (int i = 0; i <= numero; i++) {
			suma = suma + i;
		}
		
		System.out.println("La suma de los " + numero + " primeros números es: " + suma);
	}

}
