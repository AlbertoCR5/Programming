package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio12SolicitaNumerosHastaCondicion {

	private static final int CANTIDAD_NUMEROS = 10;
	private static final int SUMA_MAXIMA = 100;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numero, sumaNumeros = 0, numerosIntroducidos = 0;

		do {
			System.out.print("Introduce un numero: ");
			numero = Integer.parseInt(teclado.nextLine());
			numerosIntroducidos++;
			System.out.println(numerosIntroducidos);
			sumaNumeros = sumaNumeros + numero;
			System.out.println(sumaNumeros);
		} while (numerosIntroducidos < CANTIDAD_NUMEROS && sumaNumeros <= SUMA_MAXIMA);

		if (numerosIntroducidos >= CANTIDAD_NUMEROS && sumaNumeros > SUMA_MAXIMA) {
			System.out.println("Se han cumplido las dos condiciones.");
		} else {
			if (sumaNumeros > SUMA_MAXIMA) {
				System.out.println("Se ha superado la suma maxima permitida. " + SUMA_MAXIMA);
			} else {
				System.out.println("Se han introducido el maximo de numeros permitidos. " + CANTIDAD_NUMEROS);
			}
		}
	}

}
