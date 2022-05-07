package examenBloque4Ejercicio1;

import java.util.Arrays;

public class Principal {

	/**
	 * Cuenta la cantidad de arcos de los jugadores Guerrero
	 * 
	 * @param jugadores
	 * @return cantidadArcos
	 */
	private static int cantidadArcos(Jugador[] jugadores) {

		int cantidadArcos = 0;

		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] instanceof Guerrero) {
				if (((Guerrero) jugadores[i]).getArma() == TipoArma.ARCO) {
					cantidadArcos++;
				}
			}

		}

		return cantidadArcos;
	}

	/**
	 * Ordena el array jugadores por resistencia y muestra por pantalla los datos de
	 * los guerreros
	 * 
	 * @param jugadores
	 */
	private static void listadoGuerrerosOrdenado(Jugador[] jugadores) {
		
		int totalGuerreros=totalDeGuerreros(jugadores);
		Guerrero[] guerreros=new Guerrero[totalGuerreros];
		int cantidadGuerreros=0;
		
		for (int i = 0; i < jugadores.length; i++) {
			
			if ( jugadores[i] instanceof Guerrero) {
				guerreros[cantidadGuerreros]=(Guerrero) jugadores[i];
				cantidadGuerreros++;
			}
		}
		
		Arrays.sort(guerreros);
		
		for (int i = 0; i < jugadores.length; i++) {			
			System.out.println(guerreros[i]);		
		}

	}

	private static int totalDeGuerreros(Jugador[] jugadores) {
		int numeroDeGuerreros=0;
		for (int i = 0; i < jugadores.length; i++) {
			
			if ( jugadores[i] instanceof Guerrero) {
				numeroDeGuerreros++;
			}
		}
		return numeroDeGuerreros;
	}

}