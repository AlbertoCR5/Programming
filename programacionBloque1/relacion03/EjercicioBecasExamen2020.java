package relacion03;

import java.util.Scanner;

public class EjercicioBecasExamen2020 {

	private final static int DISTANCIA_CORTA = 3;
	private final static int DISTANCIA_MEDIA = 5;
	private final static int DISTANCIA_LARGA = 10;
	private final static int CUANTIA_MINIMA = 0;
	private final static int CUANTIA_PEQUENA = 60;
	private final static int CUANTIA_MEDIANA = 100;
	private final static int CUANTIA_GRANDE = 130;
	private final static double INCREMENTO = 0.08;
	private final static char AFIRMATIVO = 'S';
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int distancia;
		double beca;
		char respuesta;
		
		System.out.println("Introduzca la distancia en Km al centro de trabajo");
		distancia = Integer.parseInt(teclado.nextLine());
		
		System.out.println("¿Es familia numerosa (S/N)?");
		respuesta = teclado.nextLine().charAt(0);
		respuesta = Character.toUpperCase(respuesta);
		
		if (distancia < DISTANCIA_CORTA) {
			beca = CUANTIA_MINIMA;
		}
		else {
			if (distancia < DISTANCIA_MEDIA) {
				beca = CUANTIA_PEQUENA;
			}
			else {
				if (distancia < DISTANCIA_LARGA) {
					beca = CUANTIA_MEDIANA;
				}
				else {
					beca = CUANTIA_GRANDE;
				}
			}
		}
		
		if (respuesta == AFIRMATIVO) {
			beca = beca + (beca * INCREMENTO);
		}
		
		System.out.println("Le corresponde una beca de " + beca + " euros.");
	}

}
