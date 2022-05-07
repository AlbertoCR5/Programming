package renting;

public class Autobus extends Vehiculo {

	private static final int PLAZAS_MAXIMAS = 240;
	private static final int PLAZAS_MINIMAS = 10;
	private static final int INCREMENTO_POR_PLAZA = 5;
	private int cantidadPlazas;
	
	public Autobus(String matricula, TipoGama gama, int cantidadPlazas) {
		super(matricula, gama);
		
	}

	public int getCantidadPlazas() {
		return cantidadPlazas;
	}

	public void setCantidadPlazas(int cantidadPlazas) throws VehiculoException {
		
		if (cantidadPlazas < PLAZAS_MINIMAS || cantidadPlazas > PLAZAS_MAXIMAS) {
			throw new VehiculoException("ERROR, La cantidad de plazas introducidas es incorrecta");
		}
		this.cantidadPlazas = cantidadPlazas;
	}

	@Override
	public double calcularAlquiler(int dias) throws VehiculoException {
		
		double precioAlquiler;
		
		if (dias <= 0) {
			throw new VehiculoException("ERROR, La cantidad de dias introducidos es incorrecto");
		}
		
		precioAlquiler = cantidadPlazas * INCREMENTO_POR_PLAZA;
		
		precioAlquiler = precioAlquiler + calcularAlquilerBase(dias);
		
		return precioAlquiler;
	}

	@Override
	public String toString() {
		return "Autobus " + super.toString() + " [cantidadPlazas=" + cantidadPlazas + "]";
	}

}
