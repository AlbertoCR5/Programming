package Ejercicio02CuentaBancaria;

import java.util.Scanner;

public class MainCuenta {

	
	private static final char NEGATIVO = 'N';
	private static final char AFIRMATIVO = 'S';
	private static final int OPCIONES = 4;
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int saldo, opcion;
		Cuenta cuenta;
		
		saldo = solicitarImporte("Introduce el saldo inicial de la cuenta");
		cuenta = new Cuenta(saldo);
		
		if (saldo > Cuenta.VALOR_MINIMO) {			
			opcion = mostrarMenu("Que operacion desea realizar");
			realizarOpcionIndicada(opcion, cuenta);
		}
		
		

	}

	private static void realizarOpcionIndicada(int opcion, Cuenta cuenta) {
		
		int ingreso, reintegro;
		char respuesta;
		
		switch (opcion) {
		
		case 1: 
			reintegro = solicitarImporte("Introduce el importe a retirar en la cuenta");
			cuenta.reintegro(reintegro);
			opcion = mostrarMenu("Que operacion desea realizar");
			realizarOpcionIndicada(opcion, cuenta);
			break;
			
		case 2:
			ingreso = solicitarImporte("Introduce el importe a ingresar en la cuenta");
			cuenta.ingreso(ingreso);
			opcion = mostrarMenu("Que operacion desea realizar");
			realizarOpcionIndicada(opcion, cuenta);
			break;
			
		case 3:
			System.out.println(cuenta.toString());
			opcion = mostrarMenu("Que operacion desea realizar");
			realizarOpcionIndicada(opcion, cuenta);
			break;
		
		default:
			do {
				System.out.println("Realmente desea salir?");
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
			} while (respuesta != AFIRMATIVO && respuesta != NEGATIVO);
			
			if (respuesta == AFIRMATIVO) {
				System.out.println("Ciao Ciao Ciao Ciao");
			}
			else {
				opcion = mostrarMenu("Que operacion desea realizar");
				realizarOpcionIndicada(opcion, cuenta);
			}
		}
		
	}

	private static int mostrarMenu(String string) {

		int opcion;
		
		do {
			System.out.println(string);
			System.out.println("1. Hacer un reintegro");
			System.out.println("2. Hacer un ingreso");
			System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados");
			System.out.println("4. Finalizar las operaciones.");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion > OPCIONES || opcion < Cuenta.VALOR_MINIMO);
		
		return opcion;
	}

	private static int solicitarImporte(String string) {
		
		int importe;
		
		System.out.println(string);
		importe = Integer.parseInt(teclado.nextLine());
		
		return importe;
	}

}
