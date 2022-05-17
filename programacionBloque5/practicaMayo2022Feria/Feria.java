package practicaMayo2022Feria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Feria {

	private String ciudad;
	private HashMap<String, Caseta> casetas;
	
	
	public Feria(String ciudad) {
		this.ciudad = ciudad;
		casetas=new HashMap<String, Caseta>();
	}
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	public void annadirCaseta(Caseta casetaNueva) throws FeriaException{
		if ( casetas.containsKey(casetaNueva.getNombre())) {
			throw new FeriaException("Ya existe una caseta con el nombre " + casetaNueva.getNombre());
		}
		
		casetas.put(casetaNueva.getNombre(), casetaNueva);
	}
	
	
	
	//TODO
	public String listadoCasetasDeUnaCalleOrdenadasPorNumero(String calle) {
		
		StringBuilder sbListadoCasetasDeUnaCalleOrdenadasPorNumero = new StringBuilder();
		ArrayList<Caseta> listadoCasetasDeUnaCalleOrdenadasPorNumero = new ArrayList<Caseta>();
		
		for (Caseta caseta : casetas.values()) {
			if (caseta.getCalle().equalsIgnoreCase(calle)) {
				listadoCasetasDeUnaCalleOrdenadasPorNumero.add(caseta);
			}
		}
		
		Collections.sort(listadoCasetasDeUnaCalleOrdenadasPorNumero);
		
		for (Caseta caseta : listadoCasetasDeUnaCalleOrdenadasPorNumero) {
			if (caseta.getCalle().equalsIgnoreCase(calle)) {
				sbListadoCasetasDeUnaCalleOrdenadasPorNumero.append("Nombre: " + caseta.getNombre() + " Numero: " + caseta.getNumero() +"\n");
			}
		}
		return sbListadoCasetasDeUnaCalleOrdenadasPorNumero.toString();
	}
	
	//TODO
	public void borrarCasetaDeUnaCalle(String calle, String nombreCaseta) throws FeriaException{
		
		Caseta casetaEncontrada = casetas.get(nombreCaseta);
		if (casetaEncontrada == null) {
			throw new FeriaException("Error, caseta no registrada " + nombreCaseta);
		}
		
		if (!casetaEncontrada.getCalle().equalsIgnoreCase(calle)) {
			throw new FeriaException("No hay caseta con ese nombre en esa calle");
		}
		
		casetas.remove(nombreCaseta);
	}
	
	//TODO
	public void modificarCalleCaseta( String nombreCaseta, String nuevaCalle) throws FeriaException{
		
		Caseta casetaEncontrada = casetas.get(nombreCaseta);
		
		if (casetaEncontrada == null) {
			throw new FeriaException("Error, caseta no registrada " + nombreCaseta);
		}
		if (casetaEncontrada.getCalle().equalsIgnoreCase(nuevaCalle)) {
			throw new FeriaException("Ya hay caseta con ese nombre en esa calle");
		}
		casetaEncontrada.setCalle(nuevaCalle);
	}
}
