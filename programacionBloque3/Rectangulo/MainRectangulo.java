package Rectangulo;

import java.util.Scanner;

public class MainRectangulo {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Rectangulo rectangulo = crearRectangulo();
		
		System.out.println(rectangulo);

	}

	private static Rectangulo crearRectangulo() {
		
		Rectangulo rectangulo = null;
		boolean esValido;
		double base, altura;
		
		do {
			
			try {
				esValido = true;
				 System.out.println("Introduce base");
				 base = Double.parseDouble(teclado.nextLine());
				 System.out.println("Introduce altura");
				 altura = Double.parseDouble(teclado.nextLine());
				 rectangulo = new Rectangulo(base, altura);
			} catch (RectanguloException e) {
				esValido = false;
				System.out.println(e.getMessage());
			}
		} while (!esValido);
	
		
		return rectangulo;
	}

}
