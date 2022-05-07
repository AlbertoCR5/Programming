
package Ejercicio07FraccionBIs;

import java.util.Scanner;

public class MainFraccion {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Fraccion fraccion1;
		Fraccion fraccion2;
		
		fraccion1 = MainFraccion.crearFraccion("1");
		fraccion2 = MainFraccion.crearFraccion("2");
		
		System.out.println("La suma es " + fraccion1.sumar(fraccion2));
		System.out.println("La resta es " + fraccion1.restar(fraccion2));
		System.out.println("La multiplicacion es " + fraccion1.multiplicar(fraccion2));
		
		try {
			System.out.println("La division es " + fraccion1.dividir(fraccion2));
		} catch (FraccionException e) {
			System.out.println(e.getMessage());
		}
		
	//	fraccion1.simplificar();
		//fraccion2.simplificar();
		System.out.println("La fraccion 1 simpleficando es " + fraccion1 +  " y el 2 es " + fraccion2);

	}

	private static Fraccion crearFraccion(String cadena) {
		
		int numerador, denominador;
		Fraccion fraccion = null;
		boolean error;
		
		do {
			try {
				error = false;
				numerador = solicitarNumero("Introduce el numerador " + cadena + ":");
				denominador = solicitarNumero("Introduce el denominador " + cadena + ":");
				fraccion = new Fraccion(numerador, denominador);
			} catch (FraccionException ex) {
				error = true;
				System.out.println(ex.getMessage());
			}
		} while (error);

		return fraccion;
	}

	private static int solicitarNumero(String mensaje) {
		
		String cadena;
		int numero = 0;
		boolean error;
		
		do {
			try {
				error = false;
				System.out.println(mensaje);
				cadena = teclado.nextLine();
				numero = Integer.parseInt(cadena);				
			}catch (NumberFormatException ex) {
				error = true;
				System.out.println("No es un numero");
			}
		}while (error);
		
		return numero;
	}	
	
}
