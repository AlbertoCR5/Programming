package Cuenta;

import java.util.Scanner;

import EjemplosOrientacionObjetos.EjemploAtributoEstatico.CuentaException;

public class MainCuenta {

	static final int OPCIONES = 4;
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		Cuenta cuenta = crearCuenta();
		int opcion;
		
		do {
			opcion = mostrarMenu();
			tratarMenu(cuenta, opcion)	;		
		} while (opcion != 4);
			


	}
	
	private static int mostrarMenu() {

		int opcion;
		
		do {
			System.out.println("Que operacion desea realizar");
			System.out.println("1. Hacer un reintegro");
			System.out.println("2. Hacer un ingreso");
			System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados");
			System.out.println("4. Finalizar las operaciones.");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion > OPCIONES || opcion < Cuenta.VALOR_MINIMO);
		
		return opcion;
	}

	private static void tratarMenu(Cuenta cuenta, int opcion){

		double ingreso, reintegro;
		char respuesta;
		
		try {
			
		switch (opcion) {
		
		case 1: 
			reintegro = solicitarImporte("Introduce el importe a retirar en la cuenta");
			cuenta.realizarReintegro(reintegro);	
			break;
			
		case 2:
			ingreso = solicitarImporte("Introduce el importe a ingresar en la cuenta");
			cuenta.realizarIngreso(ingreso);	
			break;
			
		case 3:
			System.out.println(cuenta.toString());
			break;
		
		default:
			do {
				System.out.println("Realmente desea salir?");
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
			} while (respuesta != 'S' && respuesta != 'N');
			
			if (respuesta == 'S') {
				System.out.println("Ciao Ciao Ciao Ciao");
			}
			else {
				mostrarMenu();
			}
		}
		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}
		
	}
		
	private static double solicitarImporte(String string) {

		double importe;
		
		System.out.println(string);
		importe = Double.parseDouble(teclado.nextLine());
		
		return importe;
	}

	private static Cuenta crearCuenta() {

		Cuenta cuenta = null;
		boolean esValido;
		String nombreCuenta;
		double saldoInicial;
		
		do {
			try {
				esValido = true;
				System.out.println("Introduce el nombre de la cuenta");
				nombreCuenta = teclado.nextLine();
				System.out.println("Introduce el saldo inicial");
				saldoInicial = Double.parseDouble(teclado.nextLine());
				cuenta = new Cuenta(nombreCuenta, saldoInicial);
			} catch (CuentaException e) {
				esValido = false;
				System.out.println(e.getMessage());
			}
		} while (!esValido);
		
		return cuenta;
	}

}
