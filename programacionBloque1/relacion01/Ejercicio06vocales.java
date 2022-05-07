package relacion01;
import java.util.Scanner;

/*
 *6. Realizar un programa que solicite un carácter por teclado e informe por pantalla
 *si el carácter es una vocal o no lo es. Si es una vocal mostrará el mensaje 
 *“Es la primera vocal (A)” o “Es la segunda vocal(E)”, etc. 
 */
public class Ejercicio06vocales {

	private final static char VOCAL_1 = 'A';
	private final static char VOCAL_2 = 'E';
	private final static char VOCAL_3 = 'I';
	private final static char VOCAL_4 = 'O';
	private final static char VOCAL_5 = 'U';

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char letra;

		System.out.println("Introduce una letra");
		letra = teclado.nextLine().charAt(0);
		letra = Character.toUpperCase(letra);

		switch (letra) {

		case VOCAL_1:
			System.out.println("Es la primera vocal");
			break;
			
		case VOCAL_2:
			System.out.println("Es la segunda vocal");
			break;
			
		case VOCAL_3:
			System.out.println("Es la tercera vocal");
			break;
			
		case VOCAL_4:
			System.out.println("Es la cuarta vocal");
			break;
			
		case VOCAL_5:
			System.out.println("Es la quintaa vocal");
			break;
			
		default:
			System.out.println("No es una vocal");

		}

	}

}
