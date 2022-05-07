package Mains;

import java.util.Scanner;

import banco.CuentaCredito;
import banco.CuentaException;

public class MainBanca {

	private static final int OPCIONES = 5;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		
		CuentaCredito cuentaCredito = crearCuentaCredito();
		System.out.println("Cuenta creada: " + cuentaCredito);
		
		do {
			mostrarMenu();
			opcion = elegirOpcion();
			tratarOpcion(cuentaCredito, opcion);
		} while (opcion != OPCIONES);
		
		

	}

	private static CuentaCredito crearCuentaCredito() {
		
		CuentaCredito cuentaCredito = null;
		double saldo;
		int credito;
		boolean esValido;
		String titular;
		
		do {
			esValido = true;
			try {
				System.out.println("Introduce el nombre del titular de la cuenta");
				titular = teclado.nextLine();
				System.out.println("Introduce el saldo inicial de la cuenta");
				saldo = Double.parseDouble(teclado.nextLine());
				System.out.println("Introduce el credito disponible para esta cuenta");
				credito = Integer.parseInt(teclado.nextLine());
				cuentaCredito = new CuentaCredito(saldo, titular, credito);
			} catch (CuentaException e) {
				System.out.println(e.getMessage());
			}
			
		} while (!esValido);
		
		return cuentaCredito;
	}

	private static void mostrarMenu() {
		
		System.out.println();
		System.out.println("MENU CUENTA DE CRÉDITO");
		System.out.println("1.Ingresar Dinero");
		System.out.println("2.Sacar dinero");
		System.out.println("3.Mostrar saldo y crÉdito");
		System.out.println("4.Modificar credito"); // esta no la pide, la añado para probar el setCredito
		System.out.println("5.Salir");
		System.out.println();
		
	}
	
	private static int elegirOpcion() {
		
		int opcion;
		
		do {
			try {
				System.out.println("Introduzca una opción");
				opcion = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				opcion = -1;
			}
			
		} while (opcion < 1 || opcion > OPCIONES);
		
		return opcion;
	}
	
	private static void tratarOpcion(CuentaCredito cuentaCredito, int opcion) {
		
		double ingreso, reintegro;
		int credito;
		
		try {
			switch (opcion) {
			
			case 1:			
				System.out.println("Introduce cantidad a ingresar");
				ingreso = Double.parseDouble(teclado.nextLine());
				cuentaCredito.realizarIngreso(ingreso);
				break;
			
			case 2:			
				System.out.println("Introduce cantidad a retirar");
				reintegro = Double.parseDouble(teclado.nextLine());
				cuentaCredito.realizarReintegro(reintegro);
				break;
			
			case 3:			
				System.out.println(cuentaCredito);
				break;
			
			case 4:
				System.out.println("Introduzca nuevo credito:");
				credito = Integer.parseInt(teclado.nextLine());
				cuentaCredito.setCredito(credito);
				break;

			default:
				System.out.println("Adios");
				break;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
