package ExamenBloque3OO;


public class Tematica {

	private static final int MIN_BENEFICIO = 2;
	private static final int MAX_BENEFICIO = 8;
	private String nombre;
	private int porcentajeBeneficio;
	
	public Tematica(String nombre, int porcentajeBeneficio) throws LibreriaException {
		
		if ( porcentajeBeneficio <  MIN_BENEFICIO || porcentajeBeneficio > MAX_BENEFICIO ) {
			throw new LibreriaException("El porcentaje de beneficio  " + porcentajeBeneficio + " asociado a la temática  no se encuentra en el rango adecuado. No se puede crear la temática");
		}
		
		this.nombre = nombre.toUpperCase();
		this.porcentajeBeneficio = porcentajeBeneficio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentajeBeneficio() {
		return porcentajeBeneficio;
	}

	@Override
	public String toString() {
		return "Tematica " + nombre + ", Porcentaje de Beneficio " + porcentajeBeneficio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Tematica other = (Tematica) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

	
	
	
}
