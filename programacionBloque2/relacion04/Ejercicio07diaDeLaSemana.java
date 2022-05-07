package relacion04;

import java.util.Scanner;

public class Ejercicio07diaDeLaSemana {

	private static final int DIA_MAXIMO = 31;
	private static final int DIA_MES_MINIMO = 1;
	private static final int MES_MAXIMO = 12;
	private static final int ANIO_MINIMO = 1582;
	private static final int ANIO_MAXIMO = 3882;
	private static final char AFIRMATIVO = 'S';
	private static final String LUNES = "LUNES";
	private static final String MARTES = "MARTES";
	private static final String MIERCOLES = "MIERCOLES";
	private static final String JUEVES = "JUEVES";
	private static final String VIERNES = "VIERNES";
	private static final String SABADO = "SABADO";
	private static final String DOMINGO = "DOMINGO";

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char respuesta;
		String diaDeLaSemana;
		int dia, mes, anio;

		do {
			dia = Ejercicio01numeroEnRangoB.solicitarNumeroEnRango("Introduce un dia ", DIA_MES_MINIMO, DIA_MAXIMO);
			mes = Ejercicio01numeroEnRangoB.solicitarNumeroEnRango("Introduce un mes ",DIA_MES_MINIMO, MES_MAXIMO);
			anio = Ejercicio01numeroEnRangoB.solicitarNumeroEnRango("Introduce un anio ",ANIO_MINIMO, ANIO_MAXIMO);
			diaDeLaSemana = comprobarDiaDeLaSemana(dia, mes, anio);
			System.out.println("El dia de la semana de la fecha introducida es el " + diaDeLaSemana);
			respuesta = solicitarOtraFecha();
		} while (respuesta == AFIRMATIVO);

		System.out.println("Adios");
		
	}

	/**
	 * Metodo que calcula el dia de la semana que es acorde a la fecha introducidad
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return dia de la semana (Lunes, Martes, Miercoles, etc.)
	 */
	private static String comprobarDiaDeLaSemana(int dia, int mes, int anio) {
		
		String diaDeLaSemana;
		
		int a = (14 - mes) / 12;
		int y = anio - a;
		int m = mes + 12 * a -2;
		int d = (dia + y + y / 4 - y / 100 + y / 400 + (31*m) / 12) % 7;	
		
		//Segun valor de la variable d, se le asignara un valor de tipo String a diaDeLaSemana
		switch (d) {
		
			case 1: 
				diaDeLaSemana = LUNES;
				break;
		
			case 2: 
				diaDeLaSemana = MARTES;
				break;
			
			case 3: 
				diaDeLaSemana = MIERCOLES;
				break;
		
			case 4: 
				diaDeLaSemana = JUEVES;
				break;
			
			case 5: 
				diaDeLaSemana = VIERNES;
				break;
		
			case 6: 
				diaDeLaSemana = SABADO;
				break;
		
			default:
				diaDeLaSemana = DOMINGO;
				break;
		
		}
		
		return diaDeLaSemana;

	}

	private static char solicitarOtraFecha() {

		char respuesta;

		System.out.println("Quiere introducir otra hora?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);

		return respuesta;
	}

}
