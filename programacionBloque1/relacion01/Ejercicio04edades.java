package relacion01;
import java.util.Scanner;

/*
 *Realizar un programa que lea la edad de una persona menor a 100 años e informe de si es un niño (0-
12 años), un adolescente (13-17), un joven (18-29) o un adulto.
 */
public class Ejercicio04edades {

	private final static int EDAD_MINIMA = 0;
	private final static int EDAD_MAXIMA = 99;
	private final static int EDAD_NINO = 12;
	private final static int EDAD_ADOLESCENTE = 17;
	private final static int EDAD_JOVEN = 29;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int edad;

		System.out.println("Introduce tu edad");
		edad = teclado.nextInt();

		if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
			System.out.println("Error, edad no contemplada " + edad);
		} else {
			if (edad > EDAD_JOVEN) {
				System.out.println("Eres un adulto");
			} else {
				if (edad > EDAD_ADOLESCENTE) {
					System.out.println("Eres joven");
				} else {
					if (edad > EDAD_NINO) {
						System.out.println("Eres un adolescente");
					} else {
						System.out.println("Eres un nino");
					}
				}
			}

		}
	}

}
