package refuerzoEstructurasControl;

import java.util.Scanner;

public class conversorASCII_numero {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int entero;
		int opcion;
		char caracter;
		
		do {
			System.out.println("Convertir numero a caracter (1)");
			System.out.println("Convertir caracter a numero (2)");
			System.out.println("Salir (0)");
			opcion = teclado.nextInt();
			
			switch (opcion) {
			
			case 1:
				System.out.println("Introduce un numero");
				entero = teclado.nextInt();
				
				caracter = (char) entero;
				
				System.out.println(caracter);
				
				break;
				
			case 2:
				System.out.println("Introduce un carater");
				caracter = teclado.next().charAt(0);
				
				entero = (int) caracter;
				
				System.out.println(entero);
				
				break;
				
			default:
				System.out.println("Adios");
				
			}

		} while (opcion == 1 || opcion == 2);
		
	}

}

