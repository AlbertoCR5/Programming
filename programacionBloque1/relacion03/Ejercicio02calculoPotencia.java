package relacion03;
import java.util.Scanner;

public class Ejercicio02calculoPotencia {

	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int base, exponente;
		long potencia = 1;
		
		do {
			System.out.println("Introduce la base");
			base = teclado.nextInt();
			System.out.println("Introduce el exponente");
			exponente = teclado.nextInt();
		} while (base < VALOR_MINIMO || exponente < VALOR_MINIMO);
		
		for (int i = 1; i <= exponente ; i++) {
			potencia = potencia * base;
		}
		
		System.out.println("La potencia de " + base + " elevado a " + exponente + " es:");
		System.out.println(potencia);

	}

}
