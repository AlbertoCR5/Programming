package refuerzoEstructurasControl;
import java.util.Scanner;

public class Ejercicio01ProgramaQueHace {

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, otro, suma1 = 0, suma2 = 0, contador, contador2;

		do {
			System.out.println("Introduce un número positivo");
			numero = teclado.nextInt();
		} while (numero <= 0);

		do {
			System.out.println("Introduce otro número positivo");
			otro = teclado.nextInt();
		} while (otro < 0 || otro >= numero);

		for (contador = 1; contador < otro; contador++) {
			suma1 = suma1 + contador;
		}

		contador2 = otro + 1;

		while (contador2 <= numero) {
			suma2 = suma2 + contador2;
			contador2++;
		}

		if (suma1 == suma2) {
			System.out.println(otro + " es un centro númerico respecto a " + numero);
		} else {
			System.out.println(otro + " no es un centro númerico respecto a " + numero);
		}
	}

}
