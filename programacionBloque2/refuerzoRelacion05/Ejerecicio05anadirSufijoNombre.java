package refuerzoRelacion05;

import java.util.Scanner;

public class Ejerecicio05anadirSufijoNombre {

	private static final char FEMENINO = 'F';
	private static final char MASCULINO = 'M';
	private static final String SUFIJO_MASCULINO = "ITO";
	private static final String SUFIJO_FEMENINO = "ITA";
	private static final String TERMINACION_MASCULINO = "O";
	private static final String TERMINACION_FEMENINO = "A";
	private static final String TERMINACION_MIXTA = "EIU";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombre, diminutivo;
		boolean esValido;

		nombre = solicitarCadena("Introduce un nombre y te mostraremos el diminutivo");
		esValido = comprobarNombre(nombre);

		if (esValido) {
			diminutivo = tratarCadena(nombre);
			System.out.println("HOLA " + diminutivo);
		} else {
			System.out.println("Nombre incorrecto");
		}

	}

	private static boolean comprobarNombre(String nombre) {

		boolean esValido = true;
		char caracter;

		for (int i = 0; i < nombre.length() && esValido; i++) {
			caracter = nombre.charAt(i);

			if (!(Character.isLetter(caracter) || Character.isSpaceChar(caracter))) {
				esValido = false;
			}
		}
		return esValido;
	}

	private static String solicitarCadena(String string) {

		String cadena;

		System.out.println(string);
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}

	private static String tratarCadena(String nombre) {

		StringBuilder sbDiminutivo = new StringBuilder(nombre);
		char respuesta;

		if (nombre.endsWith(TERMINACION_MASCULINO)) {
			sbDiminutivo.delete(nombre.length() - 1, nombre.length());
			sbDiminutivo.append(SUFIJO_MASCULINO);
		} else {
			if (nombre.endsWith(TERMINACION_FEMENINO)) {
				sbDiminutivo.delete(nombre.length() - 1, nombre.length());
				sbDiminutivo.append(SUFIJO_FEMENINO);
			} else {
				respuesta = solicitarRespuesta("El nombre introducido es masculino, o femenino?");
				vocales(nombre);
				if (vocales(nombre)) {
					if (respuesta == MASCULINO) {
						sbDiminutivo.delete(nombre.length() - 1, nombre.length());
						sbDiminutivo.append(SUFIJO_MASCULINO);
					} else {
						sbDiminutivo.delete(nombre.length() - 1, nombre.length());
						sbDiminutivo.append(SUFIJO_FEMENINO);
					}
				} else {
					if (respuesta == MASCULINO) {
						sbDiminutivo.append(SUFIJO_MASCULINO);
					} else {
						sbDiminutivo.append(SUFIJO_FEMENINO);
					}
				}

			}
		}

		return sbDiminutivo.toString();
	}

	private static boolean vocales(String nombre) {

		boolean esVocal = false;
		String vocales = TERMINACION_MIXTA;
		char caracter;

		for (int i = 0; i < vocales.length() && esVocal == false; i++) {
			caracter = vocales.charAt(i);

			if (nombre.endsWith(String.valueOf(caracter))) {
				esVocal = true;
			}
		}

		return esVocal;
	}

	private static char solicitarRespuesta(String msg) {

		char respuesta;

		do {
			System.out.println(msg);
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta != MASCULINO && respuesta != FEMENINO);

		return respuesta;
	}

}