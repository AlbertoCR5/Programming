package Examen21FebreroEj01;

public class Libro {
	
	private static final int PRECIO_MAXIMO_LIBRO = 300;
	private static final double DIFERENCIA_PUNTUACION = 1.5;
	private static final int PUNTUACION_MAXIMA = 10;
	private static final int VALOR_MINIMO = 0;
	private static final int CANTIDAD_FIJA_EJEMPLARES = 500;
	private static final int IVA = 21;
	private static final String AUTOR_DESCONOCIDO = "Anonimo";
	
	private String titulo;
	private String autor;
	private Tematica tematica;
	private int ejemplares;
	private int puntuacion;
	private int ejemplaresVendidos;
	private int sumaOpiniones;
	private int precio;
	private double mediaOpiniones;
	private double precioBase;
	private static double totalFacturado;	
	private static int totalOpiniones;

	
	public Libro(String titulo, Tematica tematica, double precioBase) throws LibreriaException {

		setTitulo(titulo);
		this.autor = AUTOR_DESCONOCIDO;
		this.tematica =tematica;
		this.ejemplares = CANTIDAD_FIJA_EJEMPLARES;
		darNota(puntuacion);
		setPrecioBase(precioBase);
		this.sumaOpiniones = 0;
		this.ejemplaresVendidos = 0;
		venderUnEjemplar();

	}

	public Libro(String titulo, String autor, Tematica tematica, double precioBase) throws LibreriaException {

		setTitulo(titulo);
		this.autor = autor;
		this.tematica =tematica;
		this.ejemplares = CANTIDAD_FIJA_EJEMPLARES;
		darNota(puntuacion);
		setPrecioBase(precioBase);
		this.sumaOpiniones = 0;
		this.ejemplaresVendidos = 0;;
		venderUnEjemplar();
	}

	public String getTitulo() {
		return titulo;
	}

	
	public String getAutor() {
		return autor;
	}


	public Tematica getTematica() {
		return tematica;
	}

	
	public int getEjemplares() {
		return ejemplares;
	}

	public double getPrecioBase() {
		return precioBase;
	}


	public double getMediaOpiniones() {
		return mediaOpiniones;
	}

	public int getTotalOpiniones() {
		return totalOpiniones;
	}

	public int getEjemplaresVendidos() {
		return ejemplaresVendidos;
	}


	public void setPrecioBase(double precioBase) throws LibreriaException {
		
		if(precioBase <= VALOR_MINIMO || precioBase > PRECIO_MAXIMO_LIBRO) {
			throw new LibreriaException("ERROR, el precio base de un libro no puede ser 0 o negativo, o mayor de 300 €");
		}
		this.precioBase = precioBase;
	}


	public void setTitulo(String titulo) throws LibreriaException {
		
		if (titulo.length() < 1) {
			throw new LibreriaException("ERROR, el libro debe contener algun titulo");
		}
		this.titulo = titulo;
	}


	public void darNota(int puntuacion) throws LibreriaException {
		
		if(puntuacion < VALOR_MINIMO || puntuacion > PUNTUACION_MAXIMA) {
			throw new LibreriaException("ERROR, puntuacion fuera de rango");
		}
		
		totalOpiniones = getTotalOpiniones() + 1;
		mediaOpiniones = (sumaOpiniones + puntuacion) / totalOpiniones;
		
		this.puntuacion = puntuacion;
	}

	public void incrementarEjemplares ( int cantidadEjemplares) throws LibreriaException {
		if ( cantidadEjemplares <=0)
			throw new LibreriaException("Cantidad de ejemplares a incrementar incorrecta");
		
		ejemplares=ejemplares + cantidadEjemplares;
	}

	@Override
	public String toString() {
		
		return "Titulo: " + titulo + ", autor: " + autor + ", tematica: " + tematica.getNombre() + ", ejemplares: " + ejemplares + " tiene un preciofinal del " + precio;
	}
	
	public double venderUnEjemplar() throws LibreriaException {

		if(ejemplares <= VALOR_MINIMO){
			throw new LibreriaException("Lo sentimos, no quedan existencias de ete libro");
		}
		
		double precio = tematica.getPorcentajeBeneficio();
		
		precio = precio + (precio * tematica.getPorcentajeBeneficio() / 100);
		precio = precio + (precio * IVA) / 100;
		totalFacturado = totalFacturado + precio;
		ejemplares--;
		ejemplaresVendidos++;
				
		return precio;
	}
	
	public boolean esAfin(Libro otro) {
		
		boolean esAfin;
		int diferenciaPuntuacion = 0;
		
		if (this.puntuacion < otro.puntuacion) {
			diferenciaPuntuacion = otro.puntuacion - this.puntuacion;
		}
		else {
			diferenciaPuntuacion = this.puntuacion - otro.puntuacion;
		}
		
		if (this.tematica.equals(otro.tematica) && diferenciaPuntuacion <= DIFERENCIA_PUNTUACION) {
			esAfin = true;
		}
		else {
			esAfin = false;
		}
		
		return esAfin;
	}
	
}
