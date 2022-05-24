package ejercicio2;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

	//Tenemos en cuenta nombres de modelo de m�s de una palabra
	private static final String PATRON_LINEA = "[0-9]{8}( ([0-9]|10)){1,6}";
	private static final String SUSPENSOS_TXT = "suspensos.txt";
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String nombreFichero;
		System.out.println("Introduce el nombre del fichero con las matriculas");
		nombreFichero = teclado.nextLine();

		try {
			crearFicheroConSuspensos(nombreFichero);
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			borrarFicheroSuspensos();
		}

	}

	private static void borrarFicheroSuspensos() {
		File fdestino=new File(SUSPENSOS_TXT);
		if (fdestino.exists() && fdestino.isFile()) {
			fdestino.delete();
		}
		
	}

	private static void crearFicheroConSuspensos(String nombreFichero) throws IOException {

		String linea;
		File fdestino=new File(SUSPENSOS_TXT);
		if (fdestino.exists() && fdestino.isFile()) {
			throw new IOException("Ya existe el fichero suspensos " );
		}

		try (BufferedReader filtroLectura = new BufferedReader(new FileReader(nombreFichero));
			PrintWriter filtroEscritura = new PrintWriter( new FileWriter(SUSPENSOS_TXT)); ){
		
			

			linea = filtroLectura.readLine();
			while (linea != null) {
				escribirSiTieneSuspensos(linea, filtroEscritura);

				linea = filtroLectura.readLine();

			}

			System.out.println("Se ha creado correctamente el fichero " + SUSPENSOS_TXT);
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} 

	}

	private static void escribirSiTieneSuspensos(String linea, PrintWriter filtroEscritura) throws IOException {
		
		int nota, contSuspensos=0;
		
		if (!linea.matches(PATRON_LINEA)) {
			throw new 	IOException("No encaja con el patron" + linea);
		}
		
		String[] partes= linea.split(" ");
		
		
		for (int i = 1; i < partes.length; i++) {
			nota=Integer.parseInt(partes[i]);
			if ( nota < 5) {
				contSuspensos++;
			}
		}
		
		if ( contSuspensos > 0) {
			filtroEscritura.println("ALUMNO CON DNI= " + partes[0] + " SUSPENSOS= " + contSuspensos + "\n");
		}
	}
}

	