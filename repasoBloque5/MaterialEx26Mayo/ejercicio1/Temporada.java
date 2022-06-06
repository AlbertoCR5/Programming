import java.util.LinkedList;

public class Temporada {
	
	private String nombreTemporada;
	private LinkedList<String> capitulos;
	private int sumaOpiniones;
	private int numeroOpiniones;
	
	public Temporada(String nombreTemporada) {
		this.nombreTemporada=nombreTemporada;
		capitulos=new LinkedList<String>();
		sumaOpiniones=0;
		numeroOpiniones=0;
	}
	
	public void annadirCapitulo(String capitulo) {
		capitulos.add(capitulo);
	}
	
	public boolean eliminarCapitulo (String capitulo) {
		boolean borrado;
		borrado=capitulos.remove(capitulo);
		return borrado;
	}
	
	public void valorar( int nota)throws SerieException {
		if (nota < 0 || nota > 10) {
			throw new SerieException("Nota incorrecta "  + nota);
		}
		
		sumaOpiniones= sumaOpiniones + nota;
		numeroOpiniones++;
	}
	
	//TODO
	/*
	 *Elimina todos los capítulos desde el capítulo que se le pasa  hasta el final. 
	 * Si no encuentra el capítulo inicial  saltará la excepción
	 * 
	 */
	public void eliminarCapitulosDesdeEste(String nombreCapituloInicial) throws SerieException{
		
		
	}
	
	//TODO
	/* Devuelve el nombre del primer capítulo que contiene la palabra que  pasa por parámetro.
	 *  Si no lo encuentra salta la excepción 
	 */
	
	public String primerCapituloQueContieneEstaPalabara(String palabra) throws SerieException {
		
		return null;
	}
	
	
	
	public double getNotaMedia() {
		double notaMedia=-1;
		if (numeroOpiniones==0) {
			notaMedia= sumaOpiniones/numeroOpiniones;
		}
		return notaMedia;
	}
	
	public String toString() {
		String info;
	
		info=nombreTemporada+   " Número de capitulos " + capitulos.size() + 
					" Nota media " + getNotaMedia();
		return info;
		
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
