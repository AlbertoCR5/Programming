package practicasExamenes;

import java.util.Scanner;

public class ExamenEmpiezaYAcabaMismaPalabra {
	
	private static final String ESPACIO = " ";
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String cadena;
		boolean esMismaPalabra;
		
		cadena = solicitarCadena("Introduce una frase");
		esMismaPalabra = EmpiezaYAcabaMismaPalabra(cadena);
		
		if (esMismaPalabra) {
			System.out.println(cadena + ". Son la misma palabra");		
		}
		else {
			System.out.println(cadena + ". No son la misma palabra");
		}

	}

	private static String solicitarCadena(String string) {
		
		String cadena;
		
		System.out.println(string);
		cadena = teclado.nextLine();
		
		return cadena;
	}

	/**
	 * Metodo que comprueba que la primera y la ultima palabra son la misma
	 * @param cadena
	 * @return esMismaPalabra. Verdadero o falso.
	 */
	private static boolean EmpiezaYAcabaMismaPalabra(String cadena) {
		
		boolean esMismaPalabra = false;
		StringBuilder sbPalabra = new StringBuilder(cadena.toUpperCase());
		int posicionFinPalabra =cadena.indexOf(ESPACIO);
		
		if (posicionFinPalabra == -1) {
			esMismaPalabra = true;
		}
		
		if (!esMismaPalabra) {
			sbPalabra.delete(posicionFinPalabra, cadena.length());System.out.println(sbPalabra);
			
			if (cadena.toUpperCase().endsWith(sbPalabra.toString())) {
				esMismaPalabra = true;
			}
		}
				
		return esMismaPalabra;
	}

}
