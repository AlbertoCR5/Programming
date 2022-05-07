package relacion01;
import java.util.Scanner;

/*
 *Realizar un programa que lea un número entero por teclado e informe de si el número es par o impar 
(el cero se considera par).
 */
public class Ejercicio01parImpar {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero;

		System.out.println("Introduce un número entero");
		numero = teclado.nextInt();

		if (numero % 2 == 0) {
			System.out.println("El número introducido es par");
		} else {
			System.out.println("El número introducido es impar");
		}

	}

}
