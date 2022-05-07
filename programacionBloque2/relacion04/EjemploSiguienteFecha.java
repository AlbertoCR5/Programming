package relacion04;

import java.util.Scanner;

public class EjemploSiguienteFecha {
	public static Scanner teclado=new Scanner (System.in);
	
	
	public static void main(String[] args) {
		int diaActual,mesActual,annoActual;

		diaActual=EjemploSiguienteFecha.decirDiaActual();
		mesActual=EjemploSiguienteFecha.decirMesActual();
		annoActual=EjemploSiguienteFecha.decirAnnoActual();
			
	
		EjemploSiguienteFecha.siguienteFecha(diaActual, mesActual, annoActual);
	}
	
	
	public static int decirDiaActual() {
		int diaActual;
		
		do {
			System.out.println("Introduce el número del día en el que nos encontramos");
			diaActual=Integer.parseInt(teclado.nextLine());
		}while(diaActual<0 || diaActual>31);
	
		return diaActual;
	}
		
	public static int decirMesActual() {
		int mesActual;
			
		do {
			System.out.println("Introduce el número del mes del año en el que nos encontramos");
			mesActual=Integer.parseInt(teclado.nextLine());
		}while(mesActual<0 || mesActual>12);
		
		return mesActual;
	}
	
	public static int decirAnnoActual() {
		int annoActual;
			
		do {
			System.out.println("Introduce el año en el que nos encontramos");
			annoActual=Integer.parseInt(teclado.nextLine());
		}while(annoActual<=0);
			
		return annoActual;
			
	}	
		
		
		
		
	private static void siguienteFecha (int diaActual, int mesActual, int annoActual) {
		int diaPosterior,mesPosterior=1,annoPosterior=1,diasDelMes;
		
		System.out.println("La fecha de hoy es " + diaActual + ":" + mesActual + ":" + annoActual);
		
		diasDelMes=EjemploDiasDeUnMes.diasDeUnMes(mesActual, annoActual);
		if (diasDelMes==diaActual) {
			diaPosterior=1;
			if(mesActual==12) {
				annoPosterior=annoActual+1;
			} else {
			mesPosterior=mesActual+1;
			}
		} else {
			diaPosterior=diaActual+1;
		}
		
		System.out.println("La fecha de mañana es: " + diaPosterior + ":" + mesPosterior + ":" + annoPosterior);
		
	}
		
		
		
		
		

}
