package Mains;

import java.util.Scanner;

import empresa.Directivo;
import empresa.Empleado;
import empresa.EmpleadoException;
import empresa.Informatico;
import empresa.Operario;
import empresa.Informatico.Especialidad;

public class MainEmpresa {
	private static Scanner teclado=new Scanner (System.in);

	public static void main(String[] args) {
		
		try {
			Operario operario=new Operario("344", "Luis", 1150, 2);
			Directivo directivo=new Directivo("1222" , "Pepe ", 2000, "Contabilidad");
			Informatico informatico=new Informatico("6677", "Antonio", 2400, Especialidad.DESARROLLO);
			
			System.out.println(informatico);
			System.out.println(directivo);
			System.out.println(operario);
			
			modificarSueldo( operario);
			modificarSueldo( directivo);
			modificarSueldo( informatico);
			
			System.out.println(informatico);
			System.out.println(directivo);
			System.out.println(operario);
			
		} catch (EmpleadoException e) {
			System.out.println(e.getMessage());
		}
	
	}

	private static void modificarSueldo(Empleado empleado) throws EmpleadoException {
		int nuevoSueldo;
		
		System.out.println("Introduce el nuevo sueldo de " + empleado.getNombre());
		nuevoSueldo=Integer.parseInt(teclado.nextLine());
		
		empleado.setSueldo(nuevoSueldo);
		
		
	}
}
