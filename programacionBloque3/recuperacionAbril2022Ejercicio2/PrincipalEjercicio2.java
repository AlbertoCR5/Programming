package recuperacionAbril2022Ejercicio2;

import java.util.Arrays;

public class PrincipalEjercicio2 {

	private static final int NOTA_CORTE = 5;


	public static void main(String[] args) {
		
		String[] nombres={"Luis Alvarez", "Benito Benitez", "Carla Garcia", "Ramon Lopez", "Rafaela Martinez", "Antonio Suarez", "Lola Zapico"};
		double[] notas= {6.5 ,3.2, 8, 6.8 ,4, 9, 3.2};
		String[] aprobados;
		
		
		System.out.println("El nombre del alumno con mejor nota es " + alumnoConMejorNota(nombres,notas));
		
		aprobados=alumnosAprobados(nombres, notas);
		
		System.out.println(Arrays.toString(aprobados));

	}

	private static String alumnoConMejorNota(String[] nombres, double[] notas) {
		
		double mejorNota = Double.MIN_VALUE;
		String nombreMejorNota = null;
		
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] > mejorNota) {
				nombreMejorNota = nombres[i];
				mejorNota = notas[i];
			}
		}
		return nombreMejorNota;
	}
	

	private static String[] alumnosAprobados( String[] nombres, double[] notas) {
		
		int cantidadAprobados = 0;
		
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= NOTA_CORTE) {
				cantidadAprobados++;			
			}
		}
		
		String[] aprobados = new String[cantidadAprobados];
		
		for (int i = 0; i < nombres.length; i++) {
			if (notas[i] >= NOTA_CORTE) {
				aprobados[cantidadAprobados-1] = nombres[i];
				cantidadAprobados--;			
			}
			
		}
		
		return aprobados;
	}

}
