package alojamiento;

//9.Hotel y CasaRural que heredan de Alojamiento.
public class CasaRural  extends Alojamiento{

	private static final int MINIMO_HUESPEDES = 2;
	public static final int PRECIO_BAJA = 15;
	public static final int PRECIO_MEDIA = 20;
	public static final int PRECIO_ALTA = 26;
	
	private int numeroHuespedes;
	Categoria categoria;//Atributo Tipo Enum ( ALTA, MEDIA y BAJA)
	boolean jacuzzi;//Atributo Boolean (true o false)
	//1.Todos los alojamientos tienen un nombre y un precio por persona y noche--> Hotel y CasaRural too
	//3.De las casas rurales se debe almacenar las personas que admite ,la categoría ( ALTA, MEDIA y BAJA) y si tiene o no jacuzzi
	//4.Si al crearse no se indica nada en categoría debe suponerse que la categoría es media.-->NO LO METO EN CONSTRUCTOR v
	public CasaRural(String nombre, String localidad, int precioPersonaNoche, int numeroHuespedes, boolean jacuzzi) throws AlojamientoException {
		super(nombre, localidad, precioPersonaNoche);
		setNumeroHuespedes(numeroHuespedes);
		this.categoria = Categoria.MEDIA; //4BIS <--LO METO AQUI 
		setPrecioPersonaNoche(precioPersonaNoche);
		this.jacuzzi = jacuzzi;
	}
	//1. Todos los alojamientos tienen un nombre y un precio por persona y noche--> Hotel y CasaRural too
	//3.De las casas rurales se debe almacenar las personas que admite ,la categoría ( ALTA, MEDIA y BAJA) y si tiene o no jacuzzi
	public CasaRural(String nombre, String localidad, int precioPersonaNoche, int numeroHuespedes, Categoria categoria, boolean jacuzzi) throws AlojamientoException {
		super(nombre, localidad, precioPersonaNoche);
		setNumeroHuespedes(numeroHuespedes);
		setCategoria(categoria);	
		setPrecioPersonaNoche(precioPersonaNoche);
		this.jacuzzi = jacuzzi;

	}

	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	public void setNumeroHuespedes(int numeroHuespedes) throws AlojamientoException {
		
		if (numeroHuespedes < MINIMO_HUESPEDES) {
			throw new AlojamientoException("ERROR, la cantidad minima de huespedes que debe admitir la casa es 2, " + numeroHuespedes);
		}
		this.numeroHuespedes = numeroHuespedes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) throws AlojamientoException {//PIJADA, se puede obviar
		
		boolean esCategoria = false;
		
		for (int i = 0; i < Categoria.values().length && !esCategoria; i++) {
			if(categoria.equals(Categoria.values()[i])) {
				esCategoria = true;
			}
		}
		if (!esCategoria) {
			throw new AlojamientoException("ERROR, La Categoria indicada no esta disponible");
		}
		
		this.categoria = categoria;
	}

	public boolean isJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	@Override
	public String toString() {
		
		String info = "CasaRural " + super.toString() + " CATEGORIA " + categoria;
		
		if (jacuzzi) {
			info = info + " CON JACUZZI";
		}
		else {
			info = info + " SIN JACUZZI";
		}
		
		return info;
	}
	//7.el precio no suba ni baje por encima de un 15% sobre el precio inicial del alojamiento(CONSTANTES) -->VER CATEGORIA
	protected void setPrecioPersonaNoche(int precioPersonaNoche) throws AlojamientoException {
		
		if(precioPersonaNoche < categoria.getPrecioCasaRural()) {
			throw new AlojamientoException("ERROR, El precio por persona noche nop puede sewr inferior a " + categoria.getPrecioCasaRural());
		}
		super.setPrecioPersonaNoche(precioPersonaNoche);
	}
	
}
