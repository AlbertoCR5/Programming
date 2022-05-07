package renting;

public class FlotaVehiculos {

	private Vehiculo vehiculos[];
	
	private int numeroRealVehiculos;
	
	public FlotaVehiculos(int capacidadAlmacen) throws VehiculoException {
		
		if (capacidadAlmacen <= 0) {
			throw new VehiculoException("ERROR; La cantidad de vehiculos no puede ser negativo o cero");
		}
		vehiculos = new Vehiculo[capacidadAlmacen];
		numeroRealVehiculos = 0;
	}
	
	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {
		
		Vehiculo vehiculoRepetido;
		
		if (numeroRealVehiculos == vehiculos.length) {
			throw new VehiculoException("ERROR, No se pueden añadir mas vehiculos");
		}
		
		vehiculoRepetido = buscarMatricula(vehiculo.getMatricula());
		
		if (vehiculoRepetido != null) {
			throw new VehiculoException("ERROR, no se puede añadir ete vehiculo por que ya esta incluido");
		}
		
		vehiculos[numeroRealVehiculos] = vehiculo;
		
		numeroRealVehiculos++;
	}

	private Vehiculo buscarMatricula(String matricula) {
		
		boolean esMatriculado = false;
		Vehiculo nuevoVehiculo = null;
		
		for (int i = 0; i < numeroRealVehiculos && !esMatriculado; i++) {
			
			if (matricula.equalsIgnoreCase(vehiculos[i].getMatricula())) {
				nuevoVehiculo = vehiculos[i];
				esMatriculado = true;
			}
		}
		
		return nuevoVehiculo;
	}
}
