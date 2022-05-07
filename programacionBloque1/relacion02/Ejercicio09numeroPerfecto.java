package relacion02;
import java.util.Scanner;

public class Ejercicio09numeroPerfecto {
	
	private static final int VALOR_MINIMO = 0;
	private static final int DIVISOR = 2;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numero, divisor, sumaDivisores;
		
		do {
			System.out.println("Introduce un n�mero entero positivo");
			numero = teclado.nextInt();
		} while (numero <= VALOR_MINIMO);
		
		sumaDivisores = VALOR_MINIMO;
		
		for (divisor = 1; divisor <= numero / DIVISOR; divisor++) {
			
			if (numero % divisor == 0) {
				sumaDivisores = sumaDivisores + divisor;
			}
		}
		
		if (numero == sumaDivisores) {
			System.out.println("El número " + numero + " es perfecto");
		}else {
			System.out.println("El número "+ numero + " NO es perfecto");
		}

	}

}
