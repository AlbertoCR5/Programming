package Relacion8Ejercicio02RepartoCartas;

import java.util.Random;
import java.util.Scanner;

public class MainCartas {

	private static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String baraja[] = new String[48];
		
		baraja = mostrarCartas();
		int numeroCartas = solicitarCartas();
		
		String jugador1[] = null, jugador2[] = null;
		
		jugador1 = repartirCartas(baraja, numeroCartas);
		jugador2 = repartirCartas(baraja, numeroCartas);
		
		baraja = mostrarCartas();
		
		System.out.println(jugador1);
		System.out.println(jugador2);
		System.out.println(baraja);
	}

	private static String[] repartirCartas(String[] baraja, int numeroCartas) {
		
		String jugador[] = new String[numeroCartas];
		
		
		for (int i = 0; i < baraja.length; i++) {
			int numeroAleatorio = solicitarNumeroAleatorio(baraja);
			jugador[i] = baraja[numeroAleatorio];
			baraja[numeroAleatorio] = null;
		}
		
		return jugador;
		
	}

	private static int solicitarNumeroAleatorio(String[] baraja) {

		Random aleatorio = new Random();
		boolean esRepartida = false;
		int numeroAleatorio;
		
		do {
			numeroAleatorio = aleatorio.nextInt(baraja.length);
			if (baraja[numeroAleatorio] == null){
				esRepartida = true;
			}
		} while (esRepartida);
		
		
		
		
		return numeroAleatorio;
	}

	private static int solicitarCartas() {
		
		System.out.println("Introduce cuantas cartas se van a repartir por cada jugador");
		int numeroCartas = Integer.parseInt(teclado.nextLine());
		
		return numeroCartas;
	}

	private static String[] mostrarCartas() {

		String baraja[] = new String[48];
		int contador = 0;
		
		for (int i = 1; i <= Carta.CARTAS_POR_PALO; i++) {
			
			for (int j = 0; j < Carta.PALOS.length; j++) {
				if(i < 10) {
					System.out.print(" " + i + " " + Carta.PALOS[j]+ "  ");
					baraja[contador] = " " + i + " " + Carta.PALOS[j]+ "  ";
					contador++;
				}
				else {
					System.out.print(i + " " + Carta.PALOS[j]+ "  ");
					baraja[contador] = (" " + i + " " + Carta.PALOS[j]+ "  ");
					contador++;
				}
				//System.out.println(baraja[contador]);
			}
			System.out.println();
		}
		return baraja;

		
	}

}
