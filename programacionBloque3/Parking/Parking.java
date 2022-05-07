package Parking;

public class Parking {

	private String nombre;
	private Categoria categoria;
	private int numeroPlazas;
	private int numeroPlazasOcupadas;
	private static double totalRecaudado = 0;
	
	
	public Parking(String nombre, Categoria categoria, int numeroPlazas) throws ParkingException {

		setNombre(nombre);
		this.categoria = categoria;
		setNumeroPlazas(numeroPlazas);
		this.numeroPlazasOcupadas = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws ParkingException {
		if (nombre.length() <= 0) {
			throw new ParkingException("ERROR, nombre asignado no valido");
		}
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
	public int getNumeroPlazas(){
		return numeroPlazas;
	}
	
	public void setNumeroPlazas(int numeroPlazas) throws ParkingException {
		
		if (numeroPlazas <= 0) {
			throw new ParkingException("ERROR, no se puede crear un parking con numero de plazas nulo o negativo");
		}
		this.numeroPlazas = numeroPlazas;
	}
	
	public int getNumeroPlazasOcupadas() {
		return numeroPlazasOcupadas;
	}
	
	
	public void cocheEntraEnParking() throws ParkingException {
		if (numeroPlazas==numeroPlazasOcupadas) {
			throw new ParkingException("No puede entrar, parking completo");
		}
		numeroPlazasOcupadas++;
	}
	@Override
	public String toString() {
		return "Parking " + nombre + ", Categoria " + categoria + ", Numero de plazas: " + numeroPlazas
				+ ", Ocupadadas: " + numeroPlazasOcupadas ;
	}
	
	
	public double cobrarYsalirDelParking(int minutos) throws ParkingException {
		
		double precio;
		
		if (numeroPlazasOcupadas == 0) {
			throw new ParkingException("No hay coches en el parking");
		}
		else {
			if (minutos <= 0) {
			throw new ParkingException("Minutos introducidos no valido");
			}
		}
		
		precio = minutos * categoria.getPrecioPorMinuto();
		totalRecaudado = totalRecaudado + precio;
		numeroPlazasOcupadas--;
		
		return precio;
		
	}
	
	public Parking clonarParking(String nuevoNombre) throws ParkingException {
		
		Parking nuevoParking = new Parking(nuevoNombre, categoria, numeroPlazas);
		
		return nuevoParking;
		
	}
	
	
}
