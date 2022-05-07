package examenBloque4Ejercicio1;

public enum TipoArma {
	ESPADA_CORTA(Guerrero.PUNTOS_POR_ESPADA_CORTA),
	ESPADA_LARGA(Guerrero.PUNTOS_POR_ESPADA_LARGA),
	MANDOBLE(Guerrero.PUNTOS_POR_MANDOBLE), 
	ARCO(Guerrero.PUNTOS_POR_ARCO);

	private int puntosArma;

	private TipoArma(int puntosArma) {
		this.puntosArma = puntosArma;
	}

	public int getPuntosArma() {
		return this.puntosArma;
	}
}