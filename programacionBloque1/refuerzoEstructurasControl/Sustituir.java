package refuerzoEstructurasControl;

import java.util.Scanner;

public class Sustituir {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String codigo, nombre; 
		
		do {
			codigo = teclado.nextLine();
		
		StringBuilder sbCodigo = new StringBuilder(codigo);
		StringBuilder sbNombre = new StringBuilder(codigo);
		sbCodigo.delete(17, codigo.length());
		codigo = sbCodigo.toString();
		
		
		sbNombre.delete(0, 18);
		nombre = sbNombre.toString();
		System.out.println(nombre);
		System.out.println("B749822B CE9BFAC1");
		System.out.println("A86CDBA5 19BA49B3");
		System.out.println(codigo);
		
		} while (codigo != "0");
		
	}
}