package relacion02;
import java.util.Scanner;

public class Ejercicio05cuentaPositivos {

	private final static int MINIMO_NUMERO = 0;

	public final static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numero;
		int cuentaPositivos = -1;//0 
		
		do {
			System.out.println("Introduce un número");
			numero = teclado.nextInt();
			
			//if (numero >= MINIMO_NUMERO ) {
				cuentaPositivos++;
			//}
			
		} while(numero >= MINIMO_NUMERO );
		
		System.out.println("Se han introducido un total de " + cuentaPositivos + " números positivos") ;

	}

}
