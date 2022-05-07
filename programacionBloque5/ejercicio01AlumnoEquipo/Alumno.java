package ejercicio01AlumnoEquipo;

public class Alumno {

	private String dni;
	private String nombre;

	public Alumno(String dni, String nombre) throws EquipoException {

		setDni(dni);
		setNombre(nombre);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws EquipoException {
		if (dni.length() != 9) {
			throw new EquipoException("ERROR, DNI introducido no valido");
		}
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws EquipoException {
		if (nombre.length() < 2) {
			throw new EquipoException("ERROR, el nombre " + nombre + ", es incorrecto");
		}
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno con dni: " + dni + " y nombre: " + nombre;
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
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
