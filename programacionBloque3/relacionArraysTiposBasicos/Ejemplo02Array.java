package relacionArraysTiposBasicos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejemplo02Array {

	private static final int TOTAL_ALUMNOS = 10;
	private static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		String[] nombresDeLaClase=new String[TOTAL_ALUMNOS];
		String nombrePersona,apellido;
		
		//1. Desarrolla este método
		solicitarNombresDeAlumnos( nombresDeLaClase);
		
		//2. Desarrolla este método
		convertirNombresAMayusculas(nombresDeLaClase);
		
		//3. Listar los nombres de la clse
		listarNombres( nombresDeLaClase);
		
		//4. Crea el método que consideres para comprobar si una persona es o no alumno de la clase.
		
		System.out.println("Nombre de la persona");
		nombrePersona=teclado.nextLine().toUpperCase();
		
		buscarAlumno(nombrePersona, nombresDeLaClase);
		
		
		// 5 Desarrolla este método. Mostrar los alumnos que tienen un apellido solicitado
		
		System.out.println("Introduce el apellido:");
		apellido=teclado.nextLine().toUpperCase();
		
		mostrarAlumnosConApellidoIndicado( apellido, nombresDeLaClase);

	}

	private static void listarNombres(String[] nombresDeLaClase) {
		
		for (int i = 0; i < nombresDeLaClase.length; i++) {
			System.out.println(nombresDeLaClase[i]);
		}
		
	}
	
	private static void buscarAlumno(String nombrePersona, String[] nombresDeLaClase) {
		
		boolean esAlumno = false;
		
		for (int i = 0; i < nombresDeLaClase.length && esAlumno == false; i++) {
			if(nombrePersona.equalsIgnoreCase(nombresDeLaClase[i])) {
				esAlumno = true;
			}
		}
		
		if (esAlumno) {
			System.out.println("El alumno " + nombrePersona + " esta registrado.");
		}
		else {
			System.out.println("La persona " + nombrePersona + " no es un alumno.");
		}
		
	}

	/**
	 * Muestra por pantalla los nombres de los alumnos que tienen el apellido indicado
	 * @param apellido
	 * @param nombresDeLaClase
	 */
	private static void mostrarAlumnosConApellidoIndicado(String apellido, String[] nombresDeLaClase) {

		boolean esApellido = false;
		for (int i = 0; i < nombresDeLaClase.length; i++) {
			if (nombresDeLaClase[i].contains(apellido)) {
				System.out.println(nombresDeLaClase[i]);
				esApellido = true;
			}
		}
		
		if (!esApellido) {
			System.out.println("No hay alumnos con el apellido solicitado");
		}
		
	}

	/**
	 * Este método convierte a mayúsculas todos los nombers
	 * @param nombresDeLaClase
	 */
	private static void convertirNombresAMayusculas(String[] nombresDeLaClase) {
		
		Arrays.sort(nombresDeLaClase);
		for (int i = 0; i < nombresDeLaClase.length; i++) {
			nombresDeLaClase[i] = nombresDeLaClase[i].toUpperCase();
		}
		
	}

	/**
	 * Este método pide por teclado los nombres de los alumnos
	 * @param nombresDeLaClase
	 */
	private static void solicitarNombresDeAlumnos(String[] nombresDeLaClase) {
		
		for (int i = 0; i < nombresDeLaClase.length; i++) {			
			System.out.println("Introduce nombre y apellidos del almuno " + (i+1));
			nombresDeLaClase[i] = teclado.nextLine();
		}
		
	}

}
