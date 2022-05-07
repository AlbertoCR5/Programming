package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio04mediaNumeros {

	private static final int VALOR_MINIMO = 0;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numero, cantidadNumeros = 0;
		int numeroMaximo = Integer.MIN_VALUE;
		int numeroMinimo = Integer.MAX_VALUE;
		double media = 0;
		
		do {
			System.out.println("Introduce un numero");
			numero = teclado.nextInt();
			
			if (numero == VALOR_MINIMO) {
				media = media / cantidadNumeros;
				System.out.println("La media de los numeros introducidos es " + media);
				System.out.println("El maximo numero introducido es el " + numeroMaximo);
				System.out.println("El minimo numero introducido es el " + numeroMinimo);
			}
			else {
				media = media + numero;
				cantidadNumeros++;
				
				if (numero > numeroMaximo) {
					numeroMaximo = numero;
				}
				
				if (numero < numeroMinimo) {
					numeroMinimo = numero;
				}
			}
		} while (numero != VALOR_MINIMO);

	}

}
