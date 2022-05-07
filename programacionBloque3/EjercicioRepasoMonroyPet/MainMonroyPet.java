package EjercicioRepasoMonroyPet;

import java.util.Scanner;

public class MainMonroyPet {
	
	static final int OPCIONES = 5;

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		MonroyPet mascota1, mascota2;
		int opcion;
		
		mascota1 = crearMascota();
		mascota2 = crearMascota();
		
		try {
						
			do {
				opcion = mostrarMenu();
				ejecutarMenu(mascota1, mascota2, opcion);
			} while (opcion != OPCIONES);
		} catch (MonroyPetControlParentaException e) {
			System.out.println(e.getMessage());
		}
		

	}

	private static MonroyPet crearMascota() {
		
		String tipoMascota;
		String nombre;
		MonroyPet mascota = null;
		boolean esFallido;
		
		mostrarMensaje("Vamos a crear una mascota");
		
		do {			
			try {
				tipoMascota = solicitarTipoMascota("Introduce tipo de mascota (" + MonroyPet.ANIMAL_1 + ", " + MonroyPet.ANIMAL_2 + ")");
				nombre = solicitarNombre("Introduce un nombre para el " + tipoMascota );
				mascota = new MonroyPet(nombre, tipoMascota);
				esFallido = false;
			} catch (MonroyPetException e) {
				mostrarMensaje(e.getMessage());
				mostrarMensaje("Error al crear la mascota, intentelo de nuevo");
				esFallido = true;
			}
		} while (esFallido);
		
		return mascota;
	}

	private static String solicitarTipoMascota(String string) {

		String tipoMascota;
		
		mostrarMensaje(string);
		tipoMascota = teclado.nextLine().toUpperCase();
		
		return tipoMascota;
	}

	private static String solicitarNombre(String string) {

		String nombre;
		
		mostrarMensaje(string);
		nombre = teclado.nextLine();
		
		return nombre;
	}

	private static int mostrarMenu() {
		
		int opcion;
		
		do {
			mostrarMensaje("1. Dar comida a la mascota: (1-2)\r\n"
					+ "2. Comprar comida: (1-2)\r\n"
					+ "3. Jugar Mascota: (1-2) cuantos minutos.\r\n"
					+ "4. Informacion de mascotas:\r\n"
					+ "5. Salir.");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion <= MonroyPet.VALOR_MINIMO || opcion > OPCIONES);
		
		return opcion;
	}

	private static void ejecutarMenu(MonroyPet mascota1, MonroyPet mascota2, int opcion) throws MonroyPetControlParentaException {

		MonroyPet mascota;
		
		try {
			
			switch(opcion) {
			
			case 1:
				mascota = seleccionarMascota(mascota1, mascota2);
				mascota.darComida(solicitarCantidadAlimentosADar());
				mostrarMensaje("Tu mascota ha comido");
				break;
				
			case 2:
				mascota = seleccionarMascota(mascota1, mascota2);
				mascota.comprarComida(solicitarCantidadAlimentosAComprar());
				mostrarMensaje("Compra realizada satisfactoriamente");
				break;
				
			case 3:
				mascota = seleccionarMascota(mascota1, mascota2);
				mascota.minutosJugados(solicitarMinutos());
				mostrarMensaje("Has been fun");
				break;
			
			case 4:
				mostrarMensaje(mascota1.toString());
				mostrarMensaje(mascota2.toString());
				break;
			}
		} catch (MonroyPetException e) {
			mostrarMensaje(e.getMessage());
		}
		
	}

	private static int solicitarCantidadAlimentosADar() {
		
		int comidaADar;
		
		do {
			comidaADar = solicitarEntero("Introduce cantidad de comida a dar");
		} while(comidaADar < 0);
		
		return comidaADar;
	}

	private static MonroyPet seleccionarMascota(MonroyPet mascota1, MonroyPet mascota2) {
		
		int numeroMascota;
		MonroyPet mascota;
		
		numeroMascota = solicitarMascota();
		if (numeroMascota == 1) {
			mascota = mascota1;
		}
		else {
			mascota = mascota2;
		}
		
		return mascota;
	}

	private static int solicitarMascota() {
		
		int mascota;
		
		do {
			mascota = solicitarEntero("Introduce la mascota(1-2): ");
		} while (!(mascota == 1 || mascota == 2));
		
		return mascota;
	}

	private static int solicitarEntero(String string) {
		
		String cadena;
		int numero = 0;
		boolean error;
		
		do {
			try {
				error = false;
				System.out.println(string);
				cadena = teclado.nextLine().toUpperCase();
				numero = Integer.parseInt(cadena);
			} catch (NumberFormatException ex) {
				error = true;
				System.out.println("No es un numero");
			}
		} while (error);
		
		return numero;
	}

	private static int solicitarCantidadAlimentosAComprar() {
		
		int alimentos;
		
		do {
			alimentos = solicitarEntero("Introduce numero de alimentos");
		} while(alimentos < 0);
		
		return alimentos;
	}

	private static int solicitarMinutos() {
		
		int minutos;
		
		do {
			minutos = solicitarEntero("Introduce numero de minutos: ");
		} while (minutos < 0);
		
		return minutos;
	}

	private static void mostrarMensaje(String string) {
		
		System.out.println(string);
		
	}

}