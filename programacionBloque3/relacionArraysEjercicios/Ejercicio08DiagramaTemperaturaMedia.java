package relacionArraysEjercicios;

public class Ejercicio08DiagramaTemperaturaMedia {

	private static final String[] MESES = {"ENERO", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre",};
	
	public static void main(String[] args) {
		
		int temperatura[] = {12, 9, 17, 20, 24, 27, 29, 28, 24, 19, 17, 11};
		
		for (int i = 0; i < MESES.length; i++) {
			
			System.out.print(MESES[i] + ": ");
			
			for (int j = temperatura[i]; j > 0; j--) {
				
				System.out.print("☀️");
			}
			System.out.println();
		}

	}

}
