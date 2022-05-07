package relacion8Ejercicio03HotelHabitacion;

import java.util.Arrays;

public class Hotel {

	Habitacion[] habitaciones;
	private int cantidadHabitacionesSimples;
	private int cantidadHabitacionesDobles;
	private int cantidadHabitacionesTriples;
	int totalHabitaciones;

	
	public Hotel(int cantidadHabitacionesSimples, int cantidadHabitacionesDobles, int cantidadHabitacionesTriples) throws HotelException {

		this.cantidadHabitacionesSimples = cantidadHabitacionesSimples;
		this.cantidadHabitacionesDobles = cantidadHabitacionesDobles;
		this.cantidadHabitacionesTriples = cantidadHabitacionesTriples;
		totalHabitaciones = cantidadHabitacionesSimples + cantidadHabitacionesDobles + cantidadHabitacionesTriples;
		habitaciones = new Habitacion[totalHabitaciones];
		crearHotel();
	}

	private void crearHotel() throws HotelException {
		
		int numeroHabitacion = 1;
		
		for (int i = 0; i <= cantidadHabitacionesSimples; i++) {
			habitaciones[i] = new Habitacion(numeroHabitacion, Habitacion.TIPOS_HABITACIONES[0]);
			numeroHabitacion++;
		}
		
		for (int i = 0; i <= cantidadHabitacionesDobles; i++) {
			habitaciones[numeroHabitacion] = new Habitacion(numeroHabitacion, Habitacion.TIPOS_HABITACIONES[1]);
			numeroHabitacion++;
		}
		
		for (int i = 0; i <= cantidadHabitacionesTriples; i++) {
			habitaciones[numeroHabitacion] = new Habitacion(numeroHabitacion, Habitacion.TIPOS_HABITACIONES[2]);
			numeroHabitacion++;
		}
	}

	public int getCantidadHabitacionesSimples() {
		return cantidadHabitacionesSimples;
	}

	public void setCantidadHabitacionesSimples(int cantidadHabitacionesSimples) throws HotelException {
		
		if (cantidadHabitacionesSimples < 0) {
			throw new HotelException("Error, un hotel no puede tener una cantidad negativa de habitaciones");
		}
		this.cantidadHabitacionesSimples = cantidadHabitacionesSimples;
	}

	public int getCantidadHabitacionesDobles(){
		return cantidadHabitacionesDobles;
	}

	public void setCantidadHabitacionesDoble(int cantidadHabitacionesDobles) throws HotelException {
		
		if (cantidadHabitacionesDobles < 0) {
			throw new HotelException("Error, un hotel no puede tener una cantidad negativa de habitaciones");
		}
		this.cantidadHabitacionesDobles = cantidadHabitacionesDobles;
	}

	public int getCantidadHabitacionesTriples() {
		return cantidadHabitacionesTriples;
	}

	public void setCantidadHabitacionesTriples(int cantidadHabitacionesTriples) throws HotelException {
		if (cantidadHabitacionesTriples < 0) {
			throw new HotelException("Error, un hotel no puede tener una cantidad negativa de habitaciones");
		}
		this.cantidadHabitacionesTriples = cantidadHabitacionesTriples;
	}
	

	@Override
	public String toString() {
		return "Hotel [habitaciones=" + Arrays.toString(habitaciones) + ", cantidadHabitacionesSimples="
				+ cantidadHabitacionesSimples + ", cantidadHabitacionesDobles=" + cantidadHabitacionesDobles
				+ ", cantidadHabitacionesTriples=" + cantidadHabitacionesTriples + ", totalHabitaciones="
				+ totalHabitaciones + "]";
	}

	public int checkIn ( String tipoHabitacion) throws HotelException {
		
		int habitacion=0;
		tipoHabitacion=tipoHabitacion.toUpperCase();
		
		switch (tipoHabitacion) {
		case "SIMPLE":
			habitacion=ocuparHabitacion(0, cantidadHabitacionesSimples-1);
			break;
		case "DOBLE":
			habitacion=ocuparHabitacion(cantidadHabitacionesSimples, cantidadHabitacionesSimples+ cantidadHabitacionesDobles -1);
			break;
		case "TRIPLE":
			habitacion=ocuparHabitacion(cantidadHabitacionesSimples+ cantidadHabitacionesDobles, habitaciones.length-1);
			break;
		default:
			throw new HotelException("No se encuentra el tipo " + tipoHabitacion);
		}
		return habitacion;
		
	}
	
	private int ocuparHabitacion(int inicio, int fin) throws HotelException {
		
		int habitacion=0;
		boolean  encontrada=false;
		for(int i= inicio; i<=fin && encontrada==false; i++) {
			if (! habitaciones[i].isOcupada()) {
				//está libre
				habitacion=i+1;
				encontrada=true;
				habitaciones[i].setOcupada(true);
			}
				
		}
		if (!encontrada) {
			throw new HotelException("No tenemos disponibles habitaciones del tipo solicitado");
		}
		
		return habitacion;
		
	}
	
	public void checkOut(int habitacion) throws HotelException {

		if (habitacion <= 0 || habitacion> habitaciones.length || ! habitaciones[habitacion-1].isOcupada()) {
			throw new HotelException("No se puede hacer el checkOut, el número de habitación es incorrecta " + habitacion);
		}
		habitaciones[habitacion-1].setOcupada(false);
		
	}
}
