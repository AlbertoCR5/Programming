package refuerzoEstructurasControl;

import java.util.Scanner;

public class SumaNominas {
	
	static final int VALOR_MINIMO = 0;
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		char respuesta;
		
		do {
			int contador = 1;
			double numero, total = 0;
			do {
				System.out.println("Introduce nomina numero " + contador);
				numero = Double.parseDouble(teclado.nextLine());
				total = total +  numero;
				contador++;
			} while (numero != VALOR_MINIMO);
			contador = contador - 2;
			
			System.out.println("El importe total es: " +  total);
			System.out.println("Se han introducido " + contador + " nominas");
			System.out.println();
			System.out.println("Otro compañero?");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);

		} while (respuesta != 'N');
		
	}

}
