package practicasExamenes;

import java.util.Scanner;

public class PracticaBloque2Ejercicio1 {
	
	private static final String CARACTERES_HEXADECIMALES = "ABCDEF1234567890";
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		boolean esCadenaHexadecimal;
		
		cadena = solicitarCadena("Introduce una cadena");
		esCadenaHexadecimal = esHexadecimal(cadena);
		
		if (esCadenaHexadecimal) {
			System.out.println("La cadena introducida contiene solo caracteres hexadecimales");
		}
		else {
			System.out.println("La cadena introducida contiene caracteres que no son hexadecimales");
		}

	}

	/**
	 * Metodo que solicita una cadena de caracters
	 * @param string
	 * @return cadena
	 */
	public static String solicitarCadena(String string) {
		
		String cadena;
		
		System.out.println(string);
		cadena = teclado.nextLine().toUpperCase();
		
		return cadena;
	}
	
	/**
	 * Metodo que comprueba si la cadena introducida contiene solo caracteres hecadecimales, o no.
	 * @param cadena
	 * @return esCadenaHexadecimal
	 */
	public static boolean esHexadecimal(String cadena) {
		
		boolean esCadenaHexadecimal = true;
		char caracter;
		
		for (int i = 0; i < cadena.length() && esCadenaHexadecimal; i++) {
			caracter = cadena.charAt(i);
			
			if (!(esCaracterHexadecimalValido(caracter))) {
				esCadenaHexadecimal = false;
			}
			
		}
		return esCadenaHexadecimal;
	}

	/**
	 * Metodo que convierte cada caracter en String, y comprueba que este sea hexadecimal, o no.
	 * @param caracter
	 * @return esCaracterHexadecimalValido
	 */
	private static boolean esCaracterHexadecimalValido(char caracter) {
		
		String hexadecimales = CARACTERES_HEXADECIMALES;
		boolean esCaracterHexadecimalValido = true;
		
		if (!(hexadecimales.contains(String.valueOf(caracter)))) {
			esCaracterHexadecimalValido = false;
		}
		
		return esCaracterHexadecimalValido;
	}

}