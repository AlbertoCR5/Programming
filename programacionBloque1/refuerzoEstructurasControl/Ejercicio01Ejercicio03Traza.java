package refuerzoEstructurasControl;
import java.util.Scanner;

public class Ejercicio01Ejercicio03Traza {

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, numero2;
		int contador;
		int mcd = 1;
		boolean encontradoMcd;
		
		

		do {
			System.out.println("Introduce dos números");
			numero = teclado.nextInt();
			numero2 = teclado.nextInt();
		} while (numero == 0 || numero2 == 0);

		if (numero < 0) {
			numero = -numero;
		}
		
		if (numero2 < 0) {
			numero2 = -numero2;
		}
		if (numero < numero2) {
			contador = numero;
		}
		else {
			contador = numero2;
		}
		encontradoMcd = false;
		
		while (contador >= 1 && encontradoMcd == false) {
			if (numero % contador == 0 && numero2 % contador == 0) {
				mcd = contador;
				encontradoMcd = true;
			}
			else {
				contador--;
			}
		}
		System.out.println("El mcd es " + mcd);
	}

}
