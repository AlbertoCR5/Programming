package practicasExamenes;

import java.util.Scanner;

public class MaterialEjercicio3 {

	private static final char CARACTER_GUION = '-';
	private static final int LONGITUD_NUMERO_TELEFONO = 9;
	private static final int LONGITUD_PREFIJO = 3;
	private static Scanner teclado = new Scanner(System.in);
	public static String PREFIJOS_ANDALUCES = "954 SEVILLA-955 SEVILLA-956 CADIZ-958 GRANADA-959 HUELVA-950 ALMERIA-953 JAEN-957 CORDOBA-951 MALAGA-";

	public static void main(String[] args) {
		String telefono, provincia;
		boolean esValido;
		System.out.println("Introduce un telefono fijo de Andalucia (999999999)");
		telefono = teclado.nextLine();

		esValido = comprobarTelefono(telefono);

		if (!esValido) {
			provincia = "ERROR";
		} else {
			provincia = provinciaDeTelefono(telefono);
		}

		if (provincia.equals("ERROR"))
			System.out.println("Es un teléfono incorrecto o no corresponde a una provincia andaluza");
		else
			System.out.println("El teléfono " + telefono + " es de " + provincia);

	}

	/**
	 * Metodo que comprueba que un telefono tenga 9 caracteres y no contenga
	 * caracteres que no sean digitos
	 * 
	 * @param telefono
	 * @return esValido true o false
	 */
	private static boolean comprobarTelefono(String telefono) {

		char caracter;
		boolean esValido = true;

		if (telefono.length() != LONGITUD_NUMERO_TELEFONO) {
			esValido = false;
		} else {
			for (int i = 0; i < telefono.length() && esValido; i++) {
				caracter = telefono.charAt(i);

				if (!(Character.isDigit(caracter))) {
					esValido = false;
				}
			}
		}

		return esValido;
	}

	/**
	 * metodo que una vez comprobado que el numero es valido comprueba que el
	 * prefijo este contenido en PREFIJOS_ANDALUCES Si no esta, devolvera "ERROR" y
	 * si esta, con un stringBuilder seleccionamos el contenido que nos interesa
	 * 
	 * @param telefono
	 * @return provincia
	 */
	public static String provinciaDeTelefono(String telefono) {

		String provincia;
		StringBuilder sbPrefijo = new StringBuilder(telefono);
		StringBuilder sbProvincia = new StringBuilder(PREFIJOS_ANDALUCES);
		int posicionBusqueda;
		int posicionGuion;

		sbPrefijo.delete(LONGITUD_PREFIJO, telefono.length());

		if (!(PREFIJOS_ANDALUCES.contains(sbPrefijo))) {
			provincia = "ERROR";
		} else {
			posicionBusqueda = PREFIJOS_ANDALUCES.indexOf(sbPrefijo.toString());

			if (posicionBusqueda == -1) {
				provincia = "ERROR";
			} else {
				sbProvincia.delete(0, posicionBusqueda + LONGITUD_PREFIJO);

				posicionGuion = sbProvincia.toString().indexOf(CARACTER_GUION);

				sbProvincia.delete(posicionGuion, sbProvincia.length());

				provincia = sbProvincia.toString();
			}

		}

		return provincia;
	}

}
