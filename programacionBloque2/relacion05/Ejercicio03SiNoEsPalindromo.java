package relacion05;

import java.util.Scanner;

public class Ejercicio03SiNoEsPalindromo {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena;
		boolean esPalindromo;

		cadena = solicitarCadena();
		esPalindromo = comprobarSiEsPalindromo(cadena);

		if (esPalindromo) {
			System.out.println("La cadena introducida es un palindromo");
		} else {
			System.out.println("La cadena introducida no es un palindromo");
		}
	}

	private static String solicitarCadena() {
		
		String cadena;
		System.out.println("Introduce una cadena");
		cadena = teclado.nextLine();

		return cadena;

	}

	private static boolean comprobarSiEsPalindromo(String cadena) {

		String cadenaSinEspacios;
		boolean esPalindromo = true, distintos = false;
		char caracter, caracterBis;
		
		cadenaSinEspacios = cadena.replaceAll(" ","");
		
		for (int i = 0; i < cadenaSinEspacios.length() && esPalindromo; i++) {
			caracter = cadenaSinEspacios.charAt(i);

			distintos = false;
			for (int j = cadenaSinEspacios.length()-i-1; j >= 0 && distintos == false; j--) {
				caracterBis = cadenaSinEspacios.charAt(j);


				if (caracter != caracterBis) {
					esPalindromo = false;
				}
				distintos = true;
			}
		}

		return esPalindromo;
	}

}