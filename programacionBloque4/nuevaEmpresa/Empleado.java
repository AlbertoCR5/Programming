package nuevaEmpresa;

public abstract class Empleado implements ActualizableSueldo, Comparable<Empleado> {

	public static final int SUELDO_ADMINISTRATIVO=1150;
	public static final int SUELDO_OPERARIO=1100;
	public static final int SUELDO_CONTABLE=1350;
		
	private static final int SUELDO_MINIMO_EMPLEADO = 1100;
	private String dni;
	private String nombre;
	private int sueldo;
	
	public Empleado(String dni, String nombre, int sueldo) throws EmpresaException  {
		setDni(dni);
		setNombre(nombre);
		setSueldo(sueldo);
		
	}
	
	protected void setSueldo( int sueldo) throws EmpresaException {
		if (sueldo < SUELDO_MINIMO_EMPLEADO)
			throw new EmpresaException("El sueldo de cualquier empleado nuna debe superar los " + SUELDO_MINIMO_EMPLEADO + "  euros");
		this.sueldo=sueldo;
	}


	public int getSueldo() {
		return sueldo;
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
		return "Empleado DNI=" + dni + ", nombre=" + nombre +  " sueldo " + sueldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Empleado otro) {
		
		return this.getNombre().compareTo(otro.getNombre());
	}
		
}
