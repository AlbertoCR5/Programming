package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio09primeraCifra {

	private static final char DIVISOR = 10;	

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numero, primeraCifra = 0;
		
		System.out.println("Introduce un numero");
		numero = teclado.nextInt();
		
		primeraCifra = numero;
		
		while (primeraCifra > DIVISOR) {
		
			primeraCifra = primeraCifra / DIVISOR;
		}
		System.out.println("La primera cifra del numero " + numero + " es el " + primeraCifra);

	}
	

}
