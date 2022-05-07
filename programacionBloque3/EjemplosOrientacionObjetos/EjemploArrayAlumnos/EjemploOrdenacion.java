package EjemplosOrientacionObjetos.EjemploArrayAlumnos;

import java.util.Arrays;

public class EjemploOrdenacion {

	public static void main(String[] args) {
		
		int[] numeros= {20,18,13,15,50,26};
		String[] nombres= {"Pepe", "Pepa", "ana", "Andres", "Luis"};
		
		Arrays.sort(numeros);
		Arrays.sort(nombres);
		
		System.out.println( Arrays.toString(numeros));
		System.out.println( Arrays.toString(nombres));
		

	}

}

