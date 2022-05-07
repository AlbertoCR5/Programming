package renting;

public enum TipoCombustible {
	
	GASOLINA(Turismo.INCREMENTO_GASOLINA),
	DIESEL(Turismo.INCREMENTO_DIESEL);
	
	private double incrementoCombustible;
	
	private TipoCombustible(double incrementoCombustible) {
		this.incrementoCombustible = incrementoCombustible;
	}
	
	public double getIncremento() {
		return incrementoCombustible;
	}

}
