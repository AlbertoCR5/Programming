package relacion04;

import java.util.Scanner;

public class Ejercicio01numeroEnRangoB {
	
	static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {
		
		//Variables
		int numero;
		int limiteInferior;
		int limiteSuperior;
		
		System.out.println("Introduce el limite inferior");
		limiteInferior = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce el limite superior");
		limiteSuperior = Integer.parseInt(teclado.nextLine());
		
		numero = Ejercicio01numeroEnRangoB.solicitarNumeroEnRango ("Introduce un numero", limiteInferior, limiteSuperior);
		
		System.out.println("el numero es: " + numero);
	}
	/**
	 * Método que solicita un numero en un rango determinado por un 
	 * limite superior y otro superior y vuelve a solicitarse si es incorrecto. 
	 * Si el limite inferior es mayor que el superior, tambien solicita el numero
	 * @param string 
	 * @param limiteInf limite inferior del rango
	 * @param limiteSup limite superior del rango
	 * @return numero en el rango
	 */
	public static int solicitarNumeroEnRango (String msg, int limiteInferior, int limiteSuperior) {
	
		int numero;
		int auxiliar;
		
		// Si el límite inferior es mayor que el límite superior, se intercambian
		if (limiteInferior > limiteSuperior) {
			auxiliar = limiteInferior;
			limiteInferior = limiteSuperior;
			limiteSuperior = auxiliar;
		}
		
		do {
			System.out.println(msg);
			numero = Integer.parseInt(teclado.nextLine());
		}while (numero < limiteInferior || numero > limiteSuperior);
		
		return numero;
		
	}
}


