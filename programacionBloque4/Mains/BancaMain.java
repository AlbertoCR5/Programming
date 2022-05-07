package Mains;

import java.util.Scanner;

import ejercicio01Banca.CuentaCredito;
import ejercicio01Banca.CuentaException;

public class BancaMain {

	private static final int OPCION_SALIR = 5;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		CuentaCredito cuentaCredito = crearCuentaCredito();
		System.out.println("Cuenta creada:" + cuentaCredito);

		do {
			opcion = elegirOpcion();

			tratarOpcion(cuentaCredito, opcion);
		} while (opcion != OPCION_SALIR);
	}

	private static CuentaCredito crearCuentaCredito() {

		CuentaCredito cuentaCredito = null;
		double saldo, credito;
		boolean hayError;
		String titular;

		do {
			hayError = false;
			try {
				titular=solicitarCadena("Titular: ");
				saldo = solicitarDouble("Saldo inicial de la cuenta: ");
				credito = solicitarDouble("Crédito de la cuenta");
				cuentaCredito = new CuentaCredito(titular,saldo, credito);
			} catch (CuentaException e) {
				System.out.println(e.getMessage());
				hayError = true;
			}
		} while (hayError);

		return cuentaCredito;

	}

	private static String solicitarCadena(String msg) {
		System.out.println(msg);
		
		return teclado.nextLine();
	}

	private static void tratarOpcion(CuentaCredito cuentaCredito, int opcion) {

		double dineroIngresar, dineroSacar, credito;
		try {

			switch (opcion) {
			case 1:

				System.out.println("Introduzca dinero a ingresar");
				dineroIngresar = Integer.parseInt(teclado.nextLine());
				cuentaCredito.realizarIngreso(dineroIngresar);

				break;

			case 2:

				System.out.println("Introduzca dinero a sacar");
				dineroSacar = Integer.parseInt(teclado.nextLine());
				cuentaCredito.realizarReintegro(dineroSacar);

				break;
			case 3:
				System.out.println(cuentaCredito);
				break;
			case 4:

				System.out.println("Introduzca nuevo credito:");
				credito = Integer.parseInt(teclado.nextLine());
				cuentaCredito.setCredito(credito);

				break;

			}

		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}

	}

	private static int elegirOpcion() {
		int elegida;
		do {
			try {
				System.out.println();
				System.out.println("MENU CUENTA DE CRÉDITO");
				System.out.println("1.Ingresar Dinero");
				System.out.println("2.Sacar dinero");
				System.out.println("3.Mostrar saldo y crÉdito");
				System.out.println("4.Modificar credito"); // esta no la pide, la añado para probar el setCredito
				System.out.println("5.Salir");
				System.out.println();
				System.out.println("Introduzca una opción");
				elegida = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException x) {
				elegida = 0;
			}
		} while (elegida < 1 || elegida > OPCION_SALIR);
		return elegida;
	}

	public static double solicitarDouble(String mensaje) {

		String cadena;
		double numero = 0;
		boolean error;

		do {
			try {
				error = false;
				System.out.println(mensaje);
				cadena = teclado.nextLine();
				numero = Double.parseDouble(cadena);
			} catch (NumberFormatException ex) {
				error = true;
				System.out.println("No es un numero");
			}
		} while (error);

		return numero;

	}

}
