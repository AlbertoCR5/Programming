package relacion01;
import java.util.Scanner;

public class Ejercicio07estadoCivil {

	private final static int EDAD_PERSONAS_MAYORES = 50;
	private final static int EDAD_PERSONAS_JOVENES = 36;
	private final static int EDAD_LIMITE = 99;
	private final static int EDAD_MINIMA = 0;
	private final static int RETENCION_MAXIMA = 12;
	private final static double RETENCION_ALTA = 11.3;
	private final static double RETENCION_MEDIA = 10.5;
	private final static double RETENCION_BAJA = 8.5;
	private final static char SOLTERO = 'S';
	private final static char CASADO = 'C';
	private final static char VIUDO = 'V';
	private final static char DIVORCIADO = 'D';

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int edad;
		char estadoCivil;

		System.out.println("Introduce tu edad");
		edad = teclado.nextInt();

		if (edad < EDAD_MINIMA || edad > EDAD_LIMITE) {
			System.out.println("la edad introducidad es incorrecta " + edad);
		} else {
			if (edad > EDAD_PERSONAS_MAYORES) {
				System.out.println("Te pertenece una retencion del " + RETENCION_BAJA + "%");
			} else {
				if (edad >= EDAD_PERSONAS_JOVENES) {
					System.out.println("Te pertenece una retencion del " + RETENCION_MEDIA + "%");
				} else {
					System.out.println("Introduce el estado civil (S-Soltero, C-Casado, V-Viudo, D-Divorciado)");
					estadoCivil = teclado.next().charAt(0); //Line Preguntar
					estadoCivil = Character.toUpperCase(estadoCivil);

					if (estadoCivil != SOLTERO && estadoCivil != CASADO && estadoCivil != VIUDO
							&& estadoCivil != DIVORCIADO) {
						System.out.println("El estado civil introducido es incorrecto " + estadoCivil);
					} else {
						if (estadoCivil != SOLTERO && estadoCivil != DIVORCIADO) {
							System.out.println("Te pertenece una retencion del " + RETENCION_ALTA + "%");
						} else {
							System.out.println("Te pertenece una retencion del " + RETENCION_MAXIMA + "%");
						}
					}

				}
			}
		}

	}

}
