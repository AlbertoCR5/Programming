package refuerzoVacaciones;

import java.util.Scanner;

public class Ejercicio01SueldoTrabajador {

	private static final int VALOR_MINIMO = 0;
	private static final int TOPE_HORAS = 40;
	private static final int HORA_NORMAL = 11;
	private static final int HORA_EXTRA = 15;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int horasTrabajadas, sueldo;
		
		do {
			System.out.println("Introduce las horas trabajadas en la semana");
			horasTrabajadas = Integer.parseInt(teclado.nextLine());
		} while (horasTrabajadas <= VALOR_MINIMO);
		
		
		if (horasTrabajadas < TOPE_HORAS) {
			sueldo = horasTrabajadas * HORA_NORMAL;
		}
		else {
			horasTrabajadas = horasTrabajadas - TOPE_HORAS;
			
			sueldo = (horasTrabajadas * HORA_EXTRA) + (TOPE_HORAS * HORA_NORMAL);
		}
		
		System.out.println("El trabajador cobrara " + sueldo + "€ esta semana");

	}

}
