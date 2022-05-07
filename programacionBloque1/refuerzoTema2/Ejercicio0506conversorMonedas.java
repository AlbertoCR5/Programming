package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio0506conversorMonedas {

	private static final double EUROS_DOLARES = 1.16;
	private static final double DOLARES_EUROS = 0.86;
	private static final double EUROS_LIBRAS = 0.90;
	private static final double LIBRAS_EUROS = 1.11;
	private static final double LIBRAS_DOLARES = 1.29;
	private static final double DOLARES_LIBRAS = 0.77;
	private static final int VALOR_MINIMO = 0;
	private static final int OPCIONES = 7;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		double dinero, cambio;
		int opcion;
		
		do {
			System.out.println("Introduzca una opcion");
			System.out.println("1. Cambio de euros a dólares\r\n"
					+ "2. Cambio de dólares a euros\r\n"
					+ "3. Cambio de euros a libras\r\n"
					+ "4. Cambio de libras a euros.\r\n"
					+ "5. Cambio de libras a dólares\r\n"
					+ "6. Cambio de dólares a libras\r\n"
					+ "7. Salir\r\n"
					+ "");
			opcion = teclado.nextInt();
			
			switch (opcion) {
			
			case 1:
				System.out.println("Introduce la cantidad de Euros a convertir en Dolares");
				dinero = teclado.nextDouble();
				cambio = dinero * EUROS_DOLARES;
				System.out.println("La conversión de Euros/Dolares de la cantidad introducida es: " + cambio + "$");
				break;
				
			case 2:
				System.out.println("Introduce la cantidad de Dolares a convertir en Euros");
				dinero = teclado.nextDouble();
				cambio = dinero * DOLARES_EUROS;
				System.out.println("La conversión de Dolares/Euros de la cantidad introducida es: " + dinero + "€");
				break;
				
			case 3:
				System.out.println("Introduce la cantidad de Euros a convertir en Libras");
				dinero = teclado.nextDouble();
				cambio = dinero * EUROS_LIBRAS;
				System.out.println("La conversión de Euros/Libras de la cantidad introducida es: " + cambio + "£");
				break;
				
			case 4:
				System.out.println("Introduce la cantidad de Libras a convertir en Euros");
				dinero = teclado.nextDouble();
				cambio = dinero * LIBRAS_EUROS;
				System.out.println("La conversión de Libras/Euros de la cantidad introducida es: " + cambio + "€");
				break;
			
			case 5:
				System.out.println("Introduce la cantidad de Libras a convertir en Dolares");
				dinero = teclado.nextDouble();
				cambio = dinero * LIBRAS_DOLARES;
				System.out.println("La conversión de Libras/Dolares de la cantidad introducida es: " + cambio + "$");
				break;
				
			case 6:
				System.out.println("Introduce la cantidad de Dolores a convertir en Libra");
				dinero = teclado.nextDouble();
				cambio = dinero * DOLARES_LIBRAS;
				System.out.println("La conversión de Dolares/Libras de la cantidad introducida es: " + cambio + "£");
				break;
			
			default : 
				System.out.println("Adios");
			}
			
		} while (opcion <= VALOR_MINIMO || opcion > OPCIONES);
	}

}
