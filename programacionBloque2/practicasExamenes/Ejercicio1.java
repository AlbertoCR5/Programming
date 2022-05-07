package practicasExamenes;

import java.util.Scanner;

public class Ejercicio1 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String palabraA, palabraB;
		boolean sonAmigas = false;

		palabraA = solicitarPalabra("Introduce la primera palabra");
		palabraB = solicitarPalabra("Introduce la segunda palabra");
		sonAmigas = comprobarSiSonAmigas(palabraA, palabraB);

		if (sonAmigas) {
			System.out.println(palabraA + " y " + palabraB + " son amigas.");
		} else {
			System.out.println(palabraA + " y " + palabraB + " no son amigas.");
		}

	}
	
	/**
	 * Metodo que solicita una palabra segun mensaje
	 * @param string
	 * @return palabra
	 */
	private static String solicitarPalabra(String string) {

		String palabra;

		System.out.println(string);
		palabra = teclado.nextLine();

		return palabra;
	}

	/**
	 * Metodo que comprueba:
	 * 1ª que ambas palabras tengan el mismo tamano
	 * 2º Bucle for que comprueba que caracter impares de la palabraA sean iguales a los caracteres pares de la palabraB
	 * 3ª Si no son amigas,
	 * 4º Bucle for que comprueba que caracter impares de la palabraB sean iguales a los caracteres pares de la palabraA
	 * @param palabraA
	 * @param palabraB
	 * @return sonAmigas, verdadero o falso.
 	 */
	private static boolean comprobarSiSonAmigas(String palabraA, String palabraB) {

		boolean sonAmigas = true;
		char caracterA, caracterB;
		int j = 0;

		if (palabraA.length() != palabraB.length()) {
			sonAmigas = false;
		} else {
			
			for (int i = 1; i < palabraA.length() && sonAmigas == true; i = i + 2) {
				caracterA = palabraA.toUpperCase().charAt(i);
				caracterB = palabraB.toUpperCase().charAt(j);

				if (!(caracterA == caracterB)) {
					sonAmigas = false;

				}
				j = j + 2;
			}
			
			if (!sonAmigas) {
				j = 1;
				sonAmigas = true;
				for (int i = 0; i < palabraA.length() && sonAmigas == true; i = i + 2) {
					caracterA = palabraA.toUpperCase().charAt(i);
					caracterB = palabraB.toUpperCase().charAt(j);

					if (!(caracterA == caracterB)) {
						sonAmigas = false;

					}
					j = j + 2;
				}
			}

		}

		return sonAmigas;
	}

}
