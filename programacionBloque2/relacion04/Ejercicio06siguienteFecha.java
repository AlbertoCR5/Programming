package relacion04;

import java.util.Scanner;

public class Ejercicio06siguienteFecha {

	private static final int DIA_MAXIMO = 31;
	private static final int DIA_MES_MINIMO = 1;
	private static final int MES_MAXIMO = 12;
	private static final int MES_CORTO = 30;
	private static final int ANIO_MINIMO = 1582;
	private static final int ANIO_MAXIMO = 3882;
	private static final char AFIRMATIVO = 'S';

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char respuesta;
		boolean esBisiesto;
		int dia, mes, anio;

		do {

			System.out.println("Introduce un dia");
			dia = Ejercicio01numeroEnRango.solicitarNumeroEnRango(DIA_MES_MINIMO, DIA_MAXIMO);
			System.out.println("Introduce un mes");
			mes = Ejercicio01numeroEnRango.solicitarNumeroEnRango(DIA_MES_MINIMO, MES_MAXIMO);
			System.out.println("Introduce un anio");
			anio = Ejercicio01numeroEnRango.solicitarNumeroEnRango(ANIO_MINIMO, ANIO_MAXIMO);
			esBisiesto = Ejercicio03compruebaBisiestoB.comprobarAnio(anio);
			calcularSiguienteFecha(dia, mes, anio, esBisiesto);
			respuesta = solicitarOtraFecha();
		} while (respuesta == AFIRMATIVO);

		System.out.println("Adios");
	}

	private static void calcularSiguienteFecha(int dia, int mes, int anio, boolean esBisiesto) {
		
		System.out.println("La fecha de hoy es " + dia + "-" + mes + "-" + anio);

		if (mes == 2 && esBisiesto && dia == 29 || !esBisiesto && dia == 28){
			 
				dia = DIA_MES_MINIMO;
				mes = mes + DIA_MES_MINIMO;
			
		}
		else {
			if (dia == DIA_MAXIMO && mes == MES_MAXIMO) {
				dia = DIA_MES_MINIMO;
				mes = DIA_MES_MINIMO;
				anio = anio + DIA_MES_MINIMO;
			}
			else {
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11 && dia == MES_CORTO) {
					dia = DIA_MES_MINIMO;
					mes = mes + DIA_MES_MINIMO;
				}
				else {
					if (dia == DIA_MAXIMO) {
						dia = DIA_MES_MINIMO;
						mes = mes + DIA_MES_MINIMO;
					}
					else {
						dia = dia + DIA_MES_MINIMO;
					}
					
				}
				
				
			}
		}
		
		
		System.out.println("La fecha de mañana sera " + dia + "-" + mes + "-" + anio);

	}

	private static char solicitarOtraFecha() {

		char respuesta;

		System.out.println("Quiere introducir otra hora?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

}