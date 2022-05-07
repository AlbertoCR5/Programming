package relacion03;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio04numeroSecreto {

	private static final int NUMERO_MINIMO = 1;
	private static final int LIMITE_INTENTOS = 5;
	private static final int NUMERO_LIMITE= 100;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numeroAleatorio, numero;
		boolean ganador = false;
		Random serieAleatoria = new Random();
		
		numeroAleatorio = serieAleatoria.nextInt(NUMERO_LIMITE) + 1;
		System.out.println(numeroAleatorio);
		
		for (int i = 1; i <= LIMITE_INTENTOS && ganador == false; i++) {
			
			System.out.println("Tienes " + (LIMITE_INTENTOS - i + 1) + " intentos");
			System.out.println("Introduce un número");	
			numero = teclado.nextInt();
			
			if (numero < NUMERO_MINIMO || numero > NUMERO_LIMITE) {
				System.out.println("El número debe estar entre 1 y 100");
			} 
			else {
				if (numeroAleatorio < numero) {
					System.out.println("El numero secreto es menor");
				}
				else {
					if (numeroAleatorio > numero) {
						System.out.println("El numero secreto es mayor");
					}
					else {
						System.out.println("HAS GANADO");
						ganador = true;
					}
				}
			}
			
		}
		
		if (ganador == false) {
			System.out.println("GAME OVER");
			System.out.println("El número secreto era el " + numeroAleatorio);
		}
		
		

	}

}
