package relacion01;
import java.util.Scanner;

/*
 *Realizar un programa que lea un n�mero por teclado. El programa debe imprimir en pantalla un 
mensaje con �El n�mero xx es m�ltiplo de 2� o un mensaje con �El n�mero xx es m�ltiplo de 3�. Si es 
m�ltiplo de 2 y de 3 deben aparecer los dos mensajes. Si no es m�ltiplo de ninguno de los dos el 
programa finaliza sin mostrar ning�n mensaje. 
 */
public class Ejercicio03multiplos {

	private final static int MULTIPLO_2 = 2;
	private final static int MULTIPLO_3 = 3;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;

		System.out.println("Introduce un n�mero entero");
		numero = teclado.nextInt();

		if (numero % MULTIPLO_2 == 0) {
			System.out.println("El n�mero introducido es m�ltiplo de 2");
		}
		if (numero % MULTIPLO_3 == 0) {
			System.out.println("El n�mero introducido es m�ltiplo de 3");
		}

	}

}
