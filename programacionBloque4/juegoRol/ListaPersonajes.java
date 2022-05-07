package juegoRol;

import java.util.Arrays;


public class ListaPersonajes {
	
	private Personaje listaPersonajes[];
	private int cantidadPersonajes;
	
	/**
	 * Se encarga de inicializar el array con la cantidad del array que se le pasa por parametro
	 * @param capacidad Entero de la capacidad de espacio en el array, es
	 * decir, el número máximo de personajes que se pueden almacenar
	 * @throws PersonajeException Al comprobar que la cantidad del espacio del array no es negativo
	 */
	public ListaPersonajes(int capacidad) throws PersonajeException {
		
		if (capacidad<=0){
			
			throw new PersonajeException("ERROR. La cantidad de la lista tiene que ser mayor que 0");
		}
		
		listaPersonajes=new Personaje[capacidad];
		cantidadPersonajes=0;
	}
	
	/**
	 * Se encarga de annadir en el array el personaje pasado por parametro
	 * @param personajeAnnadir Objeto personaje que se va annadir
	 * @throws PersonajeException Al comprobar que el personaje ya existe y tambien si no hay mas espacio en el array
	 */
	public void annadirPersonaje (Personaje personajeAnnadir) throws PersonajeException{
		
		Personaje personaje;
		
		personaje=encontrarPersonaje(personajeAnnadir.getNombre());
		
		if (personaje!=null){/* ya esta */
			
			throw new PersonajeException("ERROR. El personaje " + personajeAnnadir.getNombre().toUpperCase() + " ya existe");
		}
		
		
		if (cantidadPersonajes == listaPersonajes.length){
			throw new PersonajeException("ERROR. No se pueden crear mas personajes");
		}
		
		listaPersonajes[cantidadPersonajes]=personajeAnnadir;
		cantidadPersonajes++;
		
		
		
	}

	/**
	 * Se encarga de añadir el hechizo al objeto personaje
	 * @param nombreMago String nombre del mago que aprende el hechizo
	 * @param nombreHechizo String nombre del hechizo que va a aprender el mago
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, cuando se comprueba que si el objeto
	 * de array es un mago
	 */
	public void aprenderHechizoMago(String nombreMago, String nombreHechizo) throws PersonajeException{
		
		Personaje personajeEncontrado;
		Mago mago;
		
		personajeEncontrado=encontrarPersonaje(nombreMago);
		
		comprobarPersonajeExiste(nombreMago, personajeEncontrado);
		
		if (!(personajeEncontrado instanceof Mago)){
			
			throw new PersonajeException("ERROR. " + nombreMago.toUpperCase() + " existe pero no es un Mago");
		}
		
		mago=(Mago) personajeEncontrado;
		mago.aprenderHechizo(nombreHechizo);
	}

	/**
	 * Se encarga de buscar el nombre del mago, su hechizo y nombre del personaje
	 * @param nombreMagoAtaca String nombre del mago que ataca
	 * @param nombrePersonajeDefiende String nombre del personaje que es atacado
	 * @param nombreHechizo String del hechizo del mago que ataca
	 * @throws PersonajeException Se utiliza en el metodo comprobarPersonajeExiste, si nombreMagoAtaca
	 * es un mago y que si nombreMagoAtaca esta en la misma posicion nombrePersonajeDefiende no se ataca
	 * asi mismo comprobando la posicion en el array
	 * @throws MuerteException 
	 */
	public void lanzarHechizoPersonaje (String nombreMagoAtaca,
			String nombrePersonajeDefiende, String nombreHechizo) 
					throws PersonajeException{
		
		Personaje personajeMago, personajeHechizado;
		Mago mago;
		
		// Buscar el personaje y comprobar que es mago
		personajeMago=encontrarPersonaje(nombreMagoAtaca);
		
		comprobarPersonajeExiste(nombreMagoAtaca, personajeMago);
		
		if (!(personajeMago instanceof Mago)){
			
			throw new PersonajeException("ERROR. " + nombreMagoAtaca.toUpperCase() + " existe pero no es un Mago");
		}
		
		//Buscar el personaje que se va a hechizar
		personajeHechizado=encontrarPersonaje(nombrePersonajeDefiende);
		
		comprobarPersonajeExiste(nombrePersonajeDefiende, personajeHechizado);
	
		//Lanzar hechizo
		mago=(Mago) personajeMago;
		
		mago.lanzarHechizo(nombreHechizo,personajeHechizado);
		
	}
	
	/**
	 * Se encarga de buscar un clerigo y buscar un personaje, y el clerigo cura al personaje.
	 * @param nombreClerigo String que contiene el nombre del clerigo que va a curar
	 * @param nombrePersonaje String que contiene el nombre del personaje que se va a curar
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, si es un clerigo en la posClerigo del array y
	 * si la posClerigo y posPersonaje no son iguales para comprobar que no se cura asi mismo
	 * 
	 */
	public void curarPersonaje (String nombreClerigo, String nombrePersonaje) throws PersonajeException{
		
		Personaje personajeClerigo, personajeCurado;
		Clerigo clerigo;
		
		personajeClerigo=encontrarPersonaje(nombreClerigo);
		
		comprobarPersonajeExiste(nombreClerigo, personajeClerigo);
		
		if (!(  personajeClerigo instanceof Clerigo)){
			
			throw new PersonajeException("ERROR. " + nombreClerigo.toUpperCase() + " existe pero no es un Clerigo");
		}
		
		personajeCurado=encontrarPersonaje(nombrePersonaje);
	
		comprobarPersonajeExiste(nombrePersonaje, personajeCurado);
		
		if ( ! ( personajeCurado instanceof Mago)) {
			throw new PersonajeException("El personaje que intentas curar no es un mago");
		}
		
		clerigo=(Clerigo)personajeClerigo;
		
		clerigo.curar(personajeCurado);
	
	}
	
	/**
	 * Almacena en un String todos los personajes almacenados en el array
	 * @return String de todos los personajes creados
	 */
	public String toString (){
		
		int i;
	
		StringBuilder sb=new StringBuilder();
		
		for (i=0; i< cantidadPersonajes; i++){
			
			sb.append((i+1) + ". " + listaPersonajes[i] + "\n");
			
		}
		
		return sb.toString();
	}
	
	/**
	 * Ordena el array de personajes por el numero de vida actual
	 *  de mayor a menor y luego lo muesta en forma de String
	 * @return String del array ya ordenado
	 */
	public String mostrarListadoPuntosActuales (){
		
		// No puede ordenarse directamente el array listaPersonajes
		//porque contiene elementos a null.
				
		//Hay que crear un array auxiliar para ordenar
		int i;
		Personaje[] listaPersonajesOrdenado=new Personaje[cantidadPersonajes];
		StringBuilder sb=new StringBuilder();
		
		for (i=0; i<cantidadPersonajes; i++){
			
			listaPersonajesOrdenado[i]=listaPersonajes[i];
	
		}
		
		
		
		Arrays.sort(listaPersonajesOrdenado);
		
		for (i=0; i<listaPersonajesOrdenado.length; i++){
			
			sb.append((i+1) + ". " + listaPersonajesOrdenado[i] + "\n");
		}
	
		return sb.toString();
	
	}

	private void comprobarPersonajeExiste(String nombre, Personaje personajeEncontrado) throws PersonajeException {
		
		if (personajeEncontrado==null){
			
			throw new PersonajeException("ERROR. El personaje " + nombre.toUpperCase() + " no existe");
		}
	}
	
	/**
	 * Busca un personaje por su nombre en el array
	 * @param nombre String nombre del personaje a buscar
	 * @return null si no encuentra el personaje, y el personaje encontrado si se encuentra
	 *
	 */
	private Personaje encontrarPersonaje(String nombre)  {
		
		int i=0;
		boolean encontrado=false;
		Personaje personajeEncontrado=null;
		
		
		while (i<cantidadPersonajes && !encontrado){
			
			if (listaPersonajes[i].getNombre().equalsIgnoreCase(nombre)){
				encontrado=true;
				personajeEncontrado=listaPersonajes[i];
			}
			
			i++;
		}
		
		
		return personajeEncontrado;
	}

	public double minimo() throws PersonajeException {
		
		double minimo = listaPersonajes[0].getVidaActual();
		
		if (cantidadPersonajes == 0) {
			throw new PersonajeException("ERROR, no se puede hayar el maximo ya que no hay personajes");
		}
		
		for (int i = 0; i < cantidadPersonajes; i++) {
			
			if(listaPersonajes[i].getVidaActual() <= minimo) {
				minimo = listaPersonajes[i].getVidaActual();
			}
			
		}
		
		return minimo;
	}

	public double maximo() throws PersonajeException {

		if (cantidadPersonajes == 0) {
			throw new PersonajeException("ERROR, no se puede hayar el maximo ya que no hay personajes");
		}
		double maximo = listaPersonajes[0].getVidaActual();
		
		for (int i = 0; i < cantidadPersonajes; i++) {
			
			if(maximo <= listaPersonajes[i].getVidaActual() ) {
				maximo = listaPersonajes[i].getVidaActual();
			}
			
		}
		
		return maximo;
	}

	public double media() throws PersonajeException {

		double suma = 0;
		double media;
		
		if (cantidadPersonajes == 0) {
			throw new PersonajeException("ERROR, no se puede hayar el maximo ya que no hay personajes");
		}
		
		for (int i = 0; i < cantidadPersonajes; i++) {
			suma = listaPersonajes[i].getVidaActual();
		}
		
		media = suma / cantidadPersonajes;
		
		return media;
	}
}
