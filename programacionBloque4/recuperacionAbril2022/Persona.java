package recuperacionAbril2022;

public class Persona {

	private String nombre;
	private String apellidos;
	private String DNI;
	private int telefono;

	public Persona(String nombre, String apellidos, String DNI, int telefono) {
		setNombre(nombre);
		setApellidos(apellidos);
		setDNI(DNI);
		setTelefono(telefono);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
