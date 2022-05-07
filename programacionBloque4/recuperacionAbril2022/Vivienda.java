package recuperacionAbril2022;

public class Vivienda extends Construccion {

	private static final int METROS_CUADRADOS_MINIMOS = 51;
	private int metrosCuadrados;
	private int numeroHabiaciones;
	private int numeroBannos;
	private int plazasGaraje;
	private boolean esOcupada;
	private boolean esHabitable;
	
	public Vivienda(int referenciaCatastral, String direccion, double eficienciaEnergetica, int metrosCuadrados, int numeroHabiaciones, int numeroBannos, int plazasGarage, boolean esOcupada, boolean esHabitable, Persona persona) throws ConstruccionException {
		super(referenciaCatastral, direccion, eficienciaEnergetica);
		setMetrosCuadrados(metrosCuadrados);
		setNumeroHabiaciones(numeroHabiaciones);
		setNumeroBannos(numeroBannos);
		setPlazasGarage(plazasGarage);
		this.esOcupada = esOcupada;
		this.esHabitable = esHabitable;
	}
	
	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) throws ConstruccionException {
		if (metrosCuadrados < METROS_CUADRADOS_MINIMOS) {
			throw new ConstruccionException("ERROR");
		}
		this.metrosCuadrados = metrosCuadrados;
	}

	public int getNumeroHabiaciones() {
		return numeroHabiaciones;
	}

	public void setNumeroHabiaciones(int numeroHabiaciones) throws ConstruccionException {
		if (numeroHabiaciones < 1) {
			throw new ConstruccionException("ERROR");
		}
		this.numeroHabiaciones = numeroHabiaciones;
	}

	public int getNumeroBannos() throws ConstruccionException {
		if (numeroBannos < 1) {
			throw new ConstruccionException("ERROR");
		}
		return numeroBannos;
	}

	public void setNumeroBannos(int numeroBannos) {
		this.numeroBannos = numeroBannos;
	}

	public int getPlazasGarage() {
		return plazasGaraje;
	}

	public void setPlazasGarage(int plazasGarage) throws ConstruccionException {
		if (plazasGarage < 0) {
			throw new ConstruccionException("ERROR");
		}
		this.plazasGaraje = plazasGarage;
	}

	public boolean isEsOcupada() {
		return esOcupada;
	}

	public boolean isEsHabitable() {
		return esHabitable;
	}


}
