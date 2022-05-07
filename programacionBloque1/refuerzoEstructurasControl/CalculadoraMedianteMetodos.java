package refuerzoEstructurasControl;

import java.util.Scanner;

public class CalculadoraMedianteMetodos {
	
	private final static int VALOR_MINIMO = 0;
	private final static int OPCIONES = 7;
	private static final int ERROR = -1;
	private static final String MENSAJE_ERROR = "ERROR";
	
	static Scanner teclado=new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		
		do {
		opcion = menu();
		gestionDeMenu(opcion);
		} while (opcion != OPCIONES);
		
	}

	/**
	 * Metodo que muestra el menu y solicita una opcion mientras que el numero introducido este fuera de rango 1-7
	 * @return opcion
	 */
	private static int menu() {
		
		int opcion;
		
		do {
			System.out.println("Introduce una opcion");
			System.out.println("(1)SUMA");
			System.out.println("(2)RESTA");
			System.out.println("(3)MULTIPLICACION");
			System.out.println("(4)DIVISION");
			System.out.println("(5)POTENCIA");
			System.out.println("(6)FACTORIAL");
			System.out.println("(7)SALIR");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion <= VALOR_MINIMO || opcion > OPCIONES);
		
		return opcion;
	}
	
	/**
	 * Metodo que realizara una operacion dependiendo de la opcion que hayamos indicado anteriormente
	 * @param opcion
	 */
	private static void gestionDeMenu(int opcion) {

		int cantidadNumeros;
		double resultado;
		
		switch (opcion) {
		
		case 1:
			cantidadNumeros = solicitarCantidadNumeros("Introduce cantidad de numeros a sumar");
			resultado = operacionSuma(cantidadNumeros);
			System.out.println("El resultado de la suma es: " + resultado);
			break;
			
		case 2:
			cantidadNumeros = solicitarCantidadNumeros("Introduce cantidad de numeros a restar");
			resultado = operacionResta(cantidadNumeros);
			System.out.println(resultado);
			break;
			
		case 3:
			cantidadNumeros = solicitarCantidadNumeros("Introduce cantidad de numeros a multiplicar");
			resultado = operacionMultiplicacion(cantidadNumeros);
			System.out.println(resultado);
			break;
			
		case 4:
			resultado = operacionDivision("Introduce dos numeros");
			System.out.println(resultado);
			break;
			
		case 5:
			resultado = operacionPotencia("Introduce base y exponente");
			System.out.println(resultado);
			break;
			
		case 6:
			resultado = operacionFactorial("Introduce un numero");
			System.out.println(resultado);
			break;
			
		default: 
			System.out.println("Adios");
			break;
			
		}
		
	}

	/**
	 * Metodo que solicita cantidad de numeros que se van a sumar, restar o multiplicar
	 * @param Muestra el mensaje concreto de cada operacion
	 * @return cantidad de numeros
	 */
	private static int solicitarCantidadNumeros(String msg) {
		
		int cantidadNumeros;
		
		do {
			System.out.println(msg);
			cantidadNumeros = Integer.parseInt(teclado.nextLine());
		} while (cantidadNumeros <= 1);
		
		return cantidadNumeros;
	}
	
	/**
	 * Metodo que calcula la suma de todos los numeros que se introduzcan
	 * @param cantidadNumeros
	 * @return resultado
	 */
	private static double operacionSuma(int cantidadNumeros) {
		
		double resultado = 0;
		int numero;
		
		for (int i = 1; i <= cantidadNumeros; i++) {
			System.out.println("Introduce numero " + i + "/" + cantidadNumeros);
			numero = Integer.parseInt(teclado.nextLine());
			
			resultado = resultado +  numero;
		}
		
		return resultado;
		
	}
	
	/**
	 * Metodo que calcula la resta de todos los numeros que se introduzcan
	 * @param cantidadNumeros
	 * @return resultado
	 */
	private static double operacionResta(int cantidadNumeros) {
		
		double resultado = 0;
		int numero, copiaNumero = 0;
		
		for (int i = 1; i <= cantidadNumeros; i++) {
			System.out.println("Introduce numero " + i + "/" + cantidadNumeros);
			numero = Integer.parseInt(teclado.nextLine());
			if (i == 1) {
				copiaNumero = numero;
			}
			
			
			resultado = resultado -  numero;
		}
		
		return resultado + copiaNumero * 2;
	}
	
	/**
	 * Metodo que calcula la multiplicacion de todos los numeros que se introduzcan
	 * @param cantidadNumeros
	 * @return resultado
	 */
	private static double operacionMultiplicacion(int cantidadNumeros) {
		
		double resultado = 1;
		int numero;
		
		for (int i = 1; i <= cantidadNumeros; i++) {
			System.out.println("Introduce numero " + i + "/" + cantidadNumeros);
			numero = Integer.parseInt(teclado.nextLine());
			
			resultado = resultado *  numero;
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que solicita dividendo y divisor y calcula la operacion
	 * @param Muestra el mensaje concreto de cada operacion
	 * @return resultado
	 */
	private static double operacionDivision(String msg) {
		
		double resultado;
		int dividendo, divisor;
		
		System.out.println(msg);
		dividendo = Integer.parseInt(teclado.nextLine());
		divisor = Integer.parseInt(teclado.nextLine());
		
		if (divisor == VALOR_MINIMO) {
			System.out.println(MENSAJE_ERROR);
			resultado = ERROR;
		}
		else {
			resultado =(double) dividendo / divisor;
		}
		
		
		return resultado;
	}

	/**
	 * Metodo que solicita base y exponente
	 * @param Muestra el mensaje concreto de cada operacion
	 * @return resultado
	 */
	private static double operacionPotencia(String msg) {
		
		double resultado = 1;
		int base, exponente;
		
		System.out.println(msg);
		base = Integer.parseInt(teclado.nextLine());
		exponente = Integer.parseInt(teclado.nextLine());
		
		for (int i = 1; i <= exponente; i++) {
			resultado = resultado * base;
		}
			
		return resultado;
	}
	
	/**
	 * Metodo que solicita un numero y calcula su factorial
	 * @param Muestra el mensaje concreto de cada operacion
	 * @return resultado
	 */
	private static double operacionFactorial(String msg) {

		double resultado = 1;
		int numero;
		
		System.out.println(msg);
		numero = Integer.parseInt(teclado.nextLine());
		
		if (numero < VALOR_MINIMO) {
			System.out.println(MENSAJE_ERROR);
			resultado = -1;
		}
		else {
			for (int i = 1; i <= numero; i++) {
				resultado = resultado * i;
			}	
		}
		
		return resultado;
	}

}
