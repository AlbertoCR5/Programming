package alojamiento;

//9.Hotel y CasaRural que heredan de Alojamiento.
public class Hotel extends Alojamiento {

	private static final int MAXIMO_ESTRELLAS = 5;
	private static final int MINIMO_ESTRELLAS = 3;
	private static final int BAREMO_PRECIO = 15;
	
	private int estrellas;//2. Atributo del hotel
	//1. Todos los alojamientos tienen un nombre y un precio por persona y noche--> Hotel y CasaRural too
	//2.De los hoteles se almacena el número de estrellas que tiene (de 3 a 5)-->(CONSTANTES).
	public Hotel(String nombre, String localidad, int precioPersonaNoche, int estrellas) throws AlojamientoException {
		super(nombre, localidad, precioPersonaNoche);
		setPrecioPersonaNoche(precioPersonaNoche);
		setEstrellas(estrellas);//compruebo que sea de 3 a 5 estrellas
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) throws AlojamientoException {
		
		if (estrellas < MINIMO_ESTRELLAS || estrellas > MAXIMO_ESTRELLAS) {
			throw new AlojamientoException("ERROR, El hotel tiene " + estrellas + ", pero debe tener de 3 a 5*");
		}
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Hotel " + super.toString() + " ESTRELLAS: " + estrellas;
	}
	//6.el precio no suba ni baje por encima de un 15%(CONSTANTE) sobre el precio inicial del alojamiento
	public void setPrecioPersonaNoche(int precioPersonaNoche) throws AlojamientoException {
		
		double precioNegativo = precioPersonaNoche - precioPersonaNoche * BAREMO_PRECIO / 100;
		double precioPositivo = precioPersonaNoche + precioPersonaNoche * BAREMO_PRECIO / 100;
		
		if (precioPersonaNoche < precioNegativo || precioPersonaNoche > precioPositivo) {
			throw new AlojamientoException("ERROR, El precion indicado " + precioPersonaNoche + ", es inferior o superior al 15% estimado");
		}
		
		super.setPrecioPersonaNoche(precioPersonaNoche);
	}

}
