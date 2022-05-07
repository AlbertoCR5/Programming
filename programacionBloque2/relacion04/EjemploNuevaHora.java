package relacion04;

import java.util.Scanner;

public class EjemploNuevaHora {
	public static Scanner teclado=new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
		int horaActual,minutosActuales,segundosActuales,segundosASumar;
		
		horaActual=EjemploNuevaHora.dimeHora();
		minutosActuales=EjemploNuevaHora.dimeMinutos();
		segundosActuales=EjemploNuevaHora.dimeSegundos();	
		segundosASumar=EjemploNuevaHora.dimeSegundosASumar();
		
		pintarNuevaHora(horaActual,minutosActuales,segundosActuales,segundosASumar);
	}
	
	
	public static int dimeHora(){
		
		int horaActual;
		
		do {
			System.out.println("Introduce la hora que marca tu reloj, por favor");
			horaActual=Integer.parseInt(teclado.nextLine());
		} while(horaActual<0 || horaActual>=24);
		
		return horaActual;
		
	}
	
	
	public static int dimeMinutos() {
		
		int minutosActuales;
		
		do {
			System.out.println("Introduce los minutos que marca tu reloj, por favor");
			minutosActuales=Integer.parseInt(teclado.nextLine());
		} while(minutosActuales<0 || minutosActuales>=60);
		
		return minutosActuales;
			
	}
	
	
	public static int dimeSegundos() {
		
		int segundosActuales;
		
		do {
			System.out.println("Introduce los segundos que marca tu reloj, por favor");
			segundosActuales=Integer.parseInt(teclado.nextLine());
		} while(segundosActuales<0 || segundosActuales>=60);
		
		return segundosActuales;
			
	}
	
	
	public static int dimeSegundosASumar() {
	
		int segundosASumar;
		
		System.out.println("Introduce la cantidad de segundos que has sumado");
		segundosASumar=Integer.parseInt(teclado.nextLine());
		
		return segundosASumar;
		
	}
	
	
	
	
	
	
	public static void pintarNuevaHora (int horaActual, int minutosActuales, int segundosActuales, int segundosASumar) {
		
		int horaPosterior,minutosPosteriores,segundosPosteriores,segundosFinales;
		
		System.out.println("La hora anterior que has introducido era: " + horaActual + ":" + minutosActuales + ":" + segundosActuales);
		
		segundosFinales=horaActual*3600 + minutosActuales*60 + segundosActuales + segundosASumar;


		horaPosterior=segundosFinales/3600%24;
		minutosPosteriores=segundosFinales%3600/60;
		segundosPosteriores=segundosFinales%3600%60;
		
		System.out.println("La nueva hora es: " + horaPosterior + ":" + minutosPosteriores + ":" + segundosPosteriores);
		
	}
	
	
	

}
