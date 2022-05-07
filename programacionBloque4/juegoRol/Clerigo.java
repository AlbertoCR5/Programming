package juegoRol;

public class Clerigo extends Personaje{
	private String dios;
	/**
	 * Fuerza minima
	 */
	public static final int  FUERZA_MIN_CLERIGO=18;
	
	/**
	 * Inteligencia m�xima para un cl�rigo
	 */
	public static final int INTELIGENCIA_MAX_CLERIGO=16;
	/**
	 * Inteligencia minima
	 */
	public static final int INTELIGENCIA_MIN_CLERIGO=12;
	/**
	 * cantidad que de puntos que recibe un personaje al curarse
	 */
	public static final int PUNTOS_POR_CURADO=10;
	
	public Clerigo(String nombre, TipoRaza raza, int fuerza, int inteligencia,
			int vidaMaxima,String dios) throws PersonajeException {
		
			super(nombre, raza, fuerza, inteligencia, vidaMaxima);
			setDios(dios);
	}
	
	
	/**
	 * Modifica la inteligenicia del Clerigo, controlando que est� en el rango adecuado. Si no lo estuviese
	 * lanzar�a la excepci�n
	 * @param inteligencia Nueva inteligencia
	 */
	public void setInteligencia(int inteligencia) throws PersonajeException{
		if (inteligencia<INTELIGENCIA_MIN_CLERIGO || inteligencia >INTELIGENCIA_MAX_CLERIGO){
			throw new PersonajeException("El clérigo no puede tener menos de "+ INTELIGENCIA_MIN_CLERIGO +"  de inteligencia ni m�s de " + INTELIGENCIA_MAX_CLERIGO);
		}
	
		super.setInteligencia(inteligencia);
	}
	
	/**
	 * Modifica la fuerza del Clerigo, controlando que est� en el rango adecuado. Si no lo estuviese lanzar�a la
	 * excepci�n
	 * @param fuerza Nueva fuerza
	 */
	public void setFuerza(int fuerza) throws PersonajeException{
		if (fuerza<FUERZA_MIN_CLERIGO){
			throw new PersonajeException("El clérigo no puede tener una fuerza menor que " + FUERZA_MIN_CLERIGO);
		}
		super.setFuerza(fuerza);
	}

	public String getDios() {
		return dios;
	}

	public void setDios(String dios) {
		this.dios = dios;
	}
	
	
	/**
	 * M�todo para curar a un personaje. Curar a un personaje le aumenta la vida en CANTCURAR puntos. Si al
	 * curar se superase la vida m�xima se le dar� la vida m�xima.
	 *  Se considera que no puede curarse a un personaje con vida 0, por lo que en 
	 * este caso se lanzar� la excepci�n
	 * @param otro Personaje que se va a curar
	 * @throws PersonajeException
	 */
	public void curar(Personaje otro) throws PersonajeException{
		
		if ( this.equals(otro))
			throw new PersonajeException("No se puede curar a si mismo");

		
		otro.setVidaActual(otro.getVidaActual()+PUNTOS_POR_CURADO); // si no se cura
	}

	
	
	@Override
	public String toString() {
		String cadena;
		
		cadena="Clerigo " + super.toString() + " Dios: " + dios;
		return cadena;
	}

}
