package relacion04;

import java.util.Scanner;

public class Ejercicio04compruebaDiasDeUnMes {
	
	private static final int MES_MINIMO = 1;
	private static final int MES_MAXIMO = 12;
	private static final int ANIO_MINIMO = 1582;
	private static final int ANIO_MAXIMO = 3882;
	private static final char AFIRMATIVO = 'S';
	

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		char respuesta;
		//boolean mesCorrecto;
		boolean esBisiesto;
		int anio, mes;
		
		do {
			
			//do {
				System.out.println("Introduce un mes (1-12)");
				mes = Ejercicio01numeroEnRango.solicitarNumeroEnRango(MES_MINIMO, MES_MAXIMO);
				System.out.println("Introduce un anio");
				anio = Ejercicio01numeroEnRango.solicitarNumeroEnRango(ANIO_MINIMO,ANIO_MAXIMO);
				//mesCorrecto = comprobarMes(mes);
				esBisiesto = Ejercicio03compruebaBisiestoB.comprobarAnio(anio);
			//} while ((!mesCorrecto));
			
			calcularDiasDeUnMes(mes, anio, esBisiesto);
			respuesta = solicitarOtraFecha();	
		} while (respuesta == AFIRMATIVO);
			
		
		System.out.println("Adios");
	}

	private static void calcularDiasDeUnMes(int mes, int anio, boolean esBisiesto) {

		if (mes == 2 && esBisiesto) {
			System.out.println("El mes " + mes + " del anio " + anio + " tiene 29 días");
		}
		else {
			if (mes == 2) {
				System.out.println("El mes " + mes + " del anio " + anio + " tiene 28 días");
			}
			else {
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
					System.out.println("El mes " + mes + " del anio " + anio + " tiene 30 días");
				}
				else {
					System.out.println("El mes " + mes + " del anio " + anio + " tiene 31 días");
				}
			}
		}
		
	}

	@SuppressWarnings("unused")
	private static boolean comprobarMes(int mes) {
		
		boolean mesCorrecto = true;
		
		if (mes < MES_MINIMO || mes > MES_MAXIMO) {
			mesCorrecto = false;
		}

		return mesCorrecto;
	}
	
	@SuppressWarnings("unused")
	private static int solicitarAnio() {
		
		int anio;
		
		System.out.println("Introduce un anio");
		anio = Integer.parseInt(teclado.nextLine());
		
		return anio;
	}

	private static char solicitarOtraFecha() {
		
		char respuesta;
		
		System.out.println("Quiere introducir mas años?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

	@SuppressWarnings("unused")
	private static int solicitarMes() {

		int mes;

		System.out.println("Introduce un mes (1-12)");
		mes = Integer.parseInt(teclado.nextLine());

		return mes;
	}

}