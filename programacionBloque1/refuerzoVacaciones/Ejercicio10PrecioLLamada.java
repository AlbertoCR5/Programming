package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio10PrecioLLamada {

	private static final int VALOR_MINIMO = 0;
	private static final int HORA_MAXIMA = 23;
	private static final int MINUTO_MAXIMO = 59;
	private static final int EXCESO_TIEMPO = 60;
	private static final int TOTAL_MINUTOS_DIA = 1440;
	private static final double ESTABLECIMIENTO_LLAMADA = 0.12;
	private static final double COSTE_PRIMERA_HORA = 0.06;
	private static final double COSTE_POSTERIOR_HORA = 0.10;

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int horaInicio, minutoInicio, horaFin, minutoFin, sumaHoraInicio, sumaHoraFin, minutosHablados;
		double precioLlamada;

		do {
			System.out.print("Introduce la hora de inicio de llamada: ");
			horaInicio = Integer.parseInt(teclado.nextLine());
		} while (horaInicio > HORA_MAXIMA || horaInicio < VALOR_MINIMO);

		do {
			System.out.print("Introduce el minuto de inicio de llamada: ");
			minutoInicio = Integer.parseInt(teclado.nextLine());
		} while (minutoInicio > MINUTO_MAXIMO || minutoInicio < VALOR_MINIMO);

		sumaHoraInicio = horaInicio * EXCESO_TIEMPO + minutoInicio;

		do {
			System.out.print("Introduce la hora de fin de llamada: ");
			horaFin = Integer.parseInt(teclado.nextLine());
		} while (horaFin > HORA_MAXIMA || horaFin < VALOR_MINIMO);

		do {
			System.out.print("Introduce el minuto de fin de llamada: ");
			minutoFin = Integer.parseInt(teclado.nextLine());
		} while (minutoFin > MINUTO_MAXIMO || minutoFin < VALOR_MINIMO);

		sumaHoraFin = horaFin * EXCESO_TIEMPO + minutoFin;

		minutosHablados = sumaHoraFin - sumaHoraInicio;

		if (minutosHablados < VALOR_MINIMO) {
			minutosHablados = TOTAL_MINUTOS_DIA + minutosHablados;
		}

		System.out.println("Has hablado un total de " + minutosHablados + " minutos");

		if (minutosHablados < EXCESO_TIEMPO) {
			precioLlamada = minutosHablados * COSTE_PRIMERA_HORA + ESTABLECIMIENTO_LLAMADA;
		} else {
			precioLlamada = ((minutosHablados - EXCESO_TIEMPO) * COSTE_POSTERIOR_HORA)
					+ (EXCESO_TIEMPO * COSTE_PRIMERA_HORA) + ESTABLECIMIENTO_LLAMADA;
		}

		System.out.println("El precio total de la llamada realizada es de " + precioLlamada + "€");
	}
}