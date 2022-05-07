package Ejercicio06LaLiga;

import java.util.Scanner;

public class LaLiga {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean esFallido = false;
		Equipo equipo1 = new Equipo("Shalke La Pava", "fdsf", "Sevilla");
		Equipo equipo2 = new Equipo("Aston Pilas", "fasfas", "Pilas");
		Equipo equipo3 = new Equipo("Werder Brenes", "gsdgsdn", "Brenes");
		Equipo equipo4 = new Equipo("Olympic De Marchena", "gsdgsdg", "Marchena");
		Equipo equipo5 = new Equipo("Crystal Camas", "rqwrqwr", "Camas");
		Equipo equipo6 = new Equipo("Nottingham Miedo", "Sanchez Pizjuan", "Estepa");
		
		try {
			Partido partido1 = new Partido(1, equipo1, equipo2, "2-1");
		} catch (LaLigaException e) {
			System.out.println(e.getMessage());
		}

		do {
			try {
				Partido partido2 = new Partido(38, equipo3, equipo4, "3-3");
				Partido partido3 = new Partido(14, equipo5, equipo6, "0-1");
			} catch (LaLigaException e) {
				System.out.println(e.getMessage());
			}
		} while (esFallido);
	}

}
