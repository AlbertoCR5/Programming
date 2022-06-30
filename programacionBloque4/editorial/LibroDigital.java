package ejercicio1;

public class LibroDigital extends Libro{
	
	
	private static final int VALORACION_MAXIMA = 10;
	private static final int VALORACION_MINIMA = 0;
	private Formato formato;
	private int sumaOpiniones;
	private int totalOpiniones;
	
	
	public LibroDigital(String titulo, String autor, Editorial editorial, int anno, int precio, Formato formato) throws LibroException {
		
		super(titulo, autor, editorial, anno, precio);
		comprobarAntiguedad(anno);
		
		this.formato=formato;
		this.totalOpiniones=0;
		this.sumaOpiniones=0;
		
	}
	
	public LibroDigital(String titulo, String autor, Editorial editorial, int anno, int precio) throws LibroException {
		
		super(titulo, autor, editorial, anno, precio);
		comprobarAntiguedad(anno);
			
		this.formato=Formato.EPUB;
		this.totalOpiniones=0;
		this.sumaOpiniones=0;
		
	}

	private void comprobarAntiguedad(int anno) throws LibroException {
		int antiguedad=Libro.ANNO_ACTUAL - anno;
		if (antiguedad <=1)
			throw new LibroException("No se comercializa libros electrónicos con menos de un año de antiguedad");
	}
	
	


	
	public Formato getFormato() {
		return formato;
	}


   @Override
	public void setPrecio(int nuevoPrecio) throws  LibroException{
		
		if (nuevoPrecio >   getEditorial().getMaximoPrecioLibrosDigitales()) {
			throw new LibroException("El precio no puede superar el admitido por la editorial que es" + getEditorial().getMaximoPrecioLibrosDigitales() );
		}
		if (nuevoPrecio > getPrecio()) {
			throw new LibroException("No se subir el precio un libro electrónico");
		}
		
		super.setPrecio(nuevoPrecio);
		
	}
	
	//Metodo para valorar
	public void  valorar(int valoracion) throws LibroException{
		
		
		
		if (valoracion < VALORACION_MINIMA || valoracion > VALORACION_MAXIMA) {
			throw new LibroException("Valoracion fuera de rango, no debe ser mayor a " + VALORACION_MAXIMA + " ni menor a " + VALORACION_MINIMA);
		}
		
		sumaOpiniones=sumaOpiniones + valoracion;
		totalOpiniones++;
		
		
	}
	
	//Sobreescribir el toString
	public String toString() {
		String info;
		if (totalOpiniones!=0)
			info=super.toString() + " FORMATO " + formato + " MEDIA OPINIONES " + sumaOpiniones/totalOpiniones;
		else
			info=super.toString() + " FORMATO " + formato + " SIN OPINIONES " ;
		return info;
	}
	
	
	//Para que ordene por título
	@Override
	public int compareTo(Libro otro) {
		
		return this.getTitulo().compareTo(otro.getTitulo());
	}
}


