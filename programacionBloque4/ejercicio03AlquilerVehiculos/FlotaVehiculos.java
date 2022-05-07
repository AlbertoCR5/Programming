package ejercicio03AlquilerVehiculos;

public class FlotaVehiculos {
	
	private Vehiculo vehiculos[];

	/**
	 *  Variable que guarda donde se insertará el siguiente vehiculo
	 *  Empieza con 0 y si vale vehiculos.length el almacen esta lleno
	 */
	private int numeroRealDeVehiculos;

	public FlotaVehiculos(int capacidadAlmacen) throws VehiculoException {
		if (capacidadAlmacen <= 0)
			throw new VehiculoException("Numero de vehiculos no puede ser negativo o cero");
		vehiculos = new Vehiculo[capacidadAlmacen];
		numeroRealDeVehiculos = 0;
	}

	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {

		Vehiculo vehiculoEncontrado;

		vehiculoEncontrado = buscarMatricula(vehiculo.getMatricula());
		if (vehiculoEncontrado != null) // se encontro un coche con esa
										// matricula
			throw new VehiculoException("Ya existe un coche con esa matricula");

		if (numeroRealDeVehiculos == vehiculos.length)
			throw new VehiculoException("No se pueden introducir m�s veh�culos");

		vehiculos[numeroRealDeVehiculos] = vehiculo;
		numeroRealDeVehiculos++;
	}

	private Vehiculo buscarMatricula(String matricula) {
		boolean existe = false;
		int i = 0;
		Vehiculo vehiculoEncontrado = null;

		while (i < numeroRealDeVehiculos && existe == false) {
			if (matricula.equalsIgnoreCase(
					vehiculos[i].getMatricula())) {
				existe = true;
				vehiculoEncontrado = vehiculos[i];
			}

			i++;
		}

		return vehiculoEncontrado;
	}

	public double precioAlquiler(String matricula, int dias) throws VehiculoException {

		Vehiculo vehiculo;

		vehiculo = buscarMatricula(matricula);
		if (vehiculo == null)
			throw new VehiculoException("No existe un coche con esta matricula");

		// depende del tipo de vehiculo, llama al código de Coche,Furgoneta...
		return vehiculo.calcularAlquiler(dias);
		
	}
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		
		for (int i = 0; i < numeroRealDeVehiculos; i++) {
			
			sb.append(vehiculos[i]);
			sb.append("\n");
			
		}
		
		return sb.toString();
	}
}
