package ejercicio1;
import java.util.ArrayList;
import java.util.HashMap;

public class Series {

	private HashMap<String, Serie> mapSeries;
	
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	public void annadirSerie(Serie serie) throws SerieException {
		if (mapSeries.containsKey(serie.getNombreSerie())) {
			throw new SerieException("Ya existe esa serie");
		}
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	public ArrayList<Serie> seriesDeUnTemaOrdenadasPorAnno(Tema tema) throws SerieException{
		
		return null;
	}

	public void annadirTemporadaASerie(String serie, String nombreTemporada) throws SerieException{
		
	}
	
}
