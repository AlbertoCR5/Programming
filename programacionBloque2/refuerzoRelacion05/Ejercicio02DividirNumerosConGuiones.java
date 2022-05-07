package refuerzoRelacion05;

import java.util.Scanner;

public class Ejercicio02DividirNumerosConGuiones {

	private static final int VALOR_MINIMO = 0;
	public static final int CANTIDAD_DIGITOS = 9;
	public static final String PREFIJOS_VALIDOS = "67";
	public static final String CARACTER_A_INSERTAR = "-";

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String numeroTelefono, numeroTelefonoSeparado;
		boolean esNumeroValido;

		numeroTelefono = solicitarNumeroTelefono("Introduce un numero de telefono correcto");
		esNumeroValido = comprobarNumeroTelefono(numeroTelefono);
		if (esNumeroValido) {
			numeroTelefonoSeparado = tratarNumeroTelefono(numeroTelefono);
			System.out.println(numeroTelefonoSeparado);
		} else {
			System.out.println("el numero de telefono introducido no es correcto");
		}

	}

	private static String solicitarNumeroTelefono(String msg) {

		String numeroTelefono;

		System.out.println(msg);
		numeroTelefono = teclado.nextLine();

		return numeroTelefono;
	}

	private static boolean comprobarNumeroTelefono(String numeroTelefono) {

		boolean esNumeroValido = true;
		char prefijo = numeroTelefono.charAt(VALOR_MINIMO);

		if (numeroTelefono.length() != CANTIDAD_DIGITOS || (!(PREFIJOS_VALIDOS.contains(String.valueOf(prefijo))))) {
			esNumeroValido = false;
		}

		return esNumeroValido;
	}
	
	/**
	 * Metodo que dada la cadena, se le añade guiones
	 * @param numeroTelefono
	 * @return
	 */
	private static String tratarNumeroTelefono(String numeroTelefono) {

		String guion = CARACTER_A_INSERTAR;
		StringBuilder sbNumeroTelefonoSeparado = new StringBuilder(numeroTelefono);

		for (int i = VALOR_MINIMO; i < sbNumeroTelefonoSeparado.length(); i++) {

			if (i % 3 == VALOR_MINIMO && i != VALOR_MINIMO) {
				sbNumeroTelefonoSeparado.insert(i, guion);
			}

		}

		return sbNumeroTelefonoSeparado.toString();
	}

}