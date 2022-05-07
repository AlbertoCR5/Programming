/*
 * Realizar un método llamado censuraCadena que reciba una cadena y devuelva otra donde se
“censura” una palabra. La censura consiste en que esa palabra se sustituye por asteriscos (cada uno
de sus caracteres). No se tendrán cuenta mayúsculas ni minúsculas
 */
package practicasExamenes;

import java.util.Scanner;

public class ExamenCensuraCadena {

	private static final String CENSURA = "*";
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String cadena;
		String palabraACensurar;
		String cadenaCensurada;

		cadena = solicitarCadena("Introduce una cadena");
		palabraACensurar = solicitarCadena("Introduce la palabra a censurar");
		cadenaCensurada = censurarPalabra(cadena, palabraACensurar);

		System.out.println(cadenaCensurada);
	}

	/**
	 * Metodo que solicita una cadena
	 * 
	 * @return cadena
	 */
	private static String solicitarCadena(String msg) {

		String cadena;

		System.out.println(msg);
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}


	/**
	 * Metodo que censura una palabra dentro de una cadena, imprimiendo en pantalla
	 * un * por cada letra de la plabra censurada luego se reemplaza la cadena
	 * oridinal por la nueva con la palabra ya censurada
	 * 
	 * @param cadena
	 * @param palabraACensurar
	 * @return palabraCensurada
	 */
	private static String censurarPalabra(String cadena, String palabraACensurar) {

		StringBuilder sbPalabraCensurada = new StringBuilder();
		
		for (int i = 0; i < palabraACensurar.length(); i++) {
			sbPalabraCensurada.append(CENSURA);
		}

		cadena = cadena.replace(palabraACensurar, sbPalabraCensurada);
		
		return cadena;
	}

}
