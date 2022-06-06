package ejercicio1;
import java.util.LinkedList;

public class Temporada {
	
	private String nombreTemporada;
	private LinkedList<String> capitulos;
	private int numeroDeTemporada;
	
	public Temporada(String nombreTemporada) {
		this.nombreTemporada=nombreTemporada;
		capitulos=new LinkedList<String>();
	}
	
	public void annadirCapitulo(String capitulo) {
		capitulos.add(capitulo);
	}
	
	public boolean eliminarCapitulo (String capitulo) {
		boolean borrado;
		borrado=capitulos.remove(capitulo);
		return borrado;
	}
	
	
	public void eliminarCapitulos(String nombreCapituloInicial) {
		
		
	}
	
	public void annadirCapituloDelanteDeOtro(String nuevoCapitulo, String capituloReferencia) 
			throws SerieException{
			
	}
	
	
		

	public int getNumeroDeTemporada() {
		return numeroDeTemporada;
	}

	public void setNumeroDeTemporada(int numeroDeTemporada) {
		this.numeroDeTemporada = numeroDeTemporada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreTemporada == null) ? 0 : nombreTemporada.hashCode());
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
		Temporada other = (Temporada) obj;
		if (nombreTemporada == null) {
			if (other.nombreTemporada != null)
				return false;
		} else if (!nombreTemporada.equals(other.nombreTemporada))
			return false;
		return true;
	}
	
	
}
