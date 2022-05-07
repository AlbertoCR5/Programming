package relacion05;

import java.util.Scanner;

public class Ejercicio08ValidarUsuarioContrasena {

	private final static int VALOR_MINIMO = 0;
	private final static int MIN_CARACTERES_CONTRASENA = 7;
	private final static int MAX_CARACTERES_USUARIO = 30;
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String usuario, contrasena;
		boolean identificacionCorrecta;
		
		do {
			usuario = introduceCadena("Introduce usuario");
			contrasena = introduceCadena("Introduce contrasena");
			identificacionCorrecta = validarIdentificacion(usuario, contrasena);
			
			if (identificacionCorrecta) {
				System.out.println("Bienvenido " + usuario);
			}
			else {
				System.out.println("Identificacion incorrecta");
			}
		} while (!identificacionCorrecta);
		

	}

	private static String introduceCadena(String msg) {
		
		String cadena;
		
		System.out.println(msg);
		cadena = teclado.nextLine();
		
		return cadena;
	}

	private static boolean validarIdentificacion(String usuario, String contrasena) {
		
		boolean validarIdentificacion = true;
		char caracter;
		int digito = 0, letra = 0, otro = 0;
		
		if (usuario.length() > MAX_CARACTERES_USUARIO) {
			validarIdentificacion = false;
		}
		else {
			for (int i = 0; i < usuario.length() && validarIdentificacion; i++) {
				caracter = usuario.charAt(i);
				if (!(Character.isLetter(caracter))) {
					validarIdentificacion = false;
				}
			}
		}
		
		if (validarIdentificacion) {
			
			if (contrasena.length() < MIN_CARACTERES_CONTRASENA) {
				validarIdentificacion = false;
			}
			else {
				for (int j = 0; j < contrasena.length(); j++) {
					caracter = contrasena.charAt(j);
					if (Character.isDigit(caracter)) {
						digito++;
					}
					else {
						if (Character.isLetter(caracter)) {
							letra++;
						}
						else {
							otro++;
						}
					}
				}
				
				if (digito == VALOR_MINIMO || letra == VALOR_MINIMO || otro == VALOR_MINIMO) {
					validarIdentificacion = false;
				}
			}
		}

		return validarIdentificacion;
	}

}