package relacion05;

import java.util.Scanner;

public class Ejercicio05BuscarPalabraEnCadena {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String texto, palabraABuscar;
		boolean encontrada;

		texto = introducirCadena("Introduce frase");
		palabraABuscar = introducirCadena("Palabra escondida");
		encontrada = buscarPalabraEnCadena(texto, palabraABuscar);

		if (encontrada) {
			System.out.println("Encontrada :)");
		} else {
			System.out.println("no se encuentra :(");
		}
	}

	private static String introducirCadena(String msg) {

		String cadena;

		System.out.println(msg);
		cadena = teclado.nextLine();

		return cadena;
	}

	private static boolean buscarPalabraEnCadena(String texto, String palabraABuscar) {

		boolean letraEncontrada = false;
		boolean palabraEncontrada = true;
		int iniciarBusqueda = 0;
		char caracter;

		for (int i = 0; i < palabraABuscar.length() && palabraEncontrada; i++) {
			caracter = palabraABuscar.charAt(i);

			for (int j = iniciarBusqueda; j < texto.length() && letraEncontrada == false; j++) {
				if (texto.charAt(j) == caracter) {

					letraEncontrada = true;
					iniciarBusqueda = j;
				}
				if (letraEncontrada == false && j == texto.length() - 1) {
					palabraEncontrada = false;
				}
			}
			letraEncontrada = false;

		}

		return palabraEncontrada;
	}

}