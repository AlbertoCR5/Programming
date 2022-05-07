package examenBloque4Ejercicio1;

public class Jugador  {

	private static final int RESISTENCIA_MAXIMA = 20;
	private static final int PUNTOS_COMBATE = 2;
	private String nombre;
	private int resistencia;

	public Jugador(String nombre, int resistencia) throws JuegoException {
		this.nombre = nombre;
		setResistencia(resistencia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getResistencia() {
		return resistencia;
	}

	/**
	 * Set de resistencia; el Jugador debe crearse al menos con resistencia 1, pero
	 * ésta puede bajar a 0 después (por eso está controlado de manera diferente en
	 * el constructor)
	 * 
	 * @param resistencia
	 * @throws JuegoException
	 */
	public void setResistencia(int resistencia) throws JuegoException {
		if (resistencia > RESISTENCIA_MAXIMA || resistencia < 0) {
			throw new JuegoException("La resistencia debe estar entre 1 y " + RESISTENCIA_MAXIMA);
		}
		this.resistencia = resistencia;
	}

	@Override
	public String toString() {
		return "NOMBRE " + nombre + "  RESISTENCIA " + resistencia;
	}

	public void combatir(Jugador otro) throws JuegoException {
		int misPuntosCombate, otroPuntosCombate;
		misPuntosCombate = this.resistencia;
		otroPuntosCombate = otro.resistencia;

		ejecutarCombate(otro, misPuntosCombate, otroPuntosCombate);
	}

	/* Método privado del que se ayuda el método combate */
	/* Lo cambiamos a protegido para poder usarlo desde Guerrero*/

	protected void ejecutarCombate(Jugador otro, int misPuntosCombate, int otroPuntosCombate) {
		if (misPuntosCombate > otroPuntosCombate) { // gano yo, otro pierde
			otro.resistencia = otro.resistencia - PUNTOS_COMBATE;
		} else {
			if (misPuntosCombate < otroPuntosCombate) { // pierdo yo
				this.resistencia = this.resistencia - PUNTOS_COMBATE;
			}
		}

		if (this.resistencia < 0) {
			this.resistencia = 0;
		}
		if (otro.resistencia < 0) {
			otro.resistencia = 0;
		}
	}

}