package MaquinaCafe;

import java.util.Scanner;

public class MainMaquina {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		MaquinaCafe maquina = iniciarMaquina();
		int opcion;	
		
		do {
			opcion = mostrarMenu();
			tratarMenu(opcion, maquina);
		} while (opcion != 5);

	}

	private static MaquinaCafe iniciarMaquina() {

		MaquinaCafe maquina = null;
		double monedero;
		boolean esValido;
		
		do {
			
			try {
				esValido = true;
				System.out.println("Introduce el monedero inicial de la maquina de cafe");
				monedero = Double.parseDouble(teclado.nextLine());
				maquina = new MaquinaCafe(monedero);
			} catch (MaquinaCafeException e) {
				esValido = false;
				System.out.println(e.getMessage());
			}
		} while (!esValido);
		
		return maquina;
	}
	
	private static int mostrarMenu() {
		
		int opcion;
		
		do {
		System.out.println("Bienvenido cliente");
		System.out.println("¿Que desea?");
		System.out.println("(1) Cafe " + MaquinaCafe.PRECIO_CAFE + "€");
		System.out.println("(2) Leche " + MaquinaCafe.PRECIO_LECHE + "€");
		System.out.println("(3) Cafe con leche " + MaquinaCafe.PRECIO_CAFELECHE + "€");
		System.out.println("(4) Consultar estado de la maquina");
		System.out.println("(5) Salir");
		opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion < 1 || opcion > 5);
		
		return opcion;
		
	}

	private static int tratarMenu(int opcion, MaquinaCafe maquina) {
		
		double importe;
		double cambio;
		
		try {
			switch (opcion) {
		
			case 1:
				importe = solicitarImporte("Introduce importe del cafe");
				cambio = maquina.servirCafe(importe);
				if (cambio > MaquinaCafe.VALOR_MINIMO) {
					System.out.println("Recoja su cambio, gracias " + cambio + "€");
				}
				else {
					System.out.println("Producto servido, Gracias");
				}
				break;
			
			case 2:
				importe = solicitarImporte("Introduce importe de la leche");
				cambio = maquina.servirLeche(importe);
				if (cambio > MaquinaCafe.VALOR_MINIMO) {
					System.out.println("Recoja su cambio, gracias " + cambio + "€");
				}
				else {
					System.out.println("Producto servido, Gracias");
				}
				break;
			
			case 3:
				importe = solicitarImporte("Introduce importe del cafe con leche");
				cambio = maquina.servirCafeConLeche(importe);
				if (cambio > MaquinaCafe.VALOR_MINIMO) {
					System.out.println("Recoja su cambio, gracias " + cambio + "€");
				}
				else {
					System.out.println("Producto servido, Gracias");
				}
				
				break;
		
			case 4:
				System.out.println(maquina.toString());
				break;
			
			case 5:
				System.out.println("Apagando, adios");
				break;
			}
			
		}catch (MaquinaCafeException e) {
			System.out.println(e.getMessage());		
		}
	
		return opcion;
	}

	private static double solicitarImporte(String mensaje) {
		
		double importe;
		
		System.out.println(mensaje);
		importe = Double.parseDouble(teclado.nextLine());
		
		return importe;
		
	}

}
