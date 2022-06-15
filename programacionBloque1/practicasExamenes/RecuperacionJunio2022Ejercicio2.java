package practicasExamenes;

import java.util.Random;
import java.util.Scanner;

public class RecuperacionJunio2022Ejercicio2 {

	private static final char FALLO = 'F';

	private static final int CANTIDAD_PREGUNTAS = 10;

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Random numeroAleatorio = new Random();
		char tipoPrueba;
		int numero1, numero2, resultado, aciertos = 0;
		boolean esErroneo = false;
		
		tipoPrueba = solicitarTipoPrueba("Prueba normal(N) o hasta fallo (F): ");
		
		for (int i = 1; i <= CANTIDAD_PREGUNTAS || (tipoPrueba == FALLO && esErroneo == false); i++) {
			System.out.println("Pregunta " + i + " de " + CANTIDAD_PREGUNTAS);
			numero1 = numeroAleatorio.nextInt(101);
			numero2 = numeroAleatorio.nextInt(101);
			System.out.println(numero1 + " + " + numero2 + " = ?");
			System.out.print("Introduce el resultado: ");
			resultado = Integer.parseInt(teclado.nextLine());
			
			if (resultado == numero1  + numero2) {
				System.out.println("Correcta");
				aciertos++;
			}
			else {
				System.out.println("Incorrecta");
				esErroneo = true;
			}
		}
		
		if (tipoPrueba == FALLO) {
			System.out.println("Has acertado " + aciertos + " preguntas de " + CANTIDAD_PREGUNTAS);
		}
		else {
			System.out.println("Nota final: " + aciertos + " de " + CANTIDAD_PREGUNTAS);
		}

	}

	private static char solicitarTipoPrueba(String string) {
		
		char tipoPrueba;
		
		System.out.println(string);
		tipoPrueba = teclado.nextLine().toUpperCase().charAt(0);
		
		return tipoPrueba;
	}

}
