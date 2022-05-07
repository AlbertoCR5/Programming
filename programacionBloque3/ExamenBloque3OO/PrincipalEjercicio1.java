package ExamenBloque3OO;

import java.util.Scanner;

public class PrincipalEjercicio1 {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		Tematica tematica=crearTematica();
		

	}

	private static Tematica crearTematica() {
		Tematica tematica=null;
		String nombre;
		int porcentaje;
		
		System.out.println("Introduce el nombre de la temática:");
		nombre=teclado.nextLine();
		
		System.out.println("Introduce el porcentaje de beneficio de los libros de esta temática:");
		porcentaje=Integer.parseInt(teclado.nextLine());
		
		try {
			tematica=new Tematica(nombre, porcentaje);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
		return tematica;
		
	}

}
