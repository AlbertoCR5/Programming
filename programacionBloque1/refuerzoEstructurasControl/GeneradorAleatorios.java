package refuerzoEstructurasControl;

import java.util.Random;

public class GeneradorAleatorios {

	private static final int NUMERO_LIMITE= 100000;
	
	public static void main(String[] args) {
		
		int numeroLoteria;

		Random serieAleatoria = new Random();
		
		numeroLoteria = serieAleatoria.nextInt(NUMERO_LIMITE) + 1;
		System.out.println("El número premiado en la loteria de navidad del 22 de diciembre de 2021 sera el:");
		System.out.println();
		System.out.println(numeroLoteria);
		
	}

}
