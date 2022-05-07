package relacion05;

import java.util.Scanner;

public class Ejercicio10ValidarDireccionesWebs {

	private static final String PROTOCOLO = "https://";
	private static final String SUBDOMINIO = "www.";
	private static final String PUNTO = ".";
	private static final int CANTIDAD = 10;

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String direccionWeb;
		boolean esValida;

		for (int i = 1; i <= CANTIDAD; i++) {
			direccionWeb = solicitarDireccionWeb();
			esValida = comporbarDireccionWeb(direccionWeb);
			if (esValida) {
				System.out.println(direccionWeb + " SI es una direccion Web valida");
				System.out.println();
			} else {
				System.out.println(direccionWeb + " NO es una direccion Web valida");
				System.out.println();
			}
		}
	}

	private static String solicitarDireccionWeb() {

		String direccionWeb;

		System.out.println("Introduce una direccion Web");
		direccionWeb = teclado.nextLine().toLowerCase();

		return direccionWeb;
	}

	private static boolean comporbarDireccionWeb(String direccionWeb) {

		boolean esValida = false, esValidoProtocoloYSubdominio, esValidoNombreDominio, esValidoDominio;

		esValidoProtocoloYSubdominio = comprobarProtocoloYSubdominio(direccionWeb);
		esValidoNombreDominio = comprobarNombreDominio(direccionWeb);
		esValidoDominio = comprobarDominio(direccionWeb);

		if (esValidoProtocoloYSubdominio && esValidoNombreDominio && esValidoDominio) {
			esValida = true;
		}

		return esValida;
	}

	private static boolean comprobarProtocoloYSubdominio(String direccionWeb) {

		boolean esValidoProtocoloYSubdominio = false;

		if (direccionWeb.startsWith(PROTOCOLO + SUBDOMINIO)) {
			esValidoProtocoloYSubdominio = true;
		}

		return esValidoProtocoloYSubdominio;
	}

	private static boolean comprobarNombreDominio(String direccionWeb) {

		boolean esValidoNombreDominio = false;
		int posicionPrimerPunto, posicionSegundoPunto;
		char caracterPostPunto;

		posicionPrimerPunto = localizarPrimerPunto(direccionWeb);
		posicionSegundoPunto = localizarSegundoPunto(direccionWeb, posicionPrimerPunto);

		caracterPostPunto = direccionWeb.charAt(posicionPrimerPunto + 1);

		if (Character.isLetter(caracterPostPunto) && posicionSegundoPunto > posicionPrimerPunto) {
			esValidoNombreDominio = true;
		}

		return esValidoNombreDominio;
	}

	private static boolean comprobarDominio(String direccionWeb) {

		boolean esValidoDominio = false;
		int tamanioDominio;
		char caracter;

		tamanioDominio = direccionWeb.length() - direccionWeb.lastIndexOf(PUNTO) - 1;

		
		if ((tamanioDominio > 1 && tamanioDominio < 4) || (tamanioDominio == 4 && direccionWeb.charAt(direccionWeb.length()-1) == '/')) {
			esValidoDominio = true;			
		}
		
		for (int i = direccionWeb.lastIndexOf(PUNTO) + 1; i < direccionWeb.length() && esValidoDominio; i++) {
			caracter = direccionWeb.charAt(i);

			if (Character.isLetter(caracter) || direccionWeb.charAt(direccionWeb.length()-1) == '/'){
				esValidoDominio = true;
			}
			else {
				esValidoDominio = false;
			}
		}

		
		return esValidoDominio;
	}

	private static int localizarPrimerPunto(String direccionWeb) {

		int posicionPrimerPunto;

		posicionPrimerPunto = direccionWeb.indexOf(PUNTO);

		return posicionPrimerPunto;
	}

	private static int localizarSegundoPunto(String direccionWeb, int posicionPrimerPunto) {

		int posicionSegundoPunto;

		posicionSegundoPunto = direccionWeb.indexOf(PUNTO, posicionPrimerPunto + 1);

		return posicionSegundoPunto;
	}
}