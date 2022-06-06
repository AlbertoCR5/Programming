package ejercicio1;
import java.util.ArrayList;

public class Serie {
	private static final int ANNO_MINIMO = 1900;
	private String nombreSerie;
	private int anno;
	private Tema tema;
	private ArrayList<Temporada> temporadas;
	
	
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas=new ArrayList<Temporada>();
	}



	public String getNombreSerie() {
		return nombreSerie;
	}


	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) throws SerieException {
		if ( anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void annadirTemporada(String nombreTemporada) throws SerieException {
		
	}
	
	public void eliminarUltimaTemporada() throws SerieException{
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
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
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}


	
	
	
	
	
}
