package refuerzoEstructurasControl;

import java.util.Random;

public class GeneraOperadorAleatorio {

	public static void main(String[] args) {

		Random serieAleatoria = new Random();
		//Llama a la clase Random, la llamamos serieAleatoria
		int numeroAleatorio;
		//Declaro variable numeroAleatorio de tipo int
		char operador = 0;
		
		numeroAleatorio = serieAleatoria.nextInt(3); 
		//Genera un numero aleatorio de 0 a (3) 
		//y lo asigna a la variable numeroAleatorio
		
		switch (numeroAleatorio) {
		//Dependiendo del numero generado (0-3)
		//asignara un operador en cada caso
		case 0:
			operador = '+';
			break;

		case 1:
			operador = '-';
			break;
		case 2:
			operador = '*';
			
			break;
		case 3:
			operador = '/';
			break;
		}

		System.out.println(operador);
	}

}
