package recuperacionAbril2022Ejercicio1;

public class Cliente {
	private String dni;
	private String nombre;
	private double nomina;
	
	public Cliente(String dni, String nombre) {
		setDni(dni);
		setNombre(nombre);
		this.nomina = 0;
	}
	public Cliente(String dni, String nombre, double nomina) throws BancoException {
		setDni(dni);
		setNombre(nombre);
		setNomina(nomina);
	}
	public double getNomina() {
		return nomina;
	}
	private void setNomina(double nomina) throws BancoException {
		if (this.nomina < nomina) {
			throw new BancoException("La nomina puede incrementarse, pero no decrementarse");
		}
		if (this.nomina == 0) {
			throw new BancoException("No puedes consultar la nomina de este cliente porque no tiene");
		}
		this.nomina = nomina;
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		
		String info = "CLIENTE DNI " + dni + " NOMBRE " + nombre;;
		
		if (nomina != 0) {
			info = info + "Nomina " + getNomina();
		}

		return info;
	}
	
	
	
}
