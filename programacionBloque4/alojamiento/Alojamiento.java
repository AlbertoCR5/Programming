package alojamiento;

//10. PARANOYA SOLO VALE 0.5 
// Realizar una interfaz Localizable. Piensa qu� m�todos debe tener para que exprese que las
//clases localizables son las que tienen una localidad y que dicha localidad puede modificarse.
//Realizar los cambios necesarios, e incluye los atributos necesarios para hacer que el
//Alojamiento sea Localizable (0,5 ptos)
//v
//v
//He a�adido localidad a los constructores y un getLocalidad al final de alojamiento

public abstract class Alojamiento implements Comparable<Alojamiento>, Localizable {//

	private String nombre;
	protected int precioPersonaNoche;//PROTECTED
	protected String localidad;//PROTECTED
	
	//1. Todos los alojamientos tienen un nombre y un precio por persona y noche--> Hotel y CasaRural too
	public Alojamiento(String nombre, String localidad, int precioPersonaNoche) throws AlojamientoException {

		this.nombre = nombre;
		this.precioPersonaNoche = precioPersonaNoche;
		this.localidad = localidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecioPersonaNoche() {
		return precioPersonaNoche;
	}
	
	//5.Los precios por persona y noche pueden variar de forma diferente en los hoteles y las casas rurales SOBREESCRITURA DE METODOS
	protected void setPrecioPersonaNoche(int precioPersonaNoche) throws AlojamientoException {
		this.precioPersonaNoche = precioPersonaNoche;
	}
	
	//8.La informaci�n de los hoteles se mostrar� as�: MODIFICAR LOS toStrings
	@Override
	public String toString() {
		return "NOMBRE: " + nombre + " LOCALIDAD: " + localidad + " PRECIO POR NOCHE: " + precioPersonaNoche;
	}
	
	@Override
	public int compareTo(Alojamiento otro) {
		
		return Integer.compare(this.precioPersonaNoche, otro.precioPersonaNoche);
	}
	
	public String getLocalidad() {
		
		return localidad;
	}
	
}
