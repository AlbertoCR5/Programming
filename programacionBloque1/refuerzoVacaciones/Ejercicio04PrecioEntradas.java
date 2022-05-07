package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio04PrecioEntradas {

	private static final int VALOR_MINIMO = 0;
	private static final int PRECIO_NORMAL = 8;
	private static final int PRECIO_ESPECTADOR = 5;
	private static final int PRECIO_PAREJA = 11;
	private static final double DESCUENTO_TARJETA = 0.1;
	private static final char LUNES = 'L';
	private static final char MARTES = 'M';
	private static final char MIERCOLES = 'X';
	private static final char JUEVES = 'J';
	private static final char VIERNES = 'V';
	private static final char SABADO = 'S';
	private static final char DOMINGO = 'D';
	private static final char AFIRMATIVO = 'Y';
	private static final char NEGATIVO = 'N';
	
	

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int cantidadEntradas;
		char diaSemana, respuesta;
		double precio;
		
		do {
			System.out.println("Que dia de la semana es?");
			diaSemana = teclado.nextLine().toUpperCase().charAt(0);
		} while (diaSemana != LUNES && diaSemana != MARTES && diaSemana != MIERCOLES && diaSemana != JUEVES && diaSemana != VIERNES && diaSemana != SABADO && diaSemana != DOMINGO);
		
		do {
			System.out.println("Cuantas entradas desea?");
			cantidadEntradas = Integer.parseInt(teclado.nextLine());
		} while (cantidadEntradas <= VALOR_MINIMO);
		
		do {
			System.out.println("Dispone de la tarjeta CineCampa? Y/N");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta != AFIRMATIVO && respuesta != NEGATIVO);
		
		switch (diaSemana) {
		
		case MIERCOLES:
			precio = cantidadEntradas * PRECIO_ESPECTADOR;
			break;
			
		case JUEVES:
			if (cantidadEntradas % 2 == 0) {
				precio = cantidadEntradas * PRECIO_PAREJA / 2;
			}
			else {
				precio = cantidadEntradas / 2 * PRECIO_PAREJA + PRECIO_NORMAL;
			}
			break;
			
		default:
			precio = cantidadEntradas * PRECIO_NORMAL;
			break;
		}
		
		if (respuesta == AFIRMATIVO) {
			precio = precio - precio * DESCUENTO_TARJETA;
		}
		
		System.out.println("El precio total de las entradas es " + precio + "€");
	}

}
