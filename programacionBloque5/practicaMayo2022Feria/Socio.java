package practicaMayo2022Feria;

import java.util.Objects;

public class Socio implements Comparable<Socio>{

	private String dni;
	private String nombreCompleto;
	private int antiguedad;
	private int numeroAsignado;
	
	
	public Socio(String dni, String nombreCompleto,  int antiguedad) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.antiguedad=antiguedad;
		numeroAsignado = -1;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	

	public int getNumeroAsignado() {
		return numeroAsignado;
	}
	public void setNumeroAsignado(int numeroAsignado) {
		this.numeroAsignado = numeroAsignado;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", antiguedad=" + antiguedad + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(dni, other.dni);
	}
	@Override
	public int compareTo(Socio otro) {
		
		return this.nombreCompleto.compareTo(otro.nombreCompleto);
	}
	
	
}
