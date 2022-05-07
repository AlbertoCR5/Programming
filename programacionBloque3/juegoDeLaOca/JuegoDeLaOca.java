package juegoDeLaOca;

/**
* @author Alberto Castro
*/

import java.util.Random;
import java.util.Scanner;

public class JuegoDeLaOca {
	
	//Constantes
	//Asignamos 0 como un valor constante para dejar el codigo mas claro
	private static final int VALOR_MINIMO = 0;
	//Minimo de jugadores permitidos
	private final static int MINIMO_JUGADORES = 2;
	//Maximo de jugadores permitidos
	private final static int MAXIMO_JUGADORES = 4;
	//Posicion inicial de los jugadores
	private final static int CASILLA_SALIDA = 1;
	//Posicion OCA y sus multiplos
	private final static int CASILLA_OCA = 4;
	//Posicion del POZO, si caes en esta posicion, no lanzas dado un turno
	private final static int CASILLA_POZO = 37;
	//Posicion CALAVERA, si caes en esta posicion, vuelves a la posicion inicial
	private final static int CASILLA_CALAVERA = 61;
	//El primiero que llegue a esta posicion, gana
	private final static int CASILLA_FINAL = 63;
	//La puntuacion maxima que dara el dado al ser lanzado
	private final static int NUMEROS_DADO = 6;
	//Colores disponibles
	private final static String COLOR_1 = "AMARILLO";
	private final static String COLOR_2 = "AZUL";
	private final static String COLOR_3 = "ROJO";
	private final static String COLOR_4 = "VERDE";

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Array de tipo String con los colores disponibles para elegir
		String colores[] = { COLOR_1, COLOR_2, COLOR_3, COLOR_4 };
		
		//Se solicita la cantidad de jugadores que participaran en el juego
		int numeroJugadores = solicitarNumeroJugadores();
		
		//Array de tipo entero que controlara las posiciones de los jugadores
		int[] posicion = new int[numeroJugadores];
		
		//Array de tipo String que controla el color de los jugadores
		String jugadores[] = new String[numeroJugadores];
				
		//Se solicita el color a cada jugador y se le asigna la posicion CASILLA de SALIDA
		solicitarColorJugador(jugadores, colores, posicion);
		
		//Aleatoriamente establecera un orden de salida, indicado por color elegido
		asignarOrdenDeSalida(jugadores, colores);
		
		//Aqui comienza el juego
		jugar(jugadores, posicion);

	}

	/**
	 * Metodo que solicita el numero de jugadores (2-4),
	 * Si no es correcto, se volvera a solicitar
	 * 
	 * @return numerojugadores
	 */
	public static int solicitarNumeroJugadores() {

		int numeroJugadores;
		
		do {
			System.out.print("Introduce el numero de jugadores (" + MINIMO_JUGADORES + "-" + MAXIMO_JUGADORES +"): ");
			numeroJugadores = Integer.parseInt(teclado.nextLine());
		} while (numeroJugadores < MINIMO_JUGADORES || numeroJugadores > MAXIMO_JUGADORES);

		return numeroJugadores;
	}

	/**
	 * Metodo que solicita un color, y este sera asignado al jugador que lo ha
	 * elegido. Si el color introducido no es correcto o ya esta seleccionado,
	 * se volvera a solicitar el color. Si el color introducido es correcto, al jugador
	 * le asignamos el color elegido y la posicion de inicio, que sera La casilla 1.
	 * 
	 * @param jugadores
	 * @param colores
	 * @param posicion
	 */
	public static void solicitarColorJugador(String[] jugadores, String[] colores, int[] posicion) {

		String color;
		boolean esColorValido = false;
		int cantidadColores = colores.length;

		for (int i = 0; i < jugadores.length; i++) {
			System.out.println("Estos son los colores disponibles: ");
			mostrarColores(colores);

			do {
				System.out.print("Selecciona color para jugador " + (i + 1) + ": ");
				color = teclado.nextLine().toUpperCase();
				esColorValido = comporbarColor(color, colores, cantidadColores, i);
			} while (esColorValido == false);

			jugadores[i] = color;
			posicion[i] = CASILLA_SALIDA;
			cantidadColores--;
			System.out.println("Jugador " + (i + 1) + " sera color " + jugadores[i]);
			System.out.println();

		}

	}

	/**
	 * Metodo que muestra los colores, si un color ya ha sido seleccionado, no se
	 * mostrara
	 * 
	 * @param colores
	 */
	private static void mostrarColores(String[] colores) {

		for (int j = 0; j < colores.length; j++) {
			if (colores[j] != null) {
				System.out.print(colores[j] + " ");
			}
		}
		System.out.println();

	}

	/**
	 * Metodo que comprueba que el color introducido sea correcto, Si es correcto se
	 * le asignara al jugador que lo ha seleccionado, y el color seleccionado dejara
	 * de estar disponible para eleccion.
	 * 
	 * @param color
	 * @param colores
	 * @param cantidadColores
	 * @param i
	 * @return esColorValido TRUE o FALSE
	 */
	private static boolean comporbarColor(String color, String[] colores, int cantidadColores, int i) {

		boolean esColorValido = false;

		for (int j = 0; j < cantidadColores && esColorValido == false; j++) {
			if (colores[j] != null) {
				if (colores[j].equalsIgnoreCase(color)) {
					esColorValido = true;
					colores[j] = colores[colores.length - 1 - i];
					colores[colores.length - 1 - i] = null;
				}
			}

		}

		return esColorValido;
	}

	/**
	 * Metodo que al pulsar una tecla, seleccionara aleatoriamente el orden de
	 * salida de los jugadores segun color elegido.
	 * 
	 * @param jugadores
	 * @param colores
	 */
	public static void asignarOrdenDeSalida(String[] jugadores, String[] colores) {

		Random ordenAleatorio = new Random();
		int ordenSalida[] = new int[jugadores.length];
		boolean esNumeroRepetido = false;
		for (int i = 0; i < jugadores.length; i++) {
			colores[i] = jugadores[i];
		}

		System.out.print("Pulse cualquier tecla para iniciar el sorteo: ");
		teclado.nextLine();
		System.out.println("El orden de tirada sera: ");
		for (int i = 0; i < jugadores.length; i++) {
			do {
				ordenSalida[i] = ordenAleatorio.nextInt(jugadores.length);
				if (i != VALOR_MINIMO) {
					esNumeroRepetido = comprobarNumero(ordenSalida, i);
				}

			} while (esNumeroRepetido);

			jugadores[i] = colores[ordenSalida[i]];

			System.out.println((i + 1) + "� " + jugadores[i] + " ");
		}
		
		System.out.println();
	}

	/**
	 * Metodo que comprueba que los numeros generados no se hayan repetido, de esta
	 * manera evitara errores o que se repita el color de alguno de los jugadores
	 * 
	 * @param ordenSalida
	 * @param i
	 * @return esNumeroRepetido TRUE o FALSE
	 */
	private static boolean comprobarNumero(int[] ordenSalida, int i) {

		boolean esNumeroRepetido = false;

		for (int j = 0; j < i && esNumeroRepetido == false; j++) {

			if (ordenSalida[i] == ordenSalida[j]) {
				esNumeroRepetido = true;
			}
		}

		return esNumeroRepetido;
	}

	/**
	 * Metodo que administra los turnos de cada tirador, si este debe lanzar dado,
	 * si debe ser penalizado, o si algun jugador ha llegado a la casilla final.
	 * 
	 * @param jugadores
	 * @param posicion
	 */
	private static void jugar(String[] jugadores, int[] posicion) {

		boolean esGanador = false;
		boolean esCastigado;
		int turnoSinTirar = 0;

		System.out.println("Comienza el juego!");
		System.out.println();
		do {
			for (int i = 0; i < jugadores.length && esGanador == false; i++) {
				esCastigado = comprobarCasillaPozo(posicion, jugadores, i, turnoSinTirar);

				if (!esCastigado) {
					posicion[i] = tirarDado(jugadores, posicion, i);
					esGanador = comprobarCasilla(posicion, jugadores, i);
					if (esGanador) {
						mostrarGanador(jugadores, i);
					}
				} 
				else {
					if (esCastigado && turnoSinTirar > VALOR_MINIMO) {
						turnoSinTirar = 0;
					}
					else {
						turnoSinTirar++;
					}
				}
			}
		} while (!esGanador);
		
		

	}

	/**
	 * Metodo que comprueba que el jugador no este situado en la casilla pozo, y si
	 * lo esta, que se quede un turno sin poder lanzar el dado
	 * 
	 * @param posicion
	 * @param jugadores
	 * @param i
	 * @param turnoSinTirar
	 * @return esCastigado, TRUE o FALSE
	 */
	private static boolean comprobarCasillaPozo(int[] posicion, String[] jugadores, int i, int turnoSinTirar) {

		boolean esCastigado = false;

		if (posicion[i] == CASILLA_POZO && turnoSinTirar == VALOR_MINIMO) {
			System.out.println("Casilla del POZO, " + jugadores[i] + " No lanzas dado este turno...");
			System.out.println();
			esCastigado = true;
		}

		return esCastigado;
	}

	/**
	 * Metodo que comprueba la casilla donde se encuentra el jugador, si conlleva
	 * penalizacion, si salta a otra casilla, o si no ocurre nada.
	 * 
	 * @param posicion
	 * @param jugadores
	 * @param i
	 * @return es ganador, TRUE o FALSE
	 */
	private static boolean comprobarCasilla(int[] posicion, String[] jugadores, int i) {

		boolean esGanador = false;

		if (posicion[i] % CASILLA_OCA == 0 && posicion[i] < CASILLA_FINAL) {
			System.out.println("De OCA a OCA y tira porque te tOCA");
			System.out.print("De nuevo, ");
			posicion[i] = tirarDado(jugadores, posicion, i);
			comprobarCasilla(posicion, jugadores, i);
		}

		if (posicion[i] == CASILLA_CALAVERA) {
			System.out.println("Casilla Calavera, " + jugadores[i] + " retornas a la posicion de salida");
			System.out.println();
			posicion[i] = CASILLA_SALIDA;
		}

		if (posicion[i] == CASILLA_FINAL) {
			esGanador = true;
		}
		
		return esGanador;
	}

	/**
	 * Metodo que mostrara el color del jugador al que le toca lanzar, al pulsar
	 * cualquier tecla se generara un numero aleatorio (1-6), que sera las
	 * posiciones que avanzara por la tabla.
	 * 
	 * @param jugadores
	 * @param posicion
	 * @param i
	 * @return posicion del jugador que lanza el dado
	 */
	private static int tirarDado(String[] jugadores, int[] posicion, int i) {

		Random numerosDado = new Random();
		int lanzaDado = 0;

		System.out.println("Turno para el jugador " + jugadores[i]);
		System.out.print("Pulse cualquier tecla para lanzar el dado:");
		teclado.nextLine();
		lanzaDado = numerosDado.nextInt(NUMEROS_DADO) + 1;
		System.out.println("Puntuacion Dado: " + lanzaDado);
		posicion[i] = posicion[i] + lanzaDado;
		
		if (posicion[i] > CASILLA_FINAL) {
			posicion[i] = CASILLA_FINAL;
		}

		System.out.println(jugadores[i] + " avanza hasta la posicion " + posicion[i]);
		System.out.println();
		
		return posicion[i];
	}

	/**
	 * Metodo que mostrara por pantalla el color del jugador ganador.
	 * 
	 * @param jugadores
	 * @param i
	 */
	private static void mostrarGanador(String[] jugadores, int i) {

		System.out.println("El ganador del Juego de la Oca es el jugador con el color " + jugadores[i]);
		System.out.println("ENHORABUENA!");

	}

}
