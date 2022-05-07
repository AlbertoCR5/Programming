package ExamenBloque3Array;

import java.util.Scanner;

public class PrincipalEjercicio2 {

	private static Scanner teclado=new Scanner(System.in);
	private static final int TAMANNO = 8;
	private static final String[] COLORES= {"ROJO", "AMARILLO", "AZUL", "VERDE", "NARANJA", "VIOLETA", "ROSA", "BLANCO", "NEGRO", "MARRON"};
	public static void main(String[] args) {
		
		String[] palabras=new String[TAMANNO];
		
		solicitarPalabras(palabras);
		
		System.out.println("Antes: ");
		mostrarPalabras(palabras);
		
		colocarColoresPrincipio(palabras);
		
		System.out.println("Despues: ");
		mostrarPalabras(palabras);
		

	
	}
	
	//TODO
	/**
	 * Devuelve true si la cadena que se pasa como parámetro está en el array COLORES, y false en caso contrario
	 * @param cadena
	 * @return
	 */
	
	private static boolean esColor(String cadena) {
		
		boolean esColor = false;;
		
		for (int i = 0; i < COLORES.length && esColor == false; i++) {
			if(COLORES[i].equals(cadena)) {
				esColor = true;
			}			
		}
		
		return esColor;
	}

	private static void colocarColoresPrincipio(String[] palabras) {
		
		String[] palabrasOrdenadas = new String[TAMANNO];
		int contador = 0;
		int contadorInverso = palabras.length - 1;
		for (int i = 0; i < palabrasOrdenadas.length; i++) {
			if (esColor(palabras[i])) {
				palabrasOrdenadas[contador] = palabras[i];
				contador++;
			}
			else {
				palabrasOrdenadas[contadorInverso] = palabras[i];
				contadorInverso--;
			}
		}
		for (int i = 0; i < palabrasOrdenadas.length; i++) {
			palabras[i] = palabrasOrdenadas[i];
		}
		
	}
	
	
	private static void mostrarPalabras(String[] palabras) {
	
		for (int i = 0; i < palabras.length; i++) {
			System.out.print(palabras[i].toLowerCase() + " ");
		}
		System.out.println("\n");
		
	}
	private static void solicitarPalabras(String[] palabras) {
		
		for (int i = 0; i < palabras.length; i++) {
			System.out.print("Palabra " + (i+1) + ":");
			palabras[i]= teclado.nextLine().toUpperCase();
		}
		
		
	}

}
