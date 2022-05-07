package relacion01;
import java.util.Scanner;

/*
 * 8. Realizar un programa que lea por teclado dos marcaciones de un reloj digital (horas, minutos, 
segundos) comprendidas entre las 0:0:0 y las 23:59:59 e informe cual de ellas es mayor.
 */

public class Ejercicio08horaReloj {

	private final static int VALOR_MINIMO = 0;
	private final static int HORA_LIMITE = 23;
	private final static int MINUTO_LIMITE = 59;
	private final static int HORA_A_SEGUNDOS = 3600;
	private final static int MINUTO_A_SEGUNDOS = 60;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int segundo1, minuto1, hora1, tiempoTotal1;
		int segundo2, minuto2, hora2, tiempoTotal2;

		System.out.println("Primera hora");
		System.out.println("Introduce hora");
		hora1 = teclado.nextInt();
		System.out.println("Introduce minutos");
		minuto1 = teclado.nextInt();
		System.out.println("Introduce segundos");
		segundo1 = teclado.nextInt();

		if (hora1 < VALOR_MINIMO || hora1 > HORA_LIMITE || minuto1 < VALOR_MINIMO || minuto1 > MINUTO_LIMITE
				|| segundo1 < VALOR_MINIMO || segundo1 > MINUTO_LIMITE) {
			System.out.println("Marcación incorrecta");
		} else {
			System.out.println("Marcación correcta");
			tiempoTotal1 = segundo1 + minuto1 * MINUTO_A_SEGUNDOS + hora1 * HORA_A_SEGUNDOS;

			System.out.println("Segunda hora");
			System.out.println("Introduce hora");
			hora2 = teclado.nextInt();
			System.out.println("Introduce minutos");
			minuto2 = teclado.nextInt();
			System.out.println("Introduce segundos");
			segundo2 = teclado.nextInt();

			if (hora2 < VALOR_MINIMO || hora2 > HORA_LIMITE || minuto2 < VALOR_MINIMO || minuto2 > MINUTO_LIMITE
					|| segundo2 < VALOR_MINIMO || segundo2 > MINUTO_LIMITE) {
				System.out.println("Marcación incorrecta");
			} else {
				System.out.println("Marcación correcta");
				tiempoTotal2 = segundo2 + minuto2 * MINUTO_A_SEGUNDOS + hora2 * HORA_A_SEGUNDOS;

				if (tiempoTotal1 > tiempoTotal2) {
					System.out.println("La primera marcación introducida es mayor");
				} else {
					if (tiempoTotal1 < tiempoTotal2) {
						System.out.println("La primera marcación introducida es menor");
					} else {
						System.out.println("La primera marcación y la segunda, son iguales");
					}
				}
			}

		}

	}

}
