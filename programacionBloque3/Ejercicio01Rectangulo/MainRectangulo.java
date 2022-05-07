package Ejercicio01Rectangulo;

import java.util.Scanner;

public class MainRectangulo {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		double altura, ancho;
		Rectangulo rectangulo;
		
		
		altura = solicitarMedida("Introduce la altura del rectanglo");
		ancho = solicitarMedida("Introduce el ancho del rectanglo");

		rectangulo = new Rectangulo(altura, ancho);
		
		System.out.println(rectangulo.toString());
	}

	private static double solicitarMedida(String string) {
		
		double medida;

		System.out.println(string);
		medida = Double.parseDouble(teclado.nextLine());
		
		return medida;
	}

}
