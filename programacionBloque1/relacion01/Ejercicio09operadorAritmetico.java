package relacion01;
import java.util.Scanner;

/*
 * 9. Realizar un programa que lea un car�cter y dos n�meros enteros por teclado. Si el car�cter le�do es un 
operador aritm�tico, calcular la operaci�n correspondiente, si es cualquier otro debe mostrar un error
 */
public class Ejercicio09operadorAritmetico {
	
	private final static int DIVISOR_INVALIDO = 0;
	private final static char SUMA = '+';
	private final static char RESTA = '-';
	private final static char MULTIPLICACION = '*';
	private final static char DIVISION = '/';
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numero1, numero2;
		double resultado = 0;
		char operador;
		boolean errata = false;
		
		System.out.println("Introduce dos n�meros");
		numero1 = teclado.nextInt();
		numero2 = teclado.nextInt();
		
		System.out.println("Introduce un operador aritm�tico (+) (-) (*) (/)");
		operador = teclado.next().charAt(0);
		
		switch (operador) {
		
			case SUMA :
				resultado = numero1 + numero2;
				break;
			
			case RESTA :
				resultado = numero1 - numero2;
				break;
			
			case MULTIPLICACION :
				resultado = numero1 * numero2;
				break;
				
			case DIVISION :
				if (numero2 == DIVISOR_INVALIDO) {
					System.out.println("No se puede realizar esta operaci�n");
					errata = true;
				}
				else {
					resultado = (double) numero1 / numero2;
				}
				break;
				
			default:
				System.out.println("Operador no contemplado");
				errata = true;
				
		}
		
		if (!(errata)) {
			System.out.println("El resultado de la operaci�n es: " + resultado);
		}


	}

}
