package relacion05;

import java.util.Scanner;

public class Ejercicio06ReemplazarPalabras {

	private static final int VALOR_MINIMO = 0;
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String texto, textoABuscar, textoAReemplazar, nuevoTexto;
		
		texto = solicitarCadena("Introduce un texto");
		textoABuscar = solicitarCadena("Introduce el texto a buscar");
		textoAReemplazar = solicitarCadena("Introduce el texto a reemplazar");
		nuevoTexto = tratarCadena(texto, textoABuscar, textoAReemplazar);
		
		System.out.println(nuevoTexto);
	}

	/**
	 * Metodo que solicita una cadena de caracteres, el mensaje indicara loque se debe intriducir
	 * @param msg
	 * @return cadena
	 */
	private static String solicitarCadena(String msg) {

		String cadena;
		
		System.out.println(msg);
		cadena = teclado.nextLine();
		
		return cadena;
	}

	/**
	 * Metodo que recibido tres cadenas, construira una nueva cadena modificada mediante el string builder
	 * @param texto
	 * @param textoABuscar
	 * @param textoAReemplazar
	 * @return nuevoTexto
	 */
	private static String tratarCadena(String texto, String textoABuscar, String textoAReemplazar) {
		
		//Creamos un StringBuilder con la cadena texto contenida para poder modificarla
		StringBuilder sbNuevoTexto = new StringBuilder(texto);
		boolean esEncontradoTextoBuscado = true;
		//Iniciamos posicion con el valor del lugar que empieza la palabra buscada
		int posicion = texto.indexOf(textoABuscar);
		
		
		while (esEncontradoTextoBuscado) {
			sbNuevoTexto.delete(posicion, posicion + textoABuscar.length());
			sbNuevoTexto.insert(posicion, textoAReemplazar); 
			posicion = posicion + textoAReemplazar.length();
			posicion = sbNuevoTexto.indexOf(textoABuscar, posicion);
			if (posicion < VALOR_MINIMO) {
				esEncontradoTextoBuscado = false;
			}
		}
		
		return sbNuevoTexto.toString();
	}

}