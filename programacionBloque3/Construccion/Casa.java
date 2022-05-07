package Construccion;

public class Casa {

	public static final String CALIDAD_BAJA = "baja";
	public static final String CALIDAD_MEDIA = "media";
	public static final String CALIDAD_ALTA = "alta";
	public static final int PRECIO_BAJA = 700;
	public static final int PRECIO_MEDIA = 800;
	public static final int PRECIO_ALTA = 900;
	public static final int INCREMENTO_HABITACION = 500;
	public static final int INCREMENTO_BANIO = 1000;
	public static final int PISCINA = 10000;
	public static final int GARAJE = 5000;
	public static final int INCREMENTO_PLANTA = 10;
	
	

	private int metrosCuadrados, plantas, habitaciones, banios;
	private String calidades; // Baja, media, alta Constantes
	private boolean garaje, piscina;

	
	/**
	 * Constructor de la clase.
	 * Lanza excepcion en caso de no tener los valores correctos. (CasaImposibleException)
	 * @throws CasaImposibleException 
	 */
	public Casa(int metrosCuadrados, int plantas, int habitaciones, int banios, String calidades, boolean piscina, boolean garaje) throws CasaImposibleException {
		
			setMetrosCuadrados(metrosCuadrados);
			setPlantas(plantas);
			setHabitaciones(habitaciones);
			setBanios(banios);
			setCalidades(calidades);
			this.piscina = piscina;
			this.garaje = garaje;

	}
	
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) throws CasaImposibleException {
		
		if (metrosCuadrados < 1) {
			throw new CasaImposibleException("ERROR, debe haber un minimo de 1 metro cuadrado");
		}
		this.metrosCuadrados = metrosCuadrados;
	}

	public int getPlantas() {
		return plantas;
	}

	public void setPlantas(int plantas) throws CasaImposibleException {
		
		if (plantas < 1) {
			throw new CasaImposibleException("ERROR, debe haber un minimo de 1 planta en la casa");
		}		
		this.plantas = plantas;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) throws CasaImposibleException {
		
		if (habitaciones < 1) {
			throw new CasaImposibleException("ERROR, debe haber un minimo de 1 habitacion en la casa");
		}
		this.habitaciones = habitaciones;
	}

	public int getBanios() {
		return banios;
	}

	public void setBanios(int banios) throws CasaImposibleException {
		
		if (banios < 1) {
			throw new CasaImposibleException("ERROR, debe haber un minimo de 1 baño en la casa");
		}
		this.banios = banios;
	}

	public String getCalidades() {
		return calidades;
	}

	public void setCalidades(String calidades) throws CasaImposibleException {
		
		if (calidades != CALIDAD_BAJA && calidades != CALIDAD_MEDIA && calidades != CALIDAD_ALTA) {
			throw new CasaImposibleException("ERROR, calidad indicada no valida");
		}
		this.calidades = calidades;
	}

	public boolean isGaraje() {
		return garaje;
	}

	public boolean isPiscina() {
		return piscina;
	}


	/**
	 * Metodo para calcular el precio de la casa en función de sus características
	 * 
	 * @return el precio en €  de la vivienda
	 */
	public float getPrecio() {
		
		float precio = 0;
		
		if (calidades == CALIDAD_BAJA) {
			precio = PRECIO_BAJA;
		}
		else {
			if (calidades == CALIDAD_MEDIA) {
				precio = PRECIO_MEDIA;
			}
			else {
				precio = PRECIO_ALTA;
			}
		}
		
		precio = precio * metrosCuadrados;
		
		precio = precio * (plantas * INCREMENTO_PLANTA) / 100; 
		
		precio = precio + (habitaciones * INCREMENTO_HABITACION);
		
		precio = precio + (banios * INCREMENTO_BANIO);
		
		if (piscina == true) {
			precio = precio + PISCINA;
		}
		
		if (garaje == true) {
			precio = precio + GARAJE;
		}
		
		return precio;
	}

}

