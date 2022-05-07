package refuerzoRelacion05;

import java.util.Scanner;

public class Ejercicio01SepararNombreApellidos {

	public static final String CARACTER_A_BUSCAR = " ";
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String nombreCompleto;
		boolean esnombreCompletoValido;
		
		nombreCompleto = solicitarNombreCompleto("Introduce tu nombre completo");
		esnombreCompletoValido = comprobarNombreCompleto(nombreCompleto);
		
		if (esnombreCompletoValido) {
			tratarNombre(nombreCompleto);
		}
		else {
			System.out.println("Error, nombre introducido incorrecto");
		}
		
	}

	private static String solicitarNombreCompleto(String string) {

		String nombreCompleto;
		
		System.out.println(string);
		nombreCompleto = teclado.nextLine();
		
		return nombreCompleto;
	}

	private static boolean comprobarNombreCompleto(String nombreCompleto) {
		
		boolean esnombreCompletoValido = true;
		int espacioEncontrado = 0;
		char caracter;
		
		for (int i = 0; i < nombreCompleto.length() && esnombreCompletoValido; i++) {
			caracter = nombreCompleto.charAt(i);
			
			if (Character.isSpaceChar(caracter)) {
				espacioEncontrado++;
			}
			else {
				if ((!Character.isLetter(caracter))) {
					esnombreCompletoValido = false;
				}
			}
		}
		
		if (espacioEncontrado < 2 && espacioEncontrado > 3) {
			esnombreCompletoValido = false;
		}
		
		return esnombreCompletoValido;
	}

	private static void tratarNombre(String nombreCompleto) {
		
		StringBuilder sbNombreCompleto = new StringBuilder(nombreCompleto).reverse();		
		StringBuilder sbSegundoApellido = new StringBuilder(nombreCompleto).reverse();
		StringBuilder sbPrimerApellido = new StringBuilder(nombreCompleto).reverse();
		String espacio = CARACTER_A_BUSCAR;
		int posicionEspacio = sbNombreCompleto.indexOf(espacio);

		sbSegundoApellido.delete(posicionEspacio, sbSegundoApellido.length());
		sbNombreCompleto.delete(0, posicionEspacio+1);
		sbPrimerApellido.delete(0, posicionEspacio+1);
		posicionEspacio = sbNombreCompleto.indexOf(espacio);
		sbPrimerApellido.delete(posicionEspacio, sbPrimerApellido.length());
		sbNombreCompleto.delete(0, posicionEspacio+1);		
	
		System.out.println("El nombre es: " + sbNombreCompleto.reverse());
		System.out.println("El primer apellido es: " + sbPrimerApellido.reverse());
		System.out.println("El segundo apellido es: " + sbSegundoApellido.reverse());

	}


}
