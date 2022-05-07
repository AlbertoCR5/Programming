package practicasExamenes;

import java.util.Scanner;

public class ExamenValidarNuevaContrasena {

	private static final int MAXIMO_COINCIDENCIAS = 4;
	private static final int MINIMO_CARACTERES_CONTRASENA = 8;
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		String contrasena, repetirContrasena, nuevaContrasena;
		boolean esCoincidida, esValida;
		
		contrasena = solicitarContrasena("Introduce contrasena anterior: ");
		repetirContrasena = solicitarContrasena("Introduce de nuevo contrasena anterior: ");
		esCoincidida = comprobarContrasenasAnteriores(contrasena, repetirContrasena);
		
		if (esCoincidida) {
			nuevaContrasena = solicitarContrasena("Introduce nueva contrasena: ");
			esValida = comprobarNuevaContrasena(contrasena, nuevaContrasena);
			
			if (esValida) {
				System.out.println("Contrasena cambiada exitosamente");
			}
		}
		else {
			System.out.println("Las contrasenas introducidas no coinciden");
		}
		
	}

	private static boolean comprobarNuevaContrasena(String contrasena, String nuevaContrasena) {
		
		boolean esValida = true;
		int j = 0;
		int coincidencia = 0;
		char caracterNueva, caracterAnterior;
		
		if (nuevaContrasena.length() < MINIMO_CARACTERES_CONTRASENA) {
			esValida = false;
			System.out.println("La nueva contraseña no es válida, no tiene los 8 caracteres mínimos.");
		}
		else {
			for (int i = 0; i < nuevaContrasena.length() && esValida; i++) {
				caracterNueva = nuevaContrasena.charAt(i);
				caracterAnterior = contrasena.charAt(j);
				if (Character.isSpaceChar(caracterNueva)) {
					esValida = false;
					System.out.println("La nueva contrasena no puede contener espacios");
				}
				else {
					if (i < contrasena.length()) {
						if (caracterNueva == caracterAnterior) {
							coincidencia++;
							j++;
						}
					}
					
				}
				
			}
		}
		
		if (coincidencia > MAXIMO_COINCIDENCIAS) {			
			esValida = false;
			System.out.println("La nueva contrasena es similar a la anterior");
		}
		
		
		return esValida;
	}

	private static boolean comprobarContrasenasAnteriores(String contrasena, String repetirContrasena) {
		
		boolean esCoincidida = false;
		
		if (contrasena.equals(repetirContrasena)) {
			esCoincidida = true;
		}
		
		return esCoincidida;
	}

	private static String solicitarContrasena(String string) {
		
		String contrasena;
		
		System.out.print(string);
		contrasena = teclado.nextLine();
		
		return contrasena;
	}

}
