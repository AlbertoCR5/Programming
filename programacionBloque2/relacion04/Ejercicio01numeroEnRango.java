package relacion04;

import java.util.Scanner;

public class Ejercicio01numeroEnRango {
	
	static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {
		
		//Variables
		int numero;
		int limiteInferior;
		int limiteSuperior;
		
		System.out.println("Introduce el límite inferior");
		limiteInferior = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce el límite superior");
		limiteSuperior = Integer.parseInt(teclado.nextLine());
		
		numero = Ejercicio01numeroEnRango.solicitarNumeroEnRango (limiteInferior, limiteSuperior);
		
		System.out.println("el número es: " + numero);
	}
	/**
	 * MÃ©todo que solicita un número en un rango determinado por un 
	 * límite superior y otro superior y vuelve a solicitarse si es incorrecto. 
	 * Si el limite inferior es mayor que el superior, también solicita el numero
	 * @param string 
	 * @param limiteInf limite inferior del rango
	 * @param limiteSup limite superior del rango
	 * @return numero en el rango
	 */
	public static int solicitarNumeroEnRango (int limiteInferior, int limiteSuperior) {
	
		int numero;
		int auxiliar;
		
		// Si el lÃ­mite inferior es mayor que el lÃ­mite superior, se intercambian
		if (limiteInferior > limiteSuperior) {
			auxiliar = limiteInferior;
			limiteInferior = limiteSuperior;
			limiteSuperior = auxiliar;
		}
		
		do {
			//System.out.println("Introduce un número");
			numero = Integer.parseInt(teclado.nextLine());
		}while (numero < limiteInferior || numero > limiteSuperior);
		
		return numero;
		
	}
}

