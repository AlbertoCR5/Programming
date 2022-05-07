package relacion01;
import java.util.Scanner;

/*
 *Realizar un programa que solicite 4 números e imprima la media de los números. También debe 
imprimir aquellos números que son superiores a la media. 
 */
public class Ejercicio05media {

	private static final int CANTIDAD_NUMEROS = 4;
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numero1, numero2, numero3, numero4;
		double media;
		
		System.out.println("Introduce " + CANTIDAD_NUMEROS + " números");
		numero1 = teclado.nextInt();
		numero2 = teclado.nextInt();
		numero3 = teclado.nextInt();
		numero4 = teclado.nextInt();
		
		media = (double)(numero1 + numero2 + numero3 + numero4) / CANTIDAD_NUMEROS;

		System.out.println("La media de los números introducidos es: " 
		+ media);
		
		System.out.println("Los numeros superiores a la media son: ");
		if (numero1 > media) {
			System.out.println(numero1);
		}
		if (numero2 > media) {
			System.out.println(numero2);
		}
		if (numero3 > media) {
			System.out.println(numero3);
		}
		if (numero4 > media) {
			System.out.println(numero4);
		}

	}

}
