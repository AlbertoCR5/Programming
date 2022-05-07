package profesorado;

public abstract class Profesor implements EvaluableAnualmente{

	
	private String nombre;
	private String DNI;
	private String centroAdjudicado;
	protected int antiguedad;

	public Profesor(String nombre, String DNI, String centroAdjudicado) throws ProfesoresException {
		this.nombre = nombre;
		setDNI(DNI);
		this.centroAdjudicado = centroAdjudicado;
		this.antiguedad=0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCentroAdjudicado() {
		return centroAdjudicado;
	}
	public void setCentroAdjudicado(String centroAdjudicado) throws ProfesoresException {
		this.centroAdjudicado = centroAdjudicado;
		this.antiguedad=0;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) throws ProfesoresException {
		
		if (DNI.length() != 9) {
			throw new ProfesoresException("ERROR, El DNI " + DNI + " es erroneo.");
		}
		this.DNI = DNI;
	}


	@Override
	public String toString() {
		return "Nombre=" + nombre + " centroAdjudicado=" + centroAdjudicado + ", antiguedad=" + antiguedad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
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
		Profesor other = (Profesor) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}
	
}
