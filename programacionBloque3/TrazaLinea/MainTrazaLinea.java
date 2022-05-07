package TrazaLinea;

import java.util.Scanner;

public class MainTrazaLinea {

	private static final int OPCIONES = 3;

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		Linea linea;

		try {
			linea = crearLinea();

			do {
				opcion = mostrarMenu();
				tratarOpcion(opcion, linea);
			} while (opcion != OPCIONES);

		} catch (TrazaLineaException e) {
			mostrarMensaje(e.getMessage());
		}

	}

	private static Linea crearLinea() throws TrazaLineaException {

		Linea linea = null;
		Punto puntoOrigen, puntoDestino;
		boolean esFallido = false;

		do {
			try {
				puntoOrigen = crearPunto("Primer punto:");
				puntoDestino = crearPunto("Segundo punto");

				linea = new Linea(puntoOrigen, puntoDestino);
			} catch (TrazaLineaException e) {
				mostrarMensaje(e.getMessage());
				mostrarMensaje("Error al crear la linea, intentelo de nuevo");
				esFallido = true;
			}
		} while (esFallido);

		return linea;
	}

	private static Punto crearPunto(String msg) {

		Punto punto;
		double latitud, longitud;

		mostrarMensaje(msg);
		mostrarMensaje("Introduzca la posicion de latitud");
		latitud = solicitarDoble();

		mostrarMensaje("Introduzca la posicion de longitud");
		longitud = solicitarDoble();

		punto = new Punto(latitud, longitud);

		return punto;
	}

	private static int mostrarMenu() {

		int opcion;

		mostrarMensaje("1. Mover línea:\r\n" + "2. Mostrar línea\r\n" + "3. Salir");
		opcion = Integer.parseInt(teclado.nextLine());

		return opcion;
	}

	private static void tratarOpcion(int opcion, Linea linea) {

		char respuesta;
		switch (opcion) {
		case 1:
			do {
				mostrarMensaje("Mover linea: (A-arriba, B-ABajo, I-Izquierda, D-Derecha)");
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
				trazarLinea(respuesta, linea);
			} while (respuesta != 'A' && respuesta != 'B' && respuesta != 'D' && respuesta != 'I');
			break;

		case 2:
			mostrarMensaje(linea.toString());
			break;

		default:
			mostrarMensaje("CIAO, CIAo, CIao, Ciao...");
			break;
		}

	}

	private static void trazarLinea(char respuesta, Linea linea) {

		double movimiento;

		try {

			switch (respuesta) {
			case 'A':
				mostrarMensaje("A cuanta longitud norte?");
				movimiento = solicitarDoble();
				linea.moverArriba(movimiento);
				break;

			case 'B':
				mostrarMensaje("A cuanta longitud sur?");
				movimiento = solicitarDoble();
				linea.moverAbajo(movimiento);
				break;

			case 'D':
				mostrarMensaje("A cuanta latitud este?");
				movimiento = solicitarDoble();
				linea.moverDerecha(movimiento);
				break;

			case 'I':
				mostrarMensaje("A cuanta latitud oeste?");
				movimiento = solicitarDoble();
				linea.moverIzquierda(movimiento);
				break;

			default:
				mostrarMensaje("Respuesta no valida, rebote");
				break;
			}
		} catch (TrazaLineaException e) {
			mostrarMensaje(e.getMessage());
		}

	}

	private static double solicitarDoble() {

		double numeroReal;

		numeroReal = Double.parseDouble(teclado.nextLine());

		return numeroReal;
	}

	private static void mostrarMensaje(String message) {

		System.out.println(message);

	}

}
