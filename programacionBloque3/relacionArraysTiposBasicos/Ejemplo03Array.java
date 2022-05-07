package relacionArraysTiposBasicos;

import java.util.Scanner;

public class Ejemplo03Array {

	private static final int NUMERO_PALABRAS_NOMBRE_COMPLEJO = 4;
	private static final int NUMERO_PALABRAS_NOMBRE_SIMPLE = 3;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreCompleto;
		

		System.out.println("Introduce tu nombre completo (NOMBRE APELLIDO1 APELLIDO2)");
		nombreCompleto = teclado.nextLine();

		comprobarNombreCompleto(nombreCompleto);

		// Realiza los cambios que consideres oportuno para validar que tanto el nombre
		// como los apellidos tienen
		// al menos 3 caracteres y todos son letras

		// Ejemplo de uso método split

	}

	private static void comprobarNombreCompleto(String nombreCompleto) {
		
		String[] partes;
		boolean esValido = true;
		
		partes = nombreCompleto.split(" ");
		
		if (partes.length != NUMERO_PALABRAS_NOMBRE_SIMPLE && partes.length != NUMERO_PALABRAS_NOMBRE_COMPLEJO) {
			System.out.println("No tiene el formato correcto");
		} else {
			for (int i = 0; i < partes.length && esValido == true; i++) {
//				palabra = partes[i];
//				esValido = comprobarNombresApellidos(palabra);
				esValido = comprobarNombresApellidos(partes[i]);

			}

			if (esValido) {
				System.out.println("El nombre introducido es correcto");
			} else {
				System.out.println("El nombre introducido es incorrecto");
			}

		}
		
	}

	private static boolean comprobarNombresApellidos(String palabra) {

		boolean esValido = true;
		char caracter;

		if (palabra.length() < 3) {
			esValido = false;
		} else {
			for (int i = 0; i < palabra.length() && esValido; i++) {
				caracter = palabra.charAt(i);
				if (!Character.isLetter(caracter)) {
					esValido = false;
				} else {
					esValido = true;
				}

			}

		}

		return esValido;
	}

}
