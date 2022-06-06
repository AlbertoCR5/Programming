
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
		return null;
	}
	
	//TODO
	public void borrarCasetaDeUnaCalle(String calle, String nombreCaseta) throws FeriaException{
		
	}
	
	//TODO
	public void modificarCalleCaseta( String nombreCaseta, String nuevaCalle) throws FeriaException{
		
	}
}
