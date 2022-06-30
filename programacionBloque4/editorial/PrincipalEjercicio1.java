package ejercicio1;

import java.util.Arrays;

public class PrincipalEjercicio1 {

	//TODO
	private static int cantidadLibrosDigitales(Libro[] libros) {
	
		int numeroLibrosDigitales=0;
		
		for (int i = 0; i < libros.length; i++) {
			
			if (libros[i] instanceof LibroDigital) {
				numeroLibrosDigitales++;
			}
		}
		
		return numeroLibrosDigitales;
	}

	//TODO
	private static void listadoLibrosDigitalesOrdenados( Libro[] libros) {
		
		LibroDigital[] librosDigitales=new LibroDigital[cantidadLibrosDigitales(libros)];
		
		//Volcar solo los libros digitales al array
		int j=0;
		
		for (int i = 0; i < libros.length; i++) {
			
			if (libros[i] instanceof LibroDigital) {
				
				librosDigitales[j]=(LibroDigital) libros[i];
				j++;
			}
		}
		
		
		//Ordenar y mostrar
		Arrays.sort(librosDigitales);
		
		for (int i = 0; i < librosDigitales.length; i++) {
			System.out.println(librosDigitales);
		}
		

	}
	


    
    

}
