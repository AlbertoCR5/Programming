package Construccion;

import java.util.Scanner;

/**
 * @author Jorge "y0rg" Tarancón
 * 
 * Clase principal donde se ejecutará el programa
 * Recoge los datos de la casa por teclado y devuelve un veredicto
 *
 */
public class Principal {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {

		

		System.out.println("Cual es su nombre");
		String nombre = sc.nextLine();
		
		char respuesta;
		
		try {
			boolean garaje = false;
			boolean piscina = false;
			System.out.println("metros de la casa");
			int metrosCuadrados = Integer.parseInt(sc.nextLine());
			System.out.println("calidad de la casa");
			String calidades = sc.nextLine();
			System.out.println("Cuantas Plantas");
			int plantas = Integer.parseInt(sc.nextLine());
			System.out.println("Cuantas habitaciones");
			int habitaciones = Integer.parseInt(sc.nextLine());
			System.out.println("Cuantos Baños");
			int banios = Integer.parseInt(sc.nextLine());
			
			do {
				System.out.println("Piscina");
				respuesta = sc.nextLine().toUpperCase().charAt(0);
			} while (respuesta != 'S' && respuesta != 'N');
			if (respuesta == 'S') {
				piscina = true;
			}
			
			do {
				System.out.println("Garage");
				respuesta = sc.nextLine().toUpperCase().charAt(0);
			} while (respuesta != 'S' && respuesta != 'N');
			if (respuesta == 'S') {
				garaje = true;
			}
			
			System.out.println("Cuanto se quiere gastar");
			float presupuesto = Float.parseFloat(sc.nextLine());
			
			Cliente cliente = new Cliente (nombre, new Casa(metrosCuadrados, plantas, habitaciones, banios, calidades, piscina, garaje), presupuesto);
			System.out.println(cliente.veredicto());
		} catch (CasaImposibleException e) {
			System.out.println(e.getMessage());
		}
		

	}
}

