import java.util.Scanner;

public class Ejercicio01 {

	public static final String VOCALES = "aeiouAEIOU";
	public static final String ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Introduce un caracter");
		char caracter = teclado.nextLine().charAt(0);
		boolean esConsonante = comprobarConsonante(caracter);
		
		if (esConsonante) {
			System.out.println("El caracter introducido es una consonante");
		}
		else {
			System.out.println("El caracter introducido NO es una consonante");
		}
		
		
		System.out.println("Introduce una Cadena");
		String cadena2 = teclado.nextLine();
		
		System.out.println("Introduce posicion inicio");
		int posicionInicial = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduce posicion final");
		int posicionFinal = Integer.parseInt(teclado.nextLine());
		
		String subcadena = subcadena(cadena2, posicionInicial, posicionFinal);
		System.out.println(subcadena);
		
		
		System.out.println("Introduce una cadena");
		String cadena = teclado.nextLine();
		boolean contieneConsonante = comprobarCadena(cadena);
		
		if (contieneConsonante) {
			System.out.println("La cadena introducida contiene alguna consonante");
		}
		else {
			System.out.println("La cadena introducida NO contiene consonantes");
		}
		
		System.out.println("Introduce una cadena para encryptarla");
		String cadenaSinEncryptar = teclado.nextLine().toUpperCase();
		
		String cadenaEncryptada = ecryptarCadena(cadenaSinEncryptar);
		System.out.println(cadenaEncryptada);
	}

	private static String ecryptarCadena(String cadenaSinEncryptar) {
	
		StringBuilder sbCadenaEncryptada = new StringBuilder();
		
		for (int i = 0; i < cadenaSinEncryptar.length(); i++) {
			
			if (Character.isLetter(cadenaSinEncryptar.charAt(i))) {
				int letraAbecedario = ABECEDARIO.indexOf(cadenaSinEncryptar.charAt(i));
				sbCadenaEncryptada.append(ABECEDARIO.charAt(letraAbecedario + 3));
			}
			else {
				sbCadenaEncryptada.append(cadenaSinEncryptar.charAt(i));
			}
		}
		
		return sbCadenaEncryptada.toString();
	}

	private static String subcadena(String cadena2, int posicionInicial, int posicionFinal) {

		StringBuilder sbSubcadena = new StringBuilder(cadena2);
		
		sbSubcadena.delete(0, posicionInicial);
		sbSubcadena.delete((posicionFinal - posicionInicial+1), sbSubcadena.length());
		
		return sbSubcadena.toString();
	}

	private static boolean comprobarCadena(String cadena) {
		
		boolean esConsonante = false;
		
		for (int i = 0; i < cadena.length() && !esConsonante; i++) {

			if (Character.isLetter(cadena.charAt(i))) {
				if (VOCALES.indexOf(cadena.charAt(i)) == -1) {
					esConsonante = true;
				} 
			}
			
		}
		
		return esConsonante;
	}

	private static boolean comprobarConsonante(char caracter) {
		
		boolean esConsonante = true;
		char caracterRecogido;
		
		for (int i = 0; i < VOCALES.length() && esConsonante; i++) {
			caracterRecogido = VOCALES.charAt(i);
			
			if (!Character.isLetter(caracter)) {
				esConsonante = false;
			}
			else {
				if (caracter == caracterRecogido) {
					esConsonante = false;
				}
			}
			
		}
		
		return esConsonante;
	}

}
