package EjemplosOrientacionObjetos.EjemploArrayAlumnos;

import java.util.Arrays;
import java.util.Scanner;

public class MainAlumno {

	private static final int TOTAL_ALUMNOS = 5;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		
		Alumno[] clase = new Alumno[TOTAL_ALUMNOS];

		solicitarDatosClase(clase);
		mostrarDatosClase(clase);
		
		System.out.println("Ordenado por nota: ");
		Arrays.sort(clase);
		mostrarDatosClase(clase);
		

	}

	private static void mostrarDatosClase(Alumno[] clase) {

		for (int i = 0; i < clase.length; i++) {
			System.out.println(clase[i]);
		}

	}

	/**
	 * Buscar el dni dentro de la clase. Si existe devuelve true y si no falso
	 * 
	 * @param clase
	 * @param dniBuscado
	 * @return
	 */
	private static boolean buscarAlumnoPorDni(Alumno[] clase, String dniBuscado, int numeroRealAlumnos) {

		boolean encontrado = false;

		for (int i = 0; i < numeroRealAlumnos && encontrado == false; i++) {

			if (clase[i].getDni().equals(dniBuscado)) {
				encontrado = true;
			}

		}
		return encontrado;

	}

	private static void solicitarDatosClase(Alumno[] clase) {

		String dni, nombre, direccion;
		int nota;
		boolean encontrado;
		int i = 0;
		while (i < clase.length) {
			System.out.println("Alumno " + (i + 1) + ":");
			System.out.println("Introduce dni");
			dni = teclado.nextLine();

			System.out.println("Introduce nombre");
			nombre = teclado.nextLine();

			System.out.println("Introduce direccion");
			direccion = teclado.nextLine();
			
			System.out.println("Introduce nota final:");
			nota = Integer.parseInt(teclado.nextLine());

			encontrado = buscarAlumnoPorDni(clase, dni, i);

			if (encontrado)
				System.out.println("Ya existe un alumno con ese DNI en la clase");
			else {
				clase[i] = new Alumno(dni, nombre, direccion, nota);
				i++;
			}

		}

	}

}

