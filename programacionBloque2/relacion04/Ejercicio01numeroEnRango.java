package relacion04;

import java.util.Scanner;

public class Ejercicio01numeroEnRango {
	
	static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {
		
		//Variables
		int numero;
		int limiteInferior;
		int limiteSuperior;
		
		System.out.println("Introduce el l�mite inferior");
		limiteInferior = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce el l�mite superior");
		limiteSuperior = Integer.parseInt(teclado.nextLine());
		
		numero = Ejercicio01numeroEnRango.solicitarNumeroEnRango (limiteInferior, limiteSuperior);
		
		System.out.println("el n�mero es: " + numero);
	}
	/**
	 * Método que solicita un n�mero en un rango determinado por un 
	 * l�mite superior y otro superior y vuelve a solicitarse si es incorrecto. 
	 * Si el limite inferior es mayor que el superior, tambi�n solicita el numero
	 * @param string 
	 * @param limiteInf limite inferior del rango
	 * @param limiteSup limite superior del rango
	 * @return numero en el rango
	 */
	public static int solicitarNumeroEnRango (int limiteInferior, int limiteSuperior) {
	
		int numero;
		int auxiliar;
		
		// Si el límite inferior es mayor que el límite superior, se intercambian
		if (limiteInferior > limiteSuperior) {
			auxiliar = limiteInferior;
			limiteInferior = limiteSuperior;
			limiteSuperior = auxiliar;
		}
		
		do {
			//System.out.println("Introduce un n�mero");
			numero = Integer.parseInt(teclado.nextLine());
		}while (numero < limiteInferior || numero > limiteSuperior);
		
		return numero;
		
	}
}

