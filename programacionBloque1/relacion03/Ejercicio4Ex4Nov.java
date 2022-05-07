package relacion03;

import java.util.Scanner;

public class Ejercicio4Ex4Nov {
	
	//CONSTANTES
	private static final int VALOR_MINIMO = 0;
	private static final int EXTRACTOR_CIFRA = 10;
	private final static int CANTIDAD_NUMEROS = 10;
	private final static int NUMERO_BESTIA = 666;
	
		
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		//VARIABLES
		int numero, cantidadCeros = 0; //Valor inicial de cantidad de 0
		long sumaPares = 0; //Valor inicial de la suma de pares
		boolean numeroBestia = false; //Inicio el boolean con valor falso
		
		//Aqui empieza el programa
		//Bucle que se ejecutara mientras el contador inicialmente en 1 sea menor o igual a 10, y el boolean sea falso
		for (int i = 1; i <= CANTIDAD_NUMEROS && numeroBestia == false; i++) {
			System.out.println("Introduce numero " + i + "/" + CANTIDAD_NUMEROS);
			numero = teclado.nextInt();
			
			//Extraemos la ultima cifra del numero, si la cifra es 0, se añadira a la variable cantidadCeros
			if (numero % EXTRACTOR_CIFRA == VALOR_MINIMO) {
				cantidadCeros++;
			}
			
			//Comprobamos que el numero sea positivo, si es positivo se sumara. 
			if (numero > VALOR_MINIMO) {
				sumaPares = sumaPares + numero;
			}
			
			//Si el numero es el numero de la bestia, boolean pasa a verdadero y finaliza el programa
			if (numero == NUMERO_BESTIA) {
				System.out.println("Número de la bestia, acaba el programa");
				numeroBestia = true;
			}
			
		}
		
		//Estos mensajes solo los mostrara si NUMERO_BESTIA no ha sido introducido
		if (!(numeroBestia)) {
			System.out.println("Hay " + cantidadCeros + " que acaban en " + VALOR_MINIMO);
			System.out.println("Todos los numeros positivos suman " + sumaPares);	
		}	
			
	}

}