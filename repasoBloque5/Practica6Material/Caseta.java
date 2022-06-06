
import java.util.LinkedList;
import java.util.Objects;


public class Caseta {

	private String nombre;
	private String calle;
	private int numero;
	private LinkedList<Socio> socios;
	
	//TODO
	public Caseta(String nombre, String calle, int numero) {
		this.nombre=nombre;
		this.calle=calle;
		this.numero=numero;
		socios=new LinkedList<Socio>();
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	//TODO
	//Debe comprobar que no existe ya un socio con ese DNI
	//Debe añadirlo al final y asociarle un número, uno más del último
	public void annadirSocio (Socio socio)  throws FeriaException{
		
	}
	
	
	//TODO
	public void eliminarSociosConAntiguedadMenorA( int antiguedad) throws FeriaException {
		
	}
	
	//TODO
	//Debe conservarse el orden original en la coleccion socios
	
	public String listadoDeSociosOrdenadosPorNombre()  {
		return null;
	}

	@Override
	public String toString() {
		return "Caseta [nombre=" + nombre + ", calle=" + calle + ", numero=" + numero + ", socios=" + socios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	
	
	
	
	
	
}
