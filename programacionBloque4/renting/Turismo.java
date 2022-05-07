package renting;

public class Turismo extends Vehiculo{

	
	public static final double INCREMENTO_GASOLINA = 3.5;
	public static final double INCREMENTO_DIESEL = 2;
	
	private TipoCombustible combustible;

	public Turismo(String matricula, TipoGama gama, TipoCombustible combustible) throws VehiculoException {
		super(matricula, gama);
		setCombustible(combustible);
	}

	
	public TipoCombustible getCombustible() {
		return combustible;
	}


	public void setCombustible(TipoCombustible combustible) throws VehiculoException {
		
		if (!combustible.equals(TipoCombustible.GASOLINA) && !combustible.equals(TipoCombustible.DIESEL)) {
			throw new VehiculoException("ERROR, Combustible seleccionado incorrecto");
		}
		this.combustible = combustible;
	}


	@Override
	public double calcularAlquiler(int dias) throws VehiculoException {
		
		double precioAlquiler;
		
		if (dias <= 0) {
			throw new VehiculoException("ERROR, La cantidad de dias introducidos es incorrecto");
		}
		
		precioAlquiler = combustible.getIncremento() * dias;
		
		precioAlquiler = precioAlquiler + calcularAlquilerBase(dias);
		
		return precioAlquiler;
	}


	@Override
	public String toString() {
		return "Turismo: " + super.toString() + "[combustible=" + combustible + "]";
	}

	
}
