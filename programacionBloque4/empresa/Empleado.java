package empresa;

public  class Empleado {
	public static final int SUELDO_MINIMO=800;
	
	private String dni;
	private String nombre;
	private int sueldo;
	
	
	public Empleado(String dni, String nombre, int sueldo) throws EmpleadoException {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setSueldo(sueldo);
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
	public final int getSueldo() {
		return sueldo;
	}
	public  void setSueldo(int sueldo) throws EmpleadoException {
		if (sueldo < SUELDO_MINIMO)
			throw new EmpleadoException(" Sueldo incorrecto, no puede ser inferior a " + SUELDO_MINIMO);
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo ;
	}
	
	
	
	
}
