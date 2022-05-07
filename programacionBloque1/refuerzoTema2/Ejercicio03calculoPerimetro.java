package refuerzoTema2;

import java.util.Scanner;

public class Ejercicio03calculoPerimetro {

	private static final int VALOR_MINIMO = 0;
	private static final int MINIMO_LADOS = 3;
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int cantidadLados;
		double lado, perimetro = 0;
		
		do {
			System.out.println("Introduce la candidad de lados que tiene la figura");
			cantidadLados = teclado.nextInt();
		} while (cantidadLados < MINIMO_LADOS);

		for (int i = 0; i < cantidadLados; i++) {
			
			do {
				System.out.println("Introduce la medida del lado " + i + "/" + cantidadLados + " de la figura");
				lado = teclado.nextDouble();
			} while (lado <= VALOR_MINIMO);
			
			perimetro = perimetro +  lado;
		}
		
		System.out.println("El perimetro de la figura es de " + perimetro);
	}

}
