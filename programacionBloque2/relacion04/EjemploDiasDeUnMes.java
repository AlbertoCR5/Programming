package relacion04;

import java.util.Scanner;

public class EjemploDiasDeUnMes {
	public static Scanner teclado=new Scanner (System.in);

	
	
	
	public static void main(String[] args) {
		int mes,anyo,dias;
		
		System.out.println("Introduce un a√±o, por favor");
		anyo=Ejercicio01numeroEnRango.solicitarNumeroEnRango(0,2021);
		System.out.println("Introduce un mes del a√±o en n√∫mero, por favor");
		mes=Ejercicio01numeroEnRango.solicitarNumeroEnRango(1,12);
		
		dias=EjemploDiasDeUnMes.diasDeUnMes(mes, anyo);
		
		System.out.println("Los dÌas que tiene el mes del aÒo introducido son: " + dias);
	}

	
	public static int diasDeUnMes (int mes, int anyo) {
		int dias;
		boolean bisiesto=false;
		
		if (mes==2) {
			bisiesto=Ejercicio03compruebaBisiestoB.comprobarAnio(anyo);
			if (bisiesto) {
				dias=29;
				} else {
					dias=28;
				} 	
		} else {
			if (mes==4 || mes==6 || mes==9 || mes==11) {
				dias=30;			
			} else {
				dias=31;
			}	
			
		}
	
		return dias;
		
	}
}
