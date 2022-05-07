package Relacion8Ejercicio01Refranes;

import java.util.Arrays;
import java.util.Scanner;

public class MainRefran {

	private static final int VALOR_MINIMO = 0;
	public static final int CANTIDAD_REFRANES = 50;
	private static final int OPCIONES = 4;

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		Refran[] refranes = new Refran[CANTIDAD_REFRANES];
		int contadorRefranes = 0;
		int opcion;
		
		do {
			mostrarMenu();
			opcion = comprobarEntero();
			contadorRefranes = tratarMenu(opcion, refranes, contadorRefranes);
		} while (opcion != OPCIONES);

	}

	private static int tratarMenu(int opcion, Refran[] refranes, int contadorRefranes) {
		
		String palabraABuscar;
		boolean esRepetido;
		
		try {
			
			switch (opcion) {
			
			case 1:
				if (contadorRefranes == CANTIDAD_REFRANES) {
					mostrarMensaje("Error, Se ha superado el maximo de refranes guardados: " + CANTIDAD_REFRANES);
				}
				else {
					Refran refran = new Refran(solicitarRefran(), solicitarPopularidad());
					esRepetido = comprobarRefran(refran, refranes, contadorRefranes);
					if (esRepetido) {
						mostrarMensaje("Error, el refran introfucido ya esta guardado");
					}
					else {
						refranes[contadorRefranes] = refran;
						contadorRefranes++;
					}				
				}
				break;
				
			case 2:
				palabraABuscar = solicitarPalabra();
				buscarPalabraEnRefran(palabraABuscar, refranes, contadorRefranes);
				break;
			
			case 3:
				listarRefranesPorPoularidad(refranes, contadorRefranes);
				break;
			
			default:
				mostrarMensaje("Ciao");
				break;
			}
			
		} catch (RefranException e) {
			mostrarMensaje(e.getMessage());
		}
		
		return contadorRefranes;
		
		
	}

	private static void listarRefranesPorPoularidad(Refran[] refranes, int contadorRefranes) {

		Refran refranesOrdenados[] = new Refran[contadorRefranes];
		
		for (int i = 0; i < contadorRefranes; i++) {
			refranesOrdenados[i] = refranes[i];
			
		}
		Arrays.sort(refranesOrdenados);
		for (Refran refran: refranesOrdenados) {
			System.out.println(refran);
		}
		//System.out.println(Arrays.toString(refranesOrdenados));
	}

	private static void buscarPalabraEnRefran(String palabraABuscar, Refran[] refranes, int contadorRefranes) {
		
		boolean esEncontrada = false;
		
		for (int i = 0; i < contadorRefranes && esEncontrada == false; i++) {
			if (refranes[i].getRefran().contains(palabraABuscar)) {
				System.out.println(refranes[i]);
				esEncontrada = true;
			}
		}
		
		if (!esEncontrada) {
			mostrarMensaje("La palabra buscada no se encuentra en ningun refran");
		}
		
	}

	private static String solicitarPalabra() {

		String palabra;
		
		do {
			mostrarMensaje("Introduce la palabra a buscar");
			palabra = comprobarTexto();
		} while (palabra.length() <= VALOR_MINIMO);
		
		return palabra;
	}

	private static boolean comprobarRefran(Refran refran, Refran[] refranes, int contadorRefranes) {

		boolean esRepetido = false;
		
		for (int i = 0; i < contadorRefranes && esRepetido == false; i++) {
			if (refran.equals(refranes[i])) {
				esRepetido = true;
			}
		}
		
		return esRepetido;
	}

	private static int solicitarPopularidad() {
		
		int popularidad;
		
		mostrarMensaje("Introduce popularidad (0-100)");
		popularidad = comprobarEntero();
		
		return popularidad;
	}

	private static String solicitarRefran() {

		String refran;
		
		do {
			mostrarMensaje("Introduce un refran");
			refran = comprobarTexto();
		} while (refran.length() <= VALOR_MINIMO);
		
		
		return refran;
		
	}

	private static String comprobarTexto() {
		
		String texto;
		
		texto = teclado.nextLine().toUpperCase();
		
		return texto;
	}

	private static void mostrarMenu() {
		
		mostrarMensaje("1 Guardar un refr�n:\r\n"
				+ "2 Buscar un refr�n que contenga una palabra:\r\n"
				+ "3 Listar refranes:\r\n"
				+ "4 Salir.");
		
	}

	private static int comprobarEntero() {
		
		int numero = 0;
		boolean esInvalido;
		
		do {
			try {
				numero = Integer.parseInt(teclado.nextLine());
				esInvalido = false;
			} catch (NumberFormatException e) {
				mostrarMensaje("Introduce un numero!");
				esInvalido = true;
			}
		} while (esInvalido);
		
		return numero;
	}

	private static void mostrarMensaje(String string) {

		System.out.println(string);

	}

}
