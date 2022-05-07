package relacion04;
import java.util.Scanner;

public class Practica2 {
	
	//CONSTANTES
	private static final char BASTOS = 'B';
	private static final char COPAS = 'C';
	private static final char ESPADAS = 'E';
	private static final char OROS = 'O';
	private static final char TODOS = 'T';
	private static final char SOTA = 'S';
	private static final char CABALLO = 'C';
	private static final char REY = 'R';
	private static final int DIEZ = 8;
	private static final int ONCE = 9;
	private static final int DOCE = 10;

	private static final int CARTAS_POR_PALO = 10;

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		char palo;

		//Bucle que pedira un palo mientras este no sea introducido correctamente
		do {
			palo = pedirPalo();
		} while (palo != BASTOS && palo != COPAS && palo != ESPADAS && palo != OROS && palo != TODOS);

		gestionarPalo(palo);

	}

	/**
	 * Metodo que solicita un palo, en caso de que no sea valido, mostrara un mensaje
	 * @return palo
	 */
	private static char pedirPalo() {

		char palo;

		System.out.println("Baraja espanola, elija el palo que quiere imprimir: Bastos, Copas, Espadas, Oros o todas");
		palo = teclado.nextLine().charAt(0);

		if (palo != BASTOS && palo != COPAS && palo != ESPADAS && palo != OROS && palo != TODOS) {
			System.out.println("No ha introducido un valor valido");
		}

		return palo;
	}

	/**
	 * Metodo que gestiona el palo segun valor
	 * @param palo
	 */
	private static void gestionarPalo(char palo) {

		switch (palo) {

		case BASTOS:
			imprimePalo("-B");
			break;

		case COPAS:
			imprimePalo("-C");
			break;

		case ESPADAS:
			imprimePalo("-E");
			break;

		case OROS:
			imprimePalo("-O");
			break;
			
		default:
			imprimeBaraja();
			break;
		}
	}

	/**
	 * Metodo que  imprime por pantalla el numero de carta, y a continuacion el tipo de carta segun palo introducido
	 * @param msg
	 */
	private static void imprimePalo(String msg) {

		for (int i = 1; i <= CARTAS_POR_PALO; i++) {

			if (i == DIEZ) {
				System.out.print(SOTA + msg + ", ");
			} else {
				if (i == ONCE) {
					System.out.print(CABALLO + msg + ", ");
				} else {
					if (i == DOCE) {
						System.out.println(REY + msg);
					} else {
						System.out.print(i + msg + ", ");
					}
				}
			}

		}

	}
	
	/**
	 * Metodo que imprime todos los palos por pantalla
	 */
	private static void imprimeBaraja() {

		imprimePalo("-B");
		imprimePalo("-C");
		imprimePalo("-E");
		imprimePalo("-O");

	}

}
