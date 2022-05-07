package relacionArraysTiposBasicos;

public class Ejemplo00Array {

	private static final int TOTAL_ALUMNOS = 4;
	public static void main(String[] args) {
		
		// Primera forma, crear primero la referencia al vector, 
		double[] vectorNotas1;
		vectorNotas1=new double[TOTAL_ALUMNOS];
		
		// Segunda forma, todo en un paso 
		double[] vectorNotas2=new double[TOTAL_ALUMNOS];
		
		// Tercera forma, dandole valores de 
		double[] vectorNotas3= {2.5,6,7,8,9,3.5};
		
		System.out.println("Vector 1");
		mostrarVector(vectorNotas1);
		
		System.out.println("Vector 2");
		mostrarVector(vectorNotas2);
		
		System.out.println("Vector 3");
		mostrarVector(vectorNotas3);
		
		//Prueba a comentar la línea 9.¿Por qué sale un error en la línea 18?
		

	}

	private static void mostrarVector(double[] vector) {
		
		
		for (int i = 0; i < vector.length; i++) {
			
			System.out.println("El alumno " + (i+1) + " tiene un " + vector[i]);
		}
	}

}
