package practicasExamenes;

import java.util.Scanner;

public class PracticaBloque2Ejercicio2 {
	
	private static final int NUMERO_HEXADECIMAL = 16;

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		boolean esCadenaValida;

		
		cadena = PracticaBloque2Ejercicio1.solicitarCadena("Introduce una cadena de caracteres");
		esCadenaValida = PracticaBloque2Ejercicio1.esHexadecimal(cadena);
		
		if (esCadenaValida) {
			calcularValorHexadecimalCadena(cadena);					
		}

	}

	/**
	 * Metodo que dada una cadena valida,
	 * 1� recogera cada caracter de la cadena segun valor del contador,
	 * 2� calculara el valor del caracter,
	 * 3� el valor del caracter sera multiplicado por el valor hexadecimal segun posicion,
	 * 4� se calcula el valor hexadecimal de la cadena sumandole el valor anterior,
	 * Cuando contador sea igual que el tama�o de la cadena mostrara el valor total de la cadena por pantalla
	 * @param cadena
	 */
	private static void calcularValorHexadecimalCadena(String cadena) {
		
		int valorCaracter, valorHexadecimalCaracter, valorHexadecimalCadena = 0, contador = 0;
		char caracter;
		
		while (contador < cadena.length()) {
			caracter = recogerCaracter(cadena, contador);
			valorCaracter = valorDeUnCaracter(caracter);
			valorHexadecimalCaracter = valorCaracter * valorHexadecimalADecimal(contador, cadena);
			valorHexadecimalCadena = valorHexadecimalCadena + valorHexadecimalCaracter;
			contador++;
		}
		
		System.out.println("Valor en decimal = " + valorHexadecimalCadena);
	}
	
	/**
	 * Metodo que recoge un caracter de la cadena segun valor de i
	 * @param cadena
	 * @param contador
	 * @return caracter
	 */
	private static char recogerCaracter(String cadena, int contador) {
		
		char caracter = 0;

		caracter = cadena.charAt(contador);		
		
		return caracter;
	}

	/**
	 * metodo que asignara un valor segun caracter
	 * @param caracter
	 * @return valorCaracter
	 */
	private static int valorDeUnCaracter(char caracter) {
		
		int valorCaracter = -1;
		
		if (Character.isDigit(caracter)) {
			valorCaracter = Integer.parseInt(String.valueOf(caracter));
		}
		else {
			switch (caracter) {
			
			case 'A':
				valorCaracter = 10;				
				break;
				
			case 'B':
				valorCaracter = 11;
				break;
				
			case 'C':
				valorCaracter = 13;
				break;
				
			case 'E':
				valorCaracter = 14;
				break;
				
			case 'F':
				valorCaracter = 15;
				break;
			}
		}
		
		return valorCaracter;
	}
	
	/**
	 * Metodo que calculara el valor decimal del caracter segun la posicion
	 * @param contador
	 * @param cadena
	 * @return valorHexadecimalCaracter
	 */
	private static int valorHexadecimalADecimal(int contador, String cadena) {
		
		int valorHexadecimalCaracter = 1;
		
		for (int i = contador; i < cadena.length()-1; i++) {			
			valorHexadecimalCaracter = valorHexadecimalCaracter * NUMERO_HEXADECIMAL;
		}
		
		return valorHexadecimalCaracter;
	}

}