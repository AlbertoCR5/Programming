package relacion02;
import java.util.Scanner;

public class Ejercicio07mediaNumeros {

	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numero, cantidadNumeros;
		double media = 0;
		
		do {
			System.out.println("¿Cuantos números va a introducir?");
			cantidadNumeros = teclado.nextInt();
		} while (cantidadNumeros <= MINIMO_NUMERO);
		
		for (int i = 0; i < cantidadNumeros; i++) {
			
			System.out.println("Introduzca un número");
			numero = teclado.nextInt();
			
			media = media + numero;
		}
		
		media = (double) media / cantidadNumeros;

		System.out.println(media);
	}

}
