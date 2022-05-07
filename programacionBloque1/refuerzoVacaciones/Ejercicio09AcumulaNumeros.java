package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio09AcumulaNumeros {

	private static final int FINALIZAR_PROGRAMA = 1000;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, cantidadNumeros = 0;
		double media = 0;

		do {
			System.out.print("Introduce un numero: ");
			numero = Integer.parseInt(teclado.nextLine());
			media = media + numero;
			cantidadNumeros++;
		} while (media <= FINALIZAR_PROGRAMA );
		
		System.out.println("La suma de los numeros es " + media);
		System.out.println("Se han introducido " + cantidadNumeros + " numeros");
		
		media = media / cantidadNumeros;
		
		System.out.println("La media de los numeros introducidos es " + media);
	}

}
