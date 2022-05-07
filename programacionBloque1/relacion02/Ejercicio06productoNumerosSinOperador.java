package relacion02;
import java.util.Scanner;

public class Ejercicio06productoNumerosSinOperador {

	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroA, numeroB, producto = 0;
		boolean cambioSigno = false;

		System.out.println("Introduce dos números");
		numeroA = teclado.nextInt();
		numeroB = teclado.nextInt();

		if (numeroB < MINIMO_NUMERO) {
			numeroB = -numeroB;
			cambioSigno = true;
		}

		for (int i = 0; i < numeroB; i++) {

			producto = producto + numeroA;

		}

		if (cambioSigno) {
			producto = -producto;
		}

		System.out.println(producto);

	}

}
