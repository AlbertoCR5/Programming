package refuerzoRelacion05;

import java.util.Scanner;

public class Ejerecicio04CadenaGuay {

	private static final String CADENA_GUAY = "'Guay del Paraguay'";
	private static final int LONGITUD_GUAY = 4;
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadenaA;
		boolean esGuay;
		
		cadenaA = solicitarCadena("Introduce la primera cadena");		
		esGuay = tratarCadena(cadenaA);
		
		if (esGuay) {
			System.out.println("La cadena " + cadenaA + " es " + CADENA_GUAY);
		}
		else {
			System.out.println("La cadena " + cadenaA + " no es " + CADENA_GUAY);
		}
		
	}

	private static String solicitarCadena(String string) {
		
		String cadena;
		
		System.out.println(string);
		cadena = teclado.nextLine();
		
		return cadena;
	}

	private static boolean tratarCadena(String cadenaA) {	
		
		boolean esGuay = false;
		StringBuilder sbComienzoYFinalCadena = new StringBuilder();
		
		sbComienzoYFinalCadena.append(cadenaA, 0, LONGITUD_GUAY);
		
		if (cadenaA.endsWith(sbComienzoYFinalCadena.toString())) {
			esGuay = true;
		}
		
		
		return esGuay;
	}

}