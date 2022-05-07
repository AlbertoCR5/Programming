package cuentaAhorroJoven;

public class Titular {
	private String dni;
	private String nombre;
	private int edad;
	public Titular(String dni, String nombre, int edad) {
		setDni(dni);
		setNombre(nombre);
		setEdad(edad);
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Titular [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
}
