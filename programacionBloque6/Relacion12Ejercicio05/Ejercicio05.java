import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio05 {

	private static Scanner teclado = new Scanner(System.in);
	private static final String FORMATO_LINEA = "F [a-zA-Z]{3,}\\.[a-z]{3}";

	public static void main(String[] args) {
		String nombreFichero;

		System.out.print("Introduce el nombre de un fichero: ");
		nombreFichero = teclado.nextLine();

		try {
			leerFicheroYCrearNuevos(nombreFichero);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void leerFicheroYCrearNuevos(String nombre) throws IOException {

		String linea;
	

		try ( BufferedReader filtroLectura = new BufferedReader(new FileReader(nombre)); ) {
			

			linea = filtroLectura.readLine();

			while (linea != null) {

				if (linea.matches(FORMATO_LINEA)) {
					tratarLineaFichero(linea);
				} else {
					System.out.println("La línea " + linea + " no cumple con el formato");
				}
				linea = filtroLectura.readLine();
			}
		} 

	}

	private static void tratarLineaFichero(String linea) throws IOException {
		String[] partes;
		boolean creado;
		partes = linea.split(" ");
		File fichero = new File(partes[1]);

		if (fichero.isFile()) {
			System.out.println("Ya existe el fichero " + fichero);
		} else {
			creado = fichero.createNewFile();

			if (creado) {
				System.out.println("Se ha creado correctamente el fichero " + fichero);
			} else {
				System.out.println("No se ha podido crear el fichero " + fichero);
			}

		}
	}

}
