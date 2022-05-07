package recuperacionAbril2022;

public class Piso extends Vivienda implements Habitable{

	private int numeroPlanta;
	private char puerta;
	
	public Piso(int referenciaCatastral, String direccion, double eficienciaEnergetica, int metrosCuadrados,
			int numeroHabiaciones, int numeroBannos, int plazasGarage, boolean esOcupada, boolean esHabitable,
			Persona persona, int numeroPlanta, char puerta) throws ConstruccionException {
		super(referenciaCatastral, direccion, eficienciaEnergetica, metrosCuadrados, numeroHabiaciones, numeroBannos,
				plazasGarage, esOcupada, esHabitable, persona);

		this.numeroPlanta = numeroPlanta;
		this.puerta = puerta;	
	}
	
	public int getNumeroPlanta() {
		return numeroPlanta;
	}

	public void setNumeroPlanta(int numeroPlanta) {
		this.numeroPlanta = numeroPlanta;
	}

	public char getPuerta() {
		return puerta;
	}

	public void setPuerta(char puerta) {
		this.puerta = puerta;
	}

	@Override
	public double facturaAgua(double facturaAgua) throws ConstruccionException {
		return facturaAgua = facturaAgua * getNumeroBannos();
		
	}

	@Override
	public double facturaLuz(double facturaLuz) {
		return facturaLuz = facturaLuz * getEficienciaEnergetica();
		
	}

	@Override
	public double impuestos() {
		
		double impuestos = (getMetrosCuadrados() * 100 + getMetrosCuadrados() * getPlazasGarage()) / 100;
		
		return impuestos; 		
	}

}
