package Parking;
import java.util.Scanner;

public class PrincipalEjercicio1 {
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		Categoria categoria=crearCategoria();
		
		try {
			Parking parking1 = new Parking("barato", categoria, 00);
			System.out.println(parking1);
		} catch (ParkingException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Parking parking2 = new Parking("medio", categoria, 0);
			System.out.println(parking2);
			Parking parking3 = new Parking("caro", categoria, 70);
			System.out.println(parking3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static Categoria crearCategoria() {
		
		Categoria categoria=null;
		String nombre;
		double precioPorMinuto;
		boolean esValido;
		
		do {
			esValido = true;
			try {
				System.out.println("Introduce el nombre de la categoria");
				nombre=teclado.nextLine();
				
				System.out.println("Introduce el precio por minuto:");
				precioPorMinuto=Double.parseDouble(teclado.nextLine());
				
				categoria=new Categoria(nombre, precioPorMinuto);
			} catch (ParkingException e) {
				esValido = false;
				System.out.println(e.getMessage());
			}
		} while (!esValido);
		
		
		return categoria;
	}

}
