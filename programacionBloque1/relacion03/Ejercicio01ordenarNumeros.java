package relacion03;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01ordenarNumeros {

	public static final int CANTIDAD_NUMEROS = 3;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numeros[] = new int [CANTIDAD_NUMEROS];
		
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			System.out.println("Introduzca un número");
			numeros [i] = teclado.nextInt();
		}
		Arrays.sort(numeros);
		
		//Muestar por pantalla los numeros ordenados de menor a mayor
		System.out.println("menor a MAYOR");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
		//Muestar por pantalla los numeros ordenados de mayor a menor
		System.out.println("MAYOR a menor");
		for (int i = CANTIDAD_NUMEROS-1; i >= 0; i--) {
			System.out.println(numeros[i]);
		}

	}

}
