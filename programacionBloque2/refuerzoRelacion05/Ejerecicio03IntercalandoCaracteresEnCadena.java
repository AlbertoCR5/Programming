package refuerzoRelacion05;

import java.util.Scanner;

public class Ejerecicio03IntercalandoCaracteresEnCadena {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadenaA, cadenaB, cadenaResultante;
		
		cadenaA = solicitarCadena("Introduce la primera cadena");
		cadenaB = solicitarCadena("Introduce la segunda cadena");
		cadenaResultante = tratarCadena(cadenaA, cadenaB);		
		
		System.out.println(cadenaResultante);
	}

	private static String solicitarCadena(String string) {
		
		String cadena;
		
		System.out.println(string);
		cadena = teclado.nextLine();
		
		return cadena;
	}

	private static String tratarCadena(String cadenaA, String cadenaB) {	
		
		StringBuilder sbCadenaResultante;
		char caracter;
		int i = 0;
		int j = 1;
		
		if (cadenaA.length() >= cadenaB.length()) {
			sbCadenaResultante = new StringBuilder(cadenaA);
			for (i = 0; i < cadenaB.length(); i++) {
			caracter = cadenaB.charAt(i);
			sbCadenaResultante.insert(j, caracter);
			j = j + 2;
			
			}
		}
		else {
			sbCadenaResultante = new StringBuilder(cadenaB);
			for (j = 0; j < cadenaA.length(); j++) {
				caracter = cadenaA.charAt(j);
				sbCadenaResultante.insert(i, caracter);
				i = i + 2;
			}
		}
			
		return sbCadenaResultante.toString();
	}

}
