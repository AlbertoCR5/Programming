package practicasExamenes;

import java.util.Scanner;

public class ExamenPrimerNumeroEnCadena {

	public static Scanner teclado = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		String cadena;
		int primerNumero;
		
		cadena = solicitarCadena();
		primerNumero = tratarCadena(cadena);
		
		System.out.println(primerNumero);
	}

	private static String solicitarCadena() {

		String cadena;
		
		System.out.println("Introduce una cadena");
		cadena = teclado.nextLine();
		
		return cadena;
	}

	private static int tratarCadena(String cadena) {

		StringBuilder sbNumero = new StringBuilder();
		int numero;
		char caracter;
		boolean esNumero = false, esLetra = false;
		
		for (int i = 0; i < cadena.length() && !esLetra; i++) {
		caracter = cadena.charAt(i);
			
			if (Character.isDigit(caracter)) {
				sbNumero.append(caracter);
				esNumero = true;
			} else {
				if (esNumero && !Character.isDigit(caracter)) {
					esLetra = true;
				}
			}
		
		}
		
		if (sbNumero.toString().isEmpty()) { //preguntar a jorge
			numero = 0;
		}
		else {
			numero = Integer.parseInt(sbNumero.toString());
		}
		
		return numero;
	}

}
