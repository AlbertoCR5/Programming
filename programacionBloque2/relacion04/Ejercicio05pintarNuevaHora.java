package relacion04;

import java.util.Scanner;

public class Ejercicio05pintarNuevaHora {

	private static final int VALOR_MINIMO = 0;
	private static final int HORA_MAXIMA = 23;
	private static final int VALOR_MAXIMO = 59;
	private static final int HORA_A_SEGUNDO = 3600;
	private static final int MINUTO_A_SEGUNDO = 60;
	private static final char AFIRMATIVO = 'S';

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char respuesta;

		int hora, minuto, segundo, sumarSegundos;

		do {

			System.out.println("Introduce un hora");
			hora = Ejercicio01numeroEnRango.solicitarNumeroEnRango(VALOR_MINIMO, HORA_MAXIMA);
			System.out.println("Introduce un minuto");
			minuto = Ejercicio01numeroEnRango.solicitarNumeroEnRango(VALOR_MINIMO, VALOR_MAXIMO);
			System.out.println("Introduce un segundo");
			segundo = Ejercicio01numeroEnRango.solicitarNumeroEnRango(VALOR_MINIMO, VALOR_MAXIMO);
			sumarSegundos = solicitarSegundosASumar();
			conversionASegundos(hora, minuto, segundo, sumarSegundos);
			respuesta = solicitarOtraHora();
		} while (respuesta == AFIRMATIVO);

		System.out.println("Adios");
	}

	private static void conversionASegundos(int hora, int minuto, int segundo, int sumarSegundos) {

		System.out.println("La hora anterior era H:" + hora + " M:" + minuto + " S:" + segundo);
		int totalSegundos = hora * HORA_A_SEGUNDO + minuto * MINUTO_A_SEGUNDO + segundo;

		totalSegundos = totalSegundos + sumarSegundos;

		hora = totalSegundos / HORA_A_SEGUNDO % 24;
		minuto = (totalSegundos % HORA_A_SEGUNDO) / 60;
		segundo = totalSegundos % HORA_A_SEGUNDO % 60;

		System.out.println("La nueva hora es H:" + hora + " M:" + minuto + " S:" + segundo);
	}

	private static int solicitarSegundosASumar() {

		int sumarSegundos;

		System.out.println("Introduce los segundos a sumar");
		sumarSegundos = Integer.parseInt(teclado.nextLine());

		return sumarSegundos;
	}

	private static char solicitarOtraHora() {

		char respuesta;

		System.out.println("Quiere introducir otra hora?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

}