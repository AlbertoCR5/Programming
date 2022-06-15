package practicasExamenes;

import java.util.Scanner;

public class RecuperacionJunio2022Ejercicio1 {

	private static final int VALOR_MINIMO = 0;
	private static final int INGREDIENTES_DESCUENTO = 3;
	private static final double MAXIMO_INGREDIENTES = 10;
	private static final double PRECIO_BASE_PEQUENA = 5;
	private static final double PRECIO_BASE_MEDIANA = 7.5;
	private static final double PRECIO_BASE_GRANDE = 10;
	private static final double INCREMENTO_DOMICILIO = 1.5;
	private static final double DESCUENTO = 0.1;
	private static final char AFIRMATIVO = 'S';
	private static final char NEGATIVO = 'N';
	private static final char TAMANO_PEQUENA = 'P';
	private static final char TAMANO_MEDIANA = 'M';
	private static final char TAMANO_GRANDE = 'G';
		
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		char tamanoPizza, aDomicilio;
		int cantidadIngredientes;
		double precioFinal;
		
		do {
			tamanoPizza = solicitarTamanoPizza("Introduce el tamano (P-Pequena, M-Mediana, G-Grande): ");
		} while (tamanoPizza != TAMANO_PEQUENA && tamanoPizza != TAMANO_MEDIANA && tamanoPizza != TAMANO_GRANDE);
		
		do {
			cantidadIngredientes = solicitarCantidadingredientes("Numero de ingredientes: ");
		} while (cantidadIngredientes <= VALOR_MINIMO || cantidadIngredientes > MAXIMO_INGREDIENTES);
		
		do {
			aDomicilio = solicitarRepartoDomicilio("Reparto a domicilio (S/N): ");
		} while (aDomicilio != AFIRMATIVO && aDomicilio != NEGATIVO);
		
		precioFinal = calcularPrecioPizza(tamanoPizza, cantidadIngredientes, aDomicilio);
		
		mostrarPrecioFinal("El precio de la pizza es " + precioFinal + " euros");

	}

	private static char solicitarTamanoPizza(String string) {
		
		char tamanoPizza;
		
		System.out.print(string);
		tamanoPizza = teclado.nextLine().toUpperCase().charAt(0);
		
		return tamanoPizza;
	}

	private static int solicitarCantidadingredientes(String string) {
		
		int cantidadIngredientes;
		
		System.out.print(string);
		cantidadIngredientes = Integer.parseInt(teclado.nextLine());
		
		return cantidadIngredientes;
	}

	private static char solicitarRepartoDomicilio(String string) {
		
		char aDomicilio;
		
		System.out.print(string);
		aDomicilio = teclado.nextLine().charAt(0);
		
		return aDomicilio;
	}

	private static double calcularPrecioPizza(char tamanoPizza, int cantidadIngredientes, char aDomicilio) {
		
		double precioFinal;
		
		if (tamanoPizza == TAMANO_PEQUENA) {
			precioFinal = PRECIO_BASE_PEQUENA;
		}
		else {
			if (tamanoPizza == TAMANO_MEDIANA) {
				precioFinal = PRECIO_BASE_MEDIANA;
			}
			else {
				precioFinal = PRECIO_BASE_GRANDE;
			}
		}
		
		if (aDomicilio == AFIRMATIVO) {
			precioFinal = precioFinal + INCREMENTO_DOMICILIO;
		}
		
		if (cantidadIngredientes >= INGREDIENTES_DESCUENTO) {
			precioFinal = precioFinal - precioFinal * DESCUENTO;
		}
		
		return precioFinal;
	}
	
	private static void mostrarPrecioFinal(String string) {
		
		System.out.print(string);
		
	}

}
