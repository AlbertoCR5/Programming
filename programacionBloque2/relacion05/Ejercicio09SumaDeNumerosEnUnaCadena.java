package relacion05;

import java.util.Scanner;

public class Ejercicio09SumaDeNumerosEnUnaCadena {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena;
		int sumaNumeros;
		
		cadena = solicitarCadena("Introduce una cadena");
		sumaNumeros = tratarCadena(cadena);
		
		System.out.println(sumaNumeros);
	}
	
	private static int tratarCadena(String cadena) {
				
		int sumaNumeros = 0;
		char caracter;
		boolean hayDigito = false;
		StringBuilder sbNumeros = new StringBuilder();
		
		for (int i = 0; i < cadena.length(); i++) {
			caracter = cadena.charAt(i);
			
			if (Character.isDigit(caracter)) {
				sbNumeros.append(caracter);
				hayDigito = true;				
			}
			else {
				if (hayDigito) {
					sumaNumeros = sumaNumeros + Integer.parseInt(sbNumeros.toString());
					System.out.println(sumaNumeros);
					borrarNumeros(sbNumeros);
					hayDigito = false;
				}
			}

		}
		
		if (hayDigito) {
			sumaNumeros = sumaNumeros + Integer.parseInt(sbNumeros.toString());
		}
		
		return sumaNumeros;
	}

	private static void borrarNumeros(StringBuilder sbNumeros) {
		
		sbNumeros.delete(0, sbNumeros.length());
		
	}

	private static String solicitarCadena(String string) {
		
		String cadena;
		
		System.out.println(string);
		cadena = teclado.nextLine();
		
		return cadena;
	}	
}