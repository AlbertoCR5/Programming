package Ejercicio03MaquinaCafe;

import java.util.Scanner;

public class MainMaquinaCafeException {

	static final int OPCIONES = 5;

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		double monederoInicial;
		MaquinaCafeException maquinaCafe;

		try {
			
			monederoInicial = solicitarMonederoInicial();
			maquinaCafe = new MaquinaCafeException(monederoInicial);
			
			do {
				opcion = mostrarMenu();
				ejecutarMenu(opcion, maquinaCafe);
			} while (opcion != 5);
			
		}catch (ExceptionMaquinaCafe e) {
			System.out.println(e.getMessage());	
		}
		
		
	}

	private static void ejecutarMenu(int opcion, MaquinaCafeException maquinaCafe) {
		
		double importeIntroducido, cambio;
		
		try {
			

			switch (opcion) {
			
			case 1:
				mostrarMensaje("Introduce Importe: " + MaquinaCafe.PRECIO_CAFE);
				importeIntroducido = Double.parseDouble(teclado.nextLine());
				cambio = maquinaCafe.sevirCafe(importeIntroducido);
				if (cambio > MaquinaCafeException.VALOR_MINIMO) {
					mostrarMensaje("Recoja su cambio " + cambio + ",  Gracias");
				}
				break;
				
			case 2:
				mostrarMensaje("Introduce Importe: " + MaquinaCafe.PRECIO_LECHE);
				importeIntroducido = Double.parseDouble(teclado.nextLine());
				cambio = maquinaCafe.sevirLeche(importeIntroducido);
				if (cambio > MaquinaCafeException.VALOR_MINIMO) {
					mostrarMensaje("Recoja su cambio " + cambio + ",  Gracias");
				}
				break;
				
			case 3:
				mostrarMensaje("Introduce Importe: " + MaquinaCafe.PRECIO_CAFE_LECHE);
				importeIntroducido = Double.parseDouble(teclado.nextLine());
				cambio = maquinaCafe.sevirCafeConLeche(importeIntroducido);
				if (cambio > MaquinaCafeException.VALOR_MINIMO) {
					mostrarMensaje("Recoja su cambio " + cambio + ",  Gracias");
				}
				break;
		
			case 4:
				mostrarMensaje(maquinaCafe.toString());
				break;
		
			default:
				mostrarMensaje("Adios");
				break;
			}
		}catch (ExceptionMaquinaCafe e) {
			System.out.println(e.getMessage());	
		}
		
		
	}

	private static void mostrarMensaje(String string) {
		
		System.out.println(string);
		
	}

	private static int mostrarMenu() {
		
		int opcion;
		
		do {
			mostrarMensaje("1. Servir café solo (1 euro)\n"
					+ "2. Servir leche (0,8 euros)\n"
					+ "3. Servir café con leche (1,5 euros)\n"
					+ "4. Consultar estado máquina. Aparecen los datos de los depósitos y del monedero\n"
					+ "5. Apagar máquina y salir");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion <= MaquinaCafe.VALOR_MINIMO || opcion > OPCIONES);
		
		return opcion;
	}

	private static double solicitarMonederoInicial() {
		
		double monederoInicial;
		
		do {
			mostrarMensaje("Introduce el monedero inicial de la maquina");
			monederoInicial = Double.parseDouble(teclado.nextLine());
		} while (monederoInicial <= MaquinaCafe.VALOR_MINIMO);
		
		return monederoInicial;
	}

}
