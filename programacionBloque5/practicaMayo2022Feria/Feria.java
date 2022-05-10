package practicaMayo2022Feria;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

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
		LinkedList<Caseta> listadoCasetasDeUnaCalleOrdenadasPorNumero = new LinkedList<Caseta>(casetas.values());
		
		Collections.sort(listadoCasetasDeUnaCalleOrdenadasPorNumero);
		
		for (Caseta caseta : listadoCasetasDeUnaCalleOrdenadasPorNumero) {
			if (caseta.getCalle().equalsIgnoreCase(calle)) {
				sbListadoCasetasDeUnaCalleOrdenadasPorNumero.append(caseta + "\n");
			}
		}
		return sbListadoCasetasDeUnaCalleOrdenadasPorNumero.toString();
	}
	
	//TODO
	public void borrarCasetaDeUnaCalle(String calle, String nombreCaseta) throws FeriaException{
		
		if (!casetas.containsKey(nombreCaseta)) {
			throw new FeriaException("Error, caseta no registrada " + nombreCaseta);
		}
		
		if (calle.contains(nombreCaseta.g)) {
			
		}
	}
	
	//TODO
	public void modificarCalleCaseta( String nombreCaseta, String nuevaCalle) throws FeriaException{
		
	}
}
