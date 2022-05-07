package relacion01;
import java.util.Scanner;

public class Ejercicio10pasteleria {

	private final static char TARTA_CHOCOLATE_BLANCO = 'B';
	private final static char TARTA_CHOCOLATE_NEGRO = 'N';
	private final static char TARTA_CHOCOLATE = 'C';
	private final static char TARTA_FRESA = 'F';
	private final static char TARTA_MANZANA = 'M';
	private final static char RESPUESTA_AFIRMATIVA = 'S';
	private final static int PRECIO_TARTA_CHOCOLATE_BLANCO = 15;
	private final static int PRECIO_TARTA_CHOCOLATE_NEGRO = 14;
	private final static int PRECIO_TARTA_CHOCOLATE_FRESA = 16;
	private final static int PRECIO_TARTA_CHOCOLATE_MANZANA = 12;
	private final static double ANADIR_NATA = 2.5;
	private final static double PERSONALIZAR_NOMBRE = 2.75;

	public final static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char tipoTarta, tipoChocolate, respuesta;
		double presupuesto = 0;
		boolean afirmativo = true;

		System.out.println("¿De qué tipo quiere la tarta\r\n" + "(M- Manzana, F-Fresa o C-Chocolate)?");
		tipoTarta = teclado.nextLine().charAt(0);
		tipoTarta = Character.toUpperCase(tipoTarta);

		switch (tipoTarta) {

		case TARTA_CHOCOLATE:
			System.out.println("¿Chocolate negro o blanco?");
			tipoChocolate = teclado.nextLine().charAt(0);
			tipoChocolate = Character.toUpperCase(tipoChocolate);

			switch (tipoChocolate) {

			case TARTA_CHOCOLATE_BLANCO:
				presupuesto = PRECIO_TARTA_CHOCOLATE_BLANCO;
				break;
			case TARTA_CHOCOLATE_NEGRO:
				presupuesto = PRECIO_TARTA_CHOCOLATE_NEGRO;
				break;
			default:
				System.out.println("El tipo de chocolate introducido es incorrecto");
				afirmativo = false;
			}
			break;

		case TARTA_FRESA:
			presupuesto = PRECIO_TARTA_CHOCOLATE_FRESA;
			break;

		case TARTA_MANZANA:
			presupuesto = PRECIO_TARTA_CHOCOLATE_MANZANA;
			break;

		default:
			System.out.println("El tipo de tarta introducido es incorrecto");
			afirmativo = false;
		}

		if (afirmativo) {
			System.out.println("¿Desea añadir nata(S/N)?");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);

			if (respuesta == RESPUESTA_AFIRMATIVA) {
				presupuesto = presupuesto + ANADIR_NATA;
			}

			System.out.println("¿Desea personalizar nombre(S/N)?");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);

			if (respuesta == RESPUESTA_AFIRMATIVA) {
				presupuesto = presupuesto + PERSONALIZAR_NOMBRE;
			}

			System.out.println("El precion final de la tarta sería de " + presupuesto + "€");
		}

	}

}
