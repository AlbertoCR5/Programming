package practicasExamenes;

import java.util.Scanner;

public class RecuperacionB2Ejercicio03 {

//	private static final int LONGITUD_MINIMA = 1;
//	private static final int LONGITUD_MAXIMA = 6;
	private static final int SEPARADOR_FRAGMENTOS = '-';

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String codigoBarras;
		boolean esValido;
		codigoBarras = solicitarCodigoBarras();
		esValido = desglosarCodigoBarras(codigoBarras);

		if (esValido) {
			System.out.println("El codigo de barras introducido es correcto. " + codigoBarras);
		}
		else {
			System.out.println("El codigo de barras introducido es incorrecto.");
		}

	}

	private static String solicitarCodigoBarras() {

		String cadena;

		System.out.print("Introduce una cadena: ");
		cadena = teclado.nextLine();

		return cadena;
	}

	private static boolean desglosarCodigoBarras(String codigoBarras) {
		
		boolean esValido = true;
		char caracter;
		int posicionGuion = codigoBarras.indexOf(SEPARADOR_FRAGMENTOS);
		int posicionSiguienteGuion = codigoBarras.indexOf(SEPARADOR_FRAGMENTOS, posicionGuion + 1);

		System.out.println(posicionGuion);
		System.out.println(posicionSiguienteGuion);
		for (int i = 0; i < codigoBarras.length() && esValido; i++) {
			caracter = codigoBarras.charAt(i);
			
			if (i == 0) {
				if (!(Character.isDigit(caracter))) {
					esValido = false;
				}
			}
			
			if (posicionSiguienteGuion != -1 && posicionGuion != -1) {
				if (posicionSiguienteGuion - posicionGuion < 2 && esValido) {
					esValido = false;
				}
			}
						
			if (i == codigoBarras.length()-1 && esValido) {
				if (!Character.isUpperCase(caracter) || !Character.isLetter(caracter)) {
					esValido = false;
				}
			}
						
		}		

		return esValido;
	}
	
}