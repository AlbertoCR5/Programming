package relacionArraysEjercicios;

import java.util.Random;

public class Ejercicio06ArrayParesImpares {

	private static final int CANTIDAD_NUMEROS = 20;

	public static void main(String[] args) {
		
		Random serie = new Random();
		int arrayOrdenado[] = new int [CANTIDAD_NUMEROS];
		int contador = 0;
		int contadorReverso = 19;
		
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			int numeroAleatorio = serie.nextInt(101);

			if (numeroAleatorio % 2 == 0) {
				arrayOrdenado[contador] = numeroAleatorio;
				contador++;
			}
			else {
				arrayOrdenado[contadorReverso] = numeroAleatorio;
				contadorReverso--;
			}
		}
		
		for (int i = 0; i < arrayOrdenado.length; i++) {
			System.out.print(arrayOrdenado[i] + "|");
		}
	}

}
