package examenBloque4Ejercicio1;

public class Guerrero extends Jugador implements DestrezaDisponible, Comparable<Guerrero> {

	public static final int MAX_DESTREZA = 4;
	public static final int MIN_DESTREZA = 1;	
	public static final int PUNTOS_POR_ESPADA_CORTA=2;
	public static final int PUNTOS_POR_ESPADA_LARGA=3;
	public static final int PUNTOS_POR_MANDOBLE=5;
	public static final int PUNTOS_POR_ARCO=2;

	private int destreza;
	private TipoArma arma;

	public Guerrero(String nombre, int resistencia, int destreza, TipoArma arma) throws JuegoException {
		super(nombre, resistencia);
		setDestreza(destreza);
		this.arma=arma;
	}
	
	public Guerrero(String nombre, int resistencia, int destreza) throws JuegoException {
		super(nombre, resistencia);
		setDestreza(destreza);
		this.arma=null;
	}

	public void setArma(TipoArma arma) throws JuegoException {
		if (arma == null) {
			throw new JuegoException("No puede quedarse sin arma");
		}
		if ( arma.equals(this.arma)) {
			throw new JuegoException("El guerrero ya tiene el arma " + arma);
		}
		this.arma = arma;
	}

	public TipoArma getArma() {
		return this.arma;
	}

	public void setDestreza(int destreza) throws JuegoException {
		if (destreza < MIN_DESTREZA || destreza > MAX_DESTREZA) {
			throw new JuegoException("Destreza inválida. Debe estar entre " + MIN_DESTREZA + " y " + MAX_DESTREZA);
		}

		if (destreza < this.destreza) {
			throw new JuegoException("La destreza solo puede incrementarse");
		}

		this.destreza = destreza;
	}

	@Override
	public void combatir(Jugador otro) throws JuegoException {
		int misPuntosCombate, otroPuntosCombate;
		misPuntosCombate = this.getResistencia() + this.destreza;
		if (this.arma != null) {
			misPuntosCombate = misPuntosCombate + this.arma.getPuntosArma();
		}
		otroPuntosCombate = otro.getResistencia();
		
		if ( otro instanceof Guerrero) {
			Guerrero otroGuerrero=(Guerrero) otro;
			otroPuntosCombate += otroGuerrero.getDestreza();
			if ( otroGuerrero.arma!=null) {
				otroPuntosCombate += otroGuerrero.arma.getPuntosArma();
			}
		}

		ejecutarCombate(otro, misPuntosCombate, otroPuntosCombate);
	}

	

	@Override
	public int getDestreza() {
		return this.destreza;
	}

	

	public String toString() {

		String info;

		if (this.getArma() == null) {
			info = super.toString() + " DESTREZA " + this.destreza;
		} else {
			info = super.toString() + " DESTREZA " + this.destreza + " ARMA " + this.arma;
		}

		return info;

	}

	@Override
	public int compareTo(Guerrero otro) {
		return Integer.compare(this.getResistencia(), otro.getResistencia());
	}

}
