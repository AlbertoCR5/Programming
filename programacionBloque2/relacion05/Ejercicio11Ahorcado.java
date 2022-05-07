package relacion05;

import java.util.Scanner;

public class Ejercicio11Ahorcado {

	private static final int VALOR_MINIMO = 0;
	private static final int MAXIMO_FALLO = 7;
	private static final char AFIRMATIVO = 'S';
	private static final char NEGATIVO = 'N';
	private static final String CARACTER_CIFRADO = "*";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String palabra, palabraCifrada, pruebaPalabra;
		char letra, respuesta;
		int intento = 0;
		boolean esLetraAdivinada, esAdivinada = false;

		// Se solicita una palabra
		palabra = solicitarPalabra("Introduce la palabra secreta: ");
		// Se cifra la palabra anterior
		palabraCifrada = cifrarPalabra(palabra);
		// Se muestra un menu explicando las reglas del juego,tambien muestra la palabra
		// secreta cifrada
		mostrarMensajeBienvenida(palabraCifrada);

		// Bucle que hara que el programa se ejecute mientras tengas menos de 7 fallos,
		// o no se adivine la palabra
		do {
			System.out.println();
			// Se solicita una letra
			letra = solicitarLetra("Introduce una letra: ", intento);
			// Se comprueba que la palabra secreta contiene la letra introducida
			esLetraAdivinada = comprobarSiLetraEstaConteida(letra, palabra);

			// Si la palabra contiene la letra...
			if (esLetraAdivinada) {
				palabraCifrada = tratarPalabra(letra, palabra, palabraCifrada);
				// ...Mostrara la palabra cifrada pero con la letra acertada al descubierto y...
				System.out.println(palabraCifrada);
				// ...Comprueba que la palabra este adivinada, o no.
				System.out.println();
				esAdivinada = comprobarPalabra(palabraCifrada, palabra);
				// Si no es adivinada la palabra...
				if (!(esAdivinada)) {

					// ...Preguntara si quieres resolver...
					do {
						respuesta = solicitarLetra("Te atreves a resolver la palabra secreta?: ", intento);
					} while (respuesta != NEGATIVO && respuesta != AFIRMATIVO);

					// Si quieres resolver...
					if (respuesta == AFIRMATIVO) {
						// ...te pedira que introduzcas la palabra
						pruebaPalabra = solicitarPalabra("Introduce una palabra para intentar resolver: ");
						// Se comprueba si as adivinado la palabra...
						esAdivinada = comprobarPalabra(pruebaPalabra, palabra);

						// ...si no es adivinada, acumulas un fallo, y si aciertas, ganas.
						if (!(esAdivinada)) {
							System.out.println("Palabra introducida incorrecta");
							intento++;
						} else {
							esAdivinada = true;
						}
					}
				} else {
					esAdivinada = true;
				}
			// ...Si la palabra no contiene la letra introducida, acumulas un fallo.
			} else {
				intento++;
			}

		} while (intento < MAXIMO_FALLO && esAdivinada == false);

		// Muestra mensaje, segun ganes o pierdas.
		if (esAdivinada) {
			System.out.println("Enhorabuena, has hadivinado la palabra.");
		} else {
			System.out.println("Has perdido, esta era la palabra secreta: (" + palabra + ").");
		}

	}

	/**
	 * Metodo que solicita una palabra, para ser cifrada
	 * 
	 * @param msg
	 * @return palabra
	 */
	private static String solicitarPalabra(String msg) {

		String palabra;

		System.out.print(msg);
		palabra = teclado.nextLine().toUpperCase();

		return palabra;
	}

	/**
	 * Metodo que recibe por parametro una palabra, y la devuelve cifrada
	 * 
	 * @param palabra
	 * @return palabraCifrada
	 */
	private static String cifrarPalabra(String palabra) {

		StringBuilder sbPalabraCifrada = new StringBuilder();

		for (int i = 0; i < palabra.length(); i++) {
			sbPalabraCifrada.append(CARACTER_CIFRADO);
		}

		return sbPalabraCifrada.toString();
	}

	/**
	 * metodo que muestra las reglas del juego, y la palabra cifrada, para que el
	 * usuario pueda ver el tamañp que tiene
	 * 
	 * @param palabraCifrada
	 */
	private static void mostrarMensajeBienvenida(String palabraCifrada) {

		System.out.println("Bienvenido, juguemos al juego del Ahorcado");
		System.out.println("El usuario deberá ir introduciendo letras");
		System.out.println("El programa deberá ir mostrando la palabra si la letra está,");
		System.out.println("O anotando fallos si no.");
		System.out.println("El programa termina si se adivina la palabra o si se producen un total de 7 fallos");
		System.out.print("Empezemos, esta es la palabra secreta: ");
		System.out.println(palabraCifrada);

	}

	/**
	 * Metodo que solicita una letra, recibe por parametro un mensaje y el numero de
	 * intentos que lleva
	 * 
	 * @param msg
	 * @param intento
	 * @return letra
	 */
	private static char solicitarLetra(String msg, int intento) {

		String cadena;
		char letra;

		do {
			System.out.println("Tienes " + (MAXIMO_FALLO - intento) + " intentos");
			System.out.print(msg);
			cadena = teclado.nextLine().toUpperCase();
			System.out.println();
		} while (cadena.length() <= 0);
		letra = cadena.charAt(0);

		return letra;
	}

	/**
	 * Metodo que comprueba si la palabra contiene la letra introducida
	 * 
	 * @param letra
	 * @param palabra
	 * @return esLetraAdivinada
	 */
	private static boolean comprobarSiLetraEstaConteida(char letra, String palabra) {

		boolean esLetraAdivinada = false;

		if (palabra.contains(String.valueOf(letra))) {
			esLetraAdivinada = true;
		}

		return esLetraAdivinada;
	}

	/**
	 * Metodo que al recibir los parametros, elimina el cifrado de la letra acertada
	 * y le añade la letra sin cifrar
	 * 
	 * @param letra
	 * @param palabra
	 * @param palabraCifrada
	 * @return devuelve la palabra cifrada con las letras adivinadas al descubierto
	 */
	private static String tratarPalabra(char letra, String palabra, String palabraCifrada) {

		boolean esEncontradoTextoBuscado = true;
		int posicionBusqueda = palabra.indexOf(letra);
		StringBuilder sbPalabraCifrada = new StringBuilder(palabraCifrada);

		while (esEncontradoTextoBuscado) {
			sbPalabraCifrada.delete(posicionBusqueda, posicionBusqueda + 1);
			sbPalabraCifrada.insert(posicionBusqueda, letra);
			posicionBusqueda++;
			posicionBusqueda = palabra.indexOf(letra, posicionBusqueda);

			if (posicionBusqueda < VALOR_MINIMO) {
				esEncontradoTextoBuscado = false;
			}
		}

		return sbPalabraCifrada.toString();

	}

	/**
	 * Metodo que comprueba si adivinas una letra o intentas resolver, la palabra
	 * resultante sea igual a la palabra secreta original
	 * 
	 * @param pruebaPalabra
	 * @param palabra
	 * @return esAdivinada
	 */
	private static boolean comprobarPalabra(String pruebaPalabra, String palabra) {

		boolean esAdivinada = false;

		if (palabra.equalsIgnoreCase(pruebaPalabra)) {
			esAdivinada = true;
		}
		return esAdivinada;
	}
}
