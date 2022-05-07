package Examen21FebreroEj01;
import java.util.Scanner;

public class PrincipalEjercicio1 {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		Tematica tematica=crearTematica();
		//Libro(String titulo, Tematica tematica, int ejemplares, int puntuacion, double precioBase)
		//public Libro(String titulo, String autor, Tematica tematica, int ejemplares, int puntuacion, double precioBase)
		try {
			Libro libro1 = new Libro("hola", tematica,250);
			Libro libro2 = new Libro("Espero", "Aprobar", tematica, 15);
			System.out.println(libro1);
			System.out.println(libro2);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}

	}

	private static Tematica crearTematica() {
		
		Tematica tematica=null;
		String nombre;
		int porcentaje;
		boolean hayError;
		
		do {
			
			hayError = false;			
			try {
				System.out.println("Introduce el nombre de la temática:");
				nombre=teclado.nextLine();
				
				System.out.println("Introduce el porcentaje de beneficio de los libros de esta temática:");
				porcentaje=Integer.parseInt(teclado.nextLine());
			
				tematica=new Tematica(nombre, porcentaje);
				
			} catch (LibreriaException e) {
				System.out.println(e.getMessage());
				hayError = true;
			}
		} while (hayError);
		
		return tematica;
		
	}

}
