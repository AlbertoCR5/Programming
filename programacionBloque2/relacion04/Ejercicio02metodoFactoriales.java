package relacion04;

import java.util.Scanner;

public class Ejercicio02metodoFactoriales {
	
	private static final String MENSAJE_ERROR = "ERROR";
	private static final int ERROR = -1;
	private static final int VALOR_MINIMO = 0;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numero = solicitarNumero();
		boolean numeroCorrecto = comprobarNumero(numero);
		
		if (numeroCorrecto) {
			calcularFactorial(numero);
		}
		
	}

	private static int solicitarNumero() {

		int numero;
		
		System.out.print("introduce un numero limite para calcular factoriales: ");
		numero = Integer.parseInt(teclado.nextLine());
		
		return numero;
	}

	private static boolean comprobarNumero(int numero) {

		boolean numeroCorrecto = true;
		
		if (numero < VALOR_MINIMO) {
			numeroCorrecto = false;
			System.out.println(MENSAJE_ERROR);
			System.out.println(ERROR);
		}
		
		return numeroCorrecto;
	}

	private static void calcularFactorial(int numero) {

		long factorial = 1;
		
		for (int i = 0; i <= numero; i++) {
			factorial = factorial * i;
			if (factorial == 0) {
				factorial = 1;
			}
			
			System.out.println(i+"! = " + factorial);		
		}
		
	}

}
