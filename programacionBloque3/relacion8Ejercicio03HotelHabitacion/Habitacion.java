package relacion8Ejercicio03HotelHabitacion;

public class Habitacion {
	
	public static final String[] TIPOS_HABITACIONES= {"SIMPLE", "DOBLE", "TIPLE"};
	
	private int numero;
	private String tipo;
	private boolean ocupada;
	
	//Falta completar el control de errores en este método
	//Tirando la excepción cuando sea necesario
	public Habitacion(int numero, String tipo) throws HotelException {
		
		this.numero = numero;
		comprobarHabitacion(tipo);
		this.ocupada=false;
	}

	private void comprobarHabitacion(String tipo) throws HotelException {
		
		boolean esValida = false;
		
		for (int i = 0; i < TIPOS_HABITACIONES.length && esValida == false; i++) {
			if(tipo.equalsIgnoreCase(TIPOS_HABITACIONES[i])) {
				esValida = true;
			}
		}
		
		if (!esValida) {
			throw new HotelException("NO se puede crear la habiacion porque el tipo no es correcto");
		}
		
	}

	public int getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean isOcupada() {
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		String cadena;
		cadena="Nº" + numero + ", tipo: " + tipo ;
		if (ocupada) {
			cadena=cadena + " ocupada";
		}
		else {
			cadena=cadena + " libre";
		}
		return cadena;
	}


	
	
	
}
