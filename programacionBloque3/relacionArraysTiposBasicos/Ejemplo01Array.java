package relacionArraysTiposBasicos;

import java.util.Scanner;

public class Ejemplo01Array {

	//private static final int TOTAL_ALUMNOS = 4;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numeroAlumnos;
		double[] vectorNotas;
		
		numeroAlumnos = solicitarNumeroAlumnos("Introduce el numero total de alumnos");
		vectorNotas = new double[numeroAlumnos];
		
		solicitarNotas(vectorNotas);
//		vectorNotas[0]=5; // Nota del alumno 0
//		vectorNotas[1]=3; // Nota del alumno 1
//		vectorNotas[2]=8; // Nota del alumno 2
//		vectorNotas[3]=7.5; // Nota del alumno 3
		
		mostrarNotas(vectorNotas);
		
		mostrarAlumnosConNotasSuperioresALaMedia(vectorNotas);
		
		
		// Cambios
		//1. Comenta las  líneas 8,9 anteriores e incluye un nuevo dato que pidas por teclado, que será el número de alumnos de la clase.
		// El vector debe tener el tamaño correspondiente a ese número de alumnos
		
		//2. Comenta las líneas de 12 a 15 e incluye un nuevo método llamado solicitadarNotas que solicite las notas de los alumnos y las 
		//incluya en el vector
		
		//3. Desarrolla el método calcularMedia y mostrarAlumnosConNotasSuperioresALaMedia

	}

	private static void solicitarNotas(double[] vectorNotas) {
		
		for (int i = 0; i < vectorNotas.length; i++) {
			System.out.println("Introduce la nota del alumno " + (i+1) + "/" + vectorNotas.length);
			vectorNotas[i] = Double.parseDouble(teclado.nextLine());
		}
		
	}

	private static int solicitarNumeroAlumnos(String string) {
		
		int numeroAlumnos;
		
		System.out.println(string);
		numeroAlumnos = Integer.parseInt(teclado.nextLine());
		
		return numeroAlumnos;
	}

	/**
	 * Muestra por pantalla el alumno y sus notas
	 * @param vectorNotas
	 */
	private static void mostrarNotas(double[] vectorNotas) {
		
		for (int i = 0; i < vectorNotas.length; i++) {
			
			System.out.println("El alumno " + (i+1) + " tiene un " + vectorNotas[i]);
		}
		
	}

	//*
	
	private static void mostrarAlumnosConNotasSuperioresALaMedia(double[] vectorNotas) {
	
		double media;
		
		media=calcularMedia(vectorNotas);
				
		for (int i = 0; i < vectorNotas.length; i++) {
			if (vectorNotas[i] > media) {
				System.out.println("El alumno " + (i+1) + " obtuvo un " + vectorNotas[i] + " que es superior a la media (" + media + ")");
			}
		}
	}

	private static double calcularMedia(double[] vectorNotas) {
		
		double media = 0;
		
		for (int i = 0; i < vectorNotas.length; i++) {
			media = media + vectorNotas[i];
		}
		
		media = media / vectorNotas.length;
		
		return media;
	}

	

}
