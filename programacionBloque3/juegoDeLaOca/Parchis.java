package juegoDeLaOca;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Parchis {

	private static final int VALOR_MINIMO = 0;
	private final static int MINIMO_JUGADORES = 2;
	private final static int NUMERO_FICHAS = 4;
	private final static int MAXIMO_JUGADORES = 4;
	private final static int CASILLA_SALIDA = 1;
	private final static int CONTAR_COMER = 20;
	private final static int CONTAR_LLEGADA = 10;
	private final static int CASILLA_CALAVERA = 61;
	private final static int SACAR_FICHA = 5;
	private final static int SALIDA_AZUL = 22;
	private final static int SALIDA_ROJO = 39;
	private final static int SALIDA_VERDE = 56;
	private final static int CASILLA_CASA = 68;
	private final static int CASILLA_FINAL = 76;
	private final static int CASILLA_SEGURO_1= 5;
	private final static int CASILLA_SEGURO_2 = 12;
	private final static int CASILLA_SEGURO_3 = 17;
	private final static int NUMEROS_DADO = 6;
	private final static String COLOR_1 = "AMARILLO";
	private final static String COLOR_2 = "AZUL";
	private final static String COLOR_3 = "ROJO";
	private final static String COLOR_4 = "VERDE";

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		String colores[] = { COLOR_1, COLOR_2, COLOR_3, COLOR_4 };
		int [] fichas = new int [NUMERO_FICHAS];
		int numeroJugadores = JuegoDeLaOca.solicitarNumeroJugadores();
		int[] posicion = new int[numeroJugadores];
		String jugadores[] = new String[numeroJugadores];
		
		JuegoDeLaOca.solicitarColorJugador(jugadores, colores, posicion);
		asignarOrdenDeSalida(jugadores, colores);
		jugar(jugadores, posicion, fichas);
	}

	private static void asignarOrdenDeSalida(String[] jugadores, String[] colores) {

		Random numerosDado = new Random();
		int lanzaDado = 0, numeroMayor = Integer.MIN_VALUE, numeroMayorRepetido = -1;
		Integer puntuacionOrdenSalida[] = new Integer[jugadores.length];
		boolean esNumeroRepetido;
		
		do {
			esNumeroRepetido = false;
			for (int i = 0; i < jugadores.length; i++) {
				colores[i] = jugadores[i];
				System.out.println("El jugador que obtenga la posicion mas alta iniciará el juego");
				System.out.print(jugadores[i] + "Pulse cualquier tecla para lanzar el dado: ");
				teclado.nextLine();
				lanzaDado = numerosDado.nextInt(NUMEROS_DADO) + 1;
				System.out.println("Puntuacion Dado: " + lanzaDado);
				puntuacionOrdenSalida[i] = lanzaDado;
			
				if (puntuacionOrdenSalida[i] > numeroMayor) {
					numeroMayor = puntuacionOrdenSalida[i];
				}
				System.out.println(numeroMayor);
			}

			for (int i = 0; i < puntuacionOrdenSalida.length && esNumeroRepetido == false; i++) {
				if (numeroMayor == puntuacionOrdenSalida[i]) {
					numeroMayorRepetido++;
				}
				
				if (numeroMayorRepetido > VALOR_MINIMO) {
					esNumeroRepetido = true;
					System.out.println("Se repetira integramente el sorteo");
				}
			}
			
		} while (esNumeroRepetido);
		
		Arrays.sort(puntuacionOrdenSalida, Collections.reverseOrder());
		
		for (int numero:puntuacionOrdenSalida)
			  System.out.println(numero);
//		for (int j = 0; j < jugadores.length; j++) {
//			
//			
//			jugadores[j] = colores[puntuacionOrdenSalida[j]];
//			System.out.println(puntuacionOrdenSalida[j]);
//		}
		
		
		
	}

	private static void jugar(String[] jugadores, int[] posicion, int[] fichas) {
		// TODO Auto-generated method stub
		
	}

}