package Ejercicio04Jarra;

import java.util.Scanner;

public class MainJarra {

	static final int OPCIONES = 6;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		Jarra jarraA, jarraB;
		int opcion;

		jarraA = crearJarra();
		jarraB = crearJarra();
		
		try {
			do {
				opcion = mostrarMenu();
				ejecutarMenu(jarraA, jarraB, opcion);
			} while (opcion != OPCIONES);
		} catch (JarraException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Jarra crearJarra() {
		
		int capacidad;
		boolean esFallido;
		Jarra jarra = null;
		
		do {
			try {
				capacidad = solicitarCapacidadJarra("Introduce la capacidad de la jarra");
				jarra = new Jarra(capacidad);
				esFallido = false;
			} catch (JarraException e) {
				System.out.println(e.getMessage());
				mostrarMensaje("Error al crear la jarra, intentelo de nuevo");
				esFallido = true;
			}
		} while (esFallido);
		
		return jarra;
	}

	private static int solicitarCapacidadJarra(String string) {
		
		int capacidad;
		
		mostrarMensaje(string);;
		capacidad = teclado.nextInt();
		
		return capacidad;
	}
	
	private static int mostrarMenu() {
		
		int opcion;
		
		do {
			mostrarMensaje("¿Que desea realizar con la jarra? \r\n"
					+ "LLenar jarra (1) \r\n"
					+ "Vaciar jarra (2) \r\n"
					+ "Volcar jarra1 en jarra2 (3) \r\n"
					+ "Volcar jarra2 en jarra1 (4) \r\n"
					+ "Ver estado de las jarras (5) \r\n"
					+ "Mostrar cantidad de agua servida y Salir (6)");
			opcion = teclado.nextInt();
		} while (opcion <= Jarra.VALOR_MINIMO || opcion > OPCIONES);
		
		return opcion;
	}

	private static void ejecutarMenu(Jarra jarraA, Jarra jarraB, int opcion) throws JarraException {

		int seleccionarJarra;
		
		switch (opcion) {
		
		case 1:
			mostrarMensaje("Que jarra quiere llenar? JarraA(1) o JarraB(2)");
			seleccionarJarra = teclado.nextInt();
			try {
				if (seleccionarJarra == 1) {
					jarraA.llenarJarra();
				}
				else {
					jarraB.llenarJarra();
				}
			} catch (JarraException e) {
				mostrarMensaje(e.getMessage());
			}
			break;
		
		case 2:
			mostrarMensaje("Que jarra quiere vaciar Jarra1(1) o Jarra2(2)");
			seleccionarJarra = teclado.nextInt();

			if (seleccionarJarra == 1) {
				jarraA.vaciarJarra();
			}
			else {
				jarraB.vaciarJarra();
			}
			break;
			
		case 3:
			jarraA.volcarJarra(jarraB);
			mostrarMensaje("La jarra se ha volcado satisfactoriamente");
			break;
		
		case 4:
			jarraB.volcarJarra(jarraA);
			mostrarMensaje("La jarra se ha volcado satisfactoriamente");
			break;
			
		case 5:
			mostrarMensaje(jarraA.toString());
			mostrarMensaje(jarraB.toString());
			break;
			
		default:
			System.out.println(Jarra.totalAguaServida);
			break;
		}
		
	}

	private static void mostrarMensaje(String string) {
		
		System.out.println(string);
		
	}

}
