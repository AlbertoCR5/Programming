package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio01conversorPesetasEuros {

	private static final int VALOR_MINIMO = 0;
	private static final double EURO_A_PESETA = 166.386;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double dinero, cambio;
		int opcion;

		do {
			System.out.println("Bienvenido al conversor");
			System.out.println("(1)Pesetas->Euros");
			System.out.println("(2)Euros->Pesetas");
			System.out.println("(0)Salir del conversor");
			opcion = teclado.nextInt();

			switch (opcion) {

			case 0:
				System.out.println("Ádios");
				break;

			case 1:
				System.out.println("Introduce la cantidad de pesetas a cambiar");
				dinero = teclado.nextDouble();

				cambio = dinero / EURO_A_PESETA;
				System.out.printf("Las " + dinero + " pesetas serian " + "%.2f", cambio, " euros.");
				System.out.println();
				break;

			case 2:
				System.out.println("Introduce la cantidad de euros a cambiar");
				dinero = teclado.nextDouble();

				cambio = dinero * EURO_A_PESETA;
				System.out.println("Los " + dinero + " euros serian " + (int)cambio + " pesetas.");
				System.out.println();
				break;

			}

		} while (opcion != VALOR_MINIMO);

	}

}
