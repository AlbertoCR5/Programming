package EjercicioRepasoMonroyPet;

public class MonroyPet {

	private static final int MAXIMA_COMIDA = 2;
	static final String ANIMAL_2 = "GATO";
	static final String ANIMAL_1 = "PERRO";
	private static final String COMIDA_GATO = "PESCADO";
	private static final String COMIDA_PERRO = "HUESO";
	private static final int PRECIO_ALIMENTO = 30;
	private static final int PUNTOS_MINUTO = 3;
	private static final int MINUTOS_MAXIMOS_TOTAL = 100;
	private static final int MINUTOS_MAXIMOS_MASCOTA = 20;
	private static final int COMIDA_INICIAL = 2;
	private static final int PUNTOS_INCIALES = 0;
	static final int VALOR_MINIMO = 0;
	
	private String nombre;
	private String tipoMascota;
	private int puntos;
	private int totalComida;
	
	private static int totalJugadoEntreTodasMascotas=0;

	public MonroyPet(String nombre, String tipoMascota) throws MonroyPetException {
		
		setNombre(nombre);
		setTipoMascota(tipoMascota);
		this.puntos = PUNTOS_INCIALES;
		this.totalComida =COMIDA_INICIAL;		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	private void setTipoMascota(String tipoMascota) throws MonroyPetException {
		
		if (!(tipoMascota.equals(ANIMAL_1) || tipoMascota.equals(ANIMAL_2))) {
			throw new MonroyPetException("Tipo de mascota incorrecto");
		}
		
		this.tipoMascota = tipoMascota;
	}

	public int getTotalComida() {
		return totalComida;
	}


	public void minutosJugados(int minutosJugados) throws MonroyPetException, MonroyPetControlParentaException {
		
		if (minutosJugados <= VALOR_MINIMO || minutosJugados > MINUTOS_MAXIMOS_MASCOTA) {
			throw new MonroyPetException("Cantidad de minutos jugados insuficiente, o has superado el limite por mascota:" + MINUTOS_MAXIMOS_MASCOTA);	
		}
		
		puntos = puntos + PUNTOS_MINUTO * minutosJugados;			
		totalJugadoEntreTodasMascotas = totalJugadoEntreTodasMascotas+ minutosJugados;
		
		if (totalJugadoEntreTodasMascotas >= MINUTOS_MAXIMOS_TOTAL) {
			throw new MonroyPetControlParentaException("Has superado los minutos jugados " + MINUTOS_MAXIMOS_TOTAL + ". Las mascotas se van a dormir...ZzZzZzzz");
		}
	}

	@Override
	public String toString() {
		
		String info;
		
		if (tipoMascota.equals("PERRO"))
			info ="Pet nombre= " + nombre + ", tipo=" + tipoMascota + ", " + COMIDA_PERRO + " = " + totalComida
					+ "  puntos " + puntos;
		else
			info ="Pet nombre=" + nombre + ", tipo=" + tipoMascota + ", " + COMIDA_GATO + " = " + totalComida
					+ "  puntos " + puntos;
		return info;
	}
		
	public void darComida(int comidaADar) throws MonroyPetException{
		
		if (comidaADar <= VALOR_MINIMO || comidaADar < MAXIMA_COMIDA || totalComida < comidaADar) {
				throw new MonroyPetException("No se le puede dar esa cantidad de comida, o es insuficiente");
		}
		
		totalComida = totalComida - comidaADar;

	}
	
	public void comprarComida(int comidaAComprar) throws MonroyPetException {
		
		int puntosNecesarios = comidaAComprar * PRECIO_ALIMENTO;
		
		if (comidaAComprar <= VALOR_MINIMO || comidaAComprar > MAXIMA_COMIDA) {
			throw new MonroyPetException("No se puede comprar esa cantidad de comida, o es insuficiente");
		}
		
		if (puntosNecesarios > puntos) {
			throw new MonroyPetException("Puntos insuficientes para comprar esa cantidad de comida: " + puntos);
		}
		
		puntos = puntos - puntosNecesarios;
		totalComida = totalComida + comidaAComprar;

	}
	
	public boolean equals(MonroyPet otro) {
		
		boolean esRepetido = false;
		
		if (this.nombre.equals(otro.nombre) && this.tipoMascota.equals(otro.tipoMascota)) {
			esRepetido = true;
		}
		
		return esRepetido;
	}
	
	
	
}