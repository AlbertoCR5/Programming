package refuerzoEstructurasControl;

import java.util.Scanner;

public class PonerComillas {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String sinComillas;
		
		do {
			System.out.println("Dale cana");
			sinComillas = teclado.nextLine();
			
			StringBuilder conComillas;

			conComillas = ponerComillas(sinComillas);
			
			System.out.println(conComillas.toString());
		} while (sinComillas.length() != 0);
		
		
	}

	private static StringBuilder ponerComillas(String sinComillas) {
		
		StringBuilder conComillas = new StringBuilder(sinComillas);	
		conComillas.insert(0, "'");
		conComillas.insert(conComillas.length(), "'");
		int posicionGuion = conComillas.indexOf(",");
		
		do {

			conComillas.insert(posicionGuion, "'");
			conComillas.insert(posicionGuion + 3, "'");
			posicionGuion = conComillas.indexOf(",", posicionGuion + 4);
		
		} while (posicionGuion != -1);

		return conComillas;
	}
}
