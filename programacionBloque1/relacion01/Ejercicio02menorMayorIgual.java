package relacion01;
import java.util.Scanner;

/*
 *Realizar un programa que solicite dos n�meros por teclado e imprima en pantalla si son iguales, el 
primero mayor que el segundo o el primero m�s peque�o que el segundo.
 */
public class Ejercicio02menorMayorIgual {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double numero1, numero2;

		System.out.println("Introduce dos n�meros");
		numero1 = teclado.nextDouble();
		numero2 = teclado.nextDouble();

		if (numero1 == numero2) {
			System.out.println("Los n�meros introducidos son iguales");
		} else {
			if (numero1 < numero2) {
				System.out.println("El primer n�mero introducido es menor que el segundo");
			} else {
				System.out.println("El primer n�mero introducido es mayor que el segundo");
			}
		}

	}

}
