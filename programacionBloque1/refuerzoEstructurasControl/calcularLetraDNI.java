package refuerzoEstructurasControl;

import java.util.Scanner;

public class calcularLetraDNI {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char respuesta;
		boolean esDigito = true;
		String numeroDNI = null;
		
		do {			
			do {
				numeroDNI = solicitarNumeroDNI();
				esDigito = comprobarNumeroDNI(numeroDNI);
			} while (!esDigito);
			int digitosDNI = convertirString(numeroDNI);
			devolverDNICompleto(digitosDNI);
			respuesta = solicitarOtroDNI();
		} while (respuesta == 'S');

		System.out.println("Adios");

	}

	private static String solicitarNumeroDNI() {

		String numeroDNI;

		System.out.print("Introduce tu número de DNI: ");
		numeroDNI = teclado.nextLine();

		return numeroDNI;
	}

	private static boolean comprobarNumeroDNI(String numeroDNI) {

		char caracterDNI;
		boolean esDigito = true;

		for (int i = 0; i < numeroDNI.length() && esDigito == true; i++) {
			caracterDNI = numeroDNI.charAt(i);

			if (Character.isLetter(caracterDNI)) {
				esDigito = false;
			}

		}

		if (numeroDNI.length() != 8) {
			esDigito = false;
		}

		return esDigito;

	}

	private static int convertirString(String numeroDNI) {

		Integer digitosDNI = Integer.valueOf(numeroDNI);

		return digitosDNI;

	}

	private static void devolverDNICompleto(int digitosDNI) {

		System.out.printf("La letra que corresponde a %d es %c", digitosDNI, calcularLetra(digitosDNI));
		System.out.println();
	}

	private static char calcularLetra(int numerosDNI) {
		String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = numerosDNI % 23;
		return caracteres.charAt(resto);
	}

	@SuppressWarnings("unused")
	private static char calcularLetraArray(int numerosDNI) {
		char caracteres[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		int resto = numerosDNI % 23;
		return caracteres[resto];
	}

	private static char solicitarOtroDNI() {

		char respuesta;

		do {
			System.out.println("Desea introducir otro DNI?");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);
		} while (respuesta != 'N' && respuesta != 'S');

		return respuesta;

	}
}
