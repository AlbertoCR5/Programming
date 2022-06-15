package practicasExamenes;

import java.util.Scanner;

public class RecuperacionB1Ejercicio04 {
	
	private static final double EXTRA_QUESO = 1.5;
	private static final double PIZZA_BARATA = 8;
	private static final double PIZZA_MEDIA = 11.5;
	private static final double PIZZA_CARA = 16;
	private static final int VALOR_MINIMO = 0;
	private static final int TIPO_PIZZAS = 15;
	private static final int RANGO_PIZZA_MEDIA = 10;
	private static final int RANGO_PIZZA_BARATA = 5;
	private static final double VALE_DESCUENTO = 0.1;
	private static final char AFRIMATIVO = 'S';
	private static final char NEGATIVO = 'N';
	private static final String NOMBRE_PIZZERIA = "Monroy Delicious";
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int tipoPizza;
		double precioTotal = 0;
		char respuesta;

		System.out.println("Bienvenido a la Pizzería '" + NOMBRE_PIZZERIA + "'");
		
		do {
			do {
				System.out.print("¿Qué pizza desea (1-15) ? ");
				tipoPizza = Integer.parseInt(teclado.nextLine());
			} while (tipoPizza > TIPO_PIZZAS || tipoPizza <= VALOR_MINIMO);
			
			if (tipoPizza <= RANGO_PIZZA_BARATA) {
				precioTotal = precioTotal + PIZZA_BARATA;
			}
			else {
				if (tipoPizza <= RANGO_PIZZA_MEDIA) {
					precioTotal = precioTotal + PIZZA_MEDIA;
				}
				else {
					precioTotal = precioTotal + PIZZA_CARA;
				}
			}

			do {
				System.out.print("¿Desea extra de queso(S/N))? ");
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
			} while (respuesta != AFRIMATIVO && respuesta != NEGATIVO);
			
			if (respuesta == AFRIMATIVO) {
				precioTotal = precioTotal + EXTRA_QUESO;
			}
			
			do {
				System.out.print("¿Desea otra pizza más (S/N)? ");
				respuesta = teclado.nextLine().toUpperCase().charAt(0);
			} while (respuesta != AFRIMATIVO && respuesta != NEGATIVO);
			
		} while (respuesta == AFRIMATIVO);
		
		do {
			System.out.print("¿Tiene vale descuento (S/N)? ");
			respuesta = teclado.nextLine().toUpperCase().charAt(0);
		} while (respuesta != AFRIMATIVO && respuesta != NEGATIVO);
		
		if (respuesta == AFRIMATIVO) {
			precioTotal = precioTotal - precioTotal * VALE_DESCUENTO;
		}
		
		System.out.println("El total de su pedido es " + precioTotal + " euros");
		
	}
	
}