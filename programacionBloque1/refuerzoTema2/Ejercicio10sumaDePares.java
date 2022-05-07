package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio10sumaDePares {
	
	private static final char VALOR_MINIMO = 0;
	private static final char DIVISOR = 10;	

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeroInicial, numero, copiaNumero, cifra, sumaPares = 0;
		int i= 0;
		do {
			System.out.println("Introduce un numero");
			numero = teclado.nextInt();
		} while (numero <= VALOR_MINIMO);

		numeroInicial = numero;
		copiaNumero = numero;
		while (numero > 0) {
			i++;
			numero = numero / DIVISOR;
		}	
		System.out.print("las cifras pares son:");
			while (i > 0) {
				cifra = copiaNumero % 10;
				
				if (cifra % 2 == 0) {
					System.out.print(cifra+" ");
					sumaPares = sumaPares + cifra;
				}
				
				copiaNumero = copiaNumero / DIVISOR;
				i--;
			}
			System.out.println();

		System.out.println("La suma de las cifras pares del numero " + numeroInicial + " es " + sumaPares);
		
	}

}
