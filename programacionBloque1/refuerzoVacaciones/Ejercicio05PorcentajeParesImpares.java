package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio05PorcentajeParesImpares {

	private static final int TOTAL_NUMEROS = 10;

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int numero, cantidadPares = 0;
		int porcentaje;
		
		for (int i = 1; i <= TOTAL_NUMEROS; i++) {
			System.out.print("Introduce un numero " + i + "/" + TOTAL_NUMEROS + ": ");
			numero = Integer.parseInt(teclado.nextLine());
			
			if (numero % 2 == 0) {
				cantidadPares++;
			}
		}
		
		porcentaje = cantidadPares * 100 / TOTAL_NUMEROS;
		System.out.println("Hay " + cantidadPares + " numeros pares");
		cantidadPares = TOTAL_NUMEROS - cantidadPares;
		System.out.println("Hay " + cantidadPares + " numeros impares");
		System.out.println("El porcentaje de pares es " + porcentaje + "%");
		porcentaje = 100 - porcentaje;
		System.out.println("El porcentaje de impares es " + porcentaje + "%");
	}

}
