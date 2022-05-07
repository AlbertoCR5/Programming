package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio02DescuentoTienda {

	private static final int VALOR_MINIMO = 0;
	private static final int PRECIO_ZAPATO = 40;
	private static final int VENTA_PEQUENA = 10;
	private static final int VENTA_MEDIA = 20;
	private static final int VENTA_ALTA = 30;
	private static final double GASTO_ENVIO = 0.1;
	private static final double DESCUENTO_INFERIOR = 0.1;
	private static final double DESCUENTO_MEDIO = 0.2;
	private static final double DESCUENTO_SUPERIOR = 0.4;
	
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int zapatosVendidos;
		double coste;
		
		do {
			System.out.println("Introduce la cantidad de zapatos a comprar");
			zapatosVendidos = Integer.parseInt(teclado.nextLine());
		} while (zapatosVendidos <= VALOR_MINIMO );

		if (zapatosVendidos > VENTA_ALTA) {
			coste = ((double)zapatosVendidos * GASTO_ENVIO + zapatosVendidos * PRECIO_ZAPATO);
			coste = coste - coste * (double)DESCUENTO_SUPERIOR;
		}
		else {
			if (zapatosVendidos > VENTA_MEDIA) {
				coste = ((double)zapatosVendidos * GASTO_ENVIO + zapatosVendidos * PRECIO_ZAPATO);
				coste = coste - coste * (double)DESCUENTO_MEDIO;
			}
			else {
				if (zapatosVendidos > VENTA_PEQUENA) {
					coste = ((double)zapatosVendidos * GASTO_ENVIO + zapatosVendidos * PRECIO_ZAPATO);
					coste = coste - coste * (double)DESCUENTO_INFERIOR;
				}
				else {
					coste = ((double)zapatosVendidos * GASTO_ENVIO + zapatosVendidos * PRECIO_ZAPATO);
				}
			}
		}
		
		System.out.println("El coste del pedido realizado con los gastos de envio incluidos es de " + coste + "€");
	}

}
