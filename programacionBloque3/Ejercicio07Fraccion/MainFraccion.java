package Ejercicio07Fraccion;

import java.util.Scanner;

public class MainFraccion {

	private static final int OPCIONES = 5;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int opcion;
		Fraccion fraccion1;
		Fraccion fraccion2;
		
		fraccion1 = MainFraccion.crearFraccion("Fraccion 1");
		fraccion2 = MainFraccion.crearFraccion("Fraccion 2");
		
		do {
			mostrarmensaje("Que operacion desea realizar: \r\n"
					+ "Suma de fracciones(1) \r\n"
					+ "Resta de fracciones(2) \r\n"
					+ "Multiplicacion de fracciones(3) \r\n"
					+ "Division de fracciones(4) \r\n"
					+ "Salir(5)");
			opcion = comprobarNumero();
			tratarMenu(opcion, fraccion1, fraccion2);
		} while (opcion != OPCIONES);
		
		
	}

	private static void tratarMenu(int opcion, Fraccion fraccion1, Fraccion fraccion2) {
		
		try {
			
			switch (opcion) {
			case 1:
				mostrarmensaje("El resultado de la suma es " + fraccion1.sumar(fraccion2));
				break;

			case 2:
				mostrarmensaje("El resultado de la resta es " + fraccion1.restar(fraccion2));
				break;
				
			case 3:
				mostrarmensaje("El resultado de la multiplicacion es " + fraccion1.multiplicar(fraccion2));
				break;
				
			case 4:
				mostrarmensaje("El resultado de la division es " + fraccion1.dividir(fraccion2));
				break;
				
			default:
				mostrarmensaje("adios");
				break;
			}
		} catch (FraccionException e) {
			mostrarmensaje(e.getMessage());
		}
		
	}

	private static Fraccion crearFraccion(String string) {
		
		Fraccion fraccion = null;
		int numerador, denominador;
		boolean esErroneo;
		
		mostrarmensaje(string);
		do {
			try {
				esErroneo = false;
				mostrarmensaje("Introduce el numerador");
				numerador = comprobarNumero();
				mostrarmensaje("Introduce el denominador");
				denominador = comprobarNumero();
				fraccion = new Fraccion(numerador, denominador);
			} catch (FraccionException e) {
				mostrarmensaje(e.getMessage());
				esErroneo = true;
			}
		} while (esErroneo);
		
		return fraccion;
	}

	private static int comprobarNumero() {
		
		int numero = 0;
		boolean esErroneo;
			
		do {
			try {
				esErroneo = false;
				numero = Integer.parseInt(teclado.nextLine());			
			} catch (NumberFormatException e) {
				mostrarmensaje(e.getMessage());
				esErroneo = true;
			}
			
		} while (esErroneo);
		
		return numero;
	}

	private static void mostrarmensaje(String msg) {
		
		System.out.println(msg);
		
	}
	
}
