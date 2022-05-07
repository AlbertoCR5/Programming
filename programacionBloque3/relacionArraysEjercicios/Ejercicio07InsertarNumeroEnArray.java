package relacionArraysEjercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio07InsertarNumeroEnArray {

	private static final int CANTIDAD_NUMEROS = 12;

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Random serie = new Random();
		int arrayOrdenado[] = new int [CANTIDAD_NUMEROS];
		
			for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
				int numeroAleatorio = serie.nextInt(201);
				arrayOrdenado[i] = numeroAleatorio;
				System.out.print(i + " |");
			}
			System.out.println();
			for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
				System.out.print("---");
			}
			System.out.println();
			for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
				System.out.print(arrayOrdenado[i] + "|");
			}
		
		System.out.println();
		System.out.println("Introduce numero a insertar");
		int numero = teclado.nextInt();
		
		System.out.println("Introduce posicion (0-11)");
		int posicion = teclado.nextInt();
		
		for (int i = CANTIDAD_NUMEROS - 1; i > posicion; i--) {
			arrayOrdenado[i] = arrayOrdenado[i-1];
			
		}
		arrayOrdenado[posicion] = numero;
		
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {

			System.out.print(i + " |");
		}
		System.out.println();
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			System.out.print("---");
		}
		System.out.println();
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			System.out.print(arrayOrdenado[i] + "|");
		}
	
	}
	
	

}
