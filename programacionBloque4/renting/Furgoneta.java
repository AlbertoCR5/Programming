package renting;

public class Furgoneta extends Vehiculo{

	private static final int PESO_MAXIMO = 7500;
	private static final int PESO_MINIMO = 3500;
	private static final double INCREMENTO_POR_PESO = 0.5;
	
	private int PMA;
	
	public Furgoneta(String matricula, TipoGama gama, int PMA) {
		super(matricula, gama);

	}

	public int getPMA() {
		return PMA;
	}

	public void setPMA(int PMA) throws VehiculoException {
		
		if (PMA < PESO_MINIMO || PMA > PESO_MAXIMO) {
			throw new VehiculoException("ERROR, El peso maximo autorizado introducido es invalido");
		}
		this.PMA = PMA;
	}

	@Override
	public double calcularAlquiler(int dias) throws VehiculoException {
	
		double precioAlquiler;
		
		if (dias <= 0) {
			throw new VehiculoException("ERROR, La cantidad de dias introducidos es incorrecto");
		}
		
		precioAlquiler = PMA * INCREMENTO_POR_PESO;
		
		precioAlquiler = precioAlquiler + calcularAlquilerBase(dias);
		
		return precioAlquiler;
	}

}
