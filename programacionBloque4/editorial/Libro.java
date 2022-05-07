package editorial;

import java.util.Calendar;

public class Libro {
	public static final int ANNO_ACTUAL=Calendar.getInstance().get(Calendar.YEAR);
	private String titulo;
	private String autor;
	
	private Editorial editorial;
	private int anno;
	private int precio;
	
	public Libro(String titulo, String autor, Editorial editorial, int anno, int precio) throws LibroException {

		if ( anno <= 0 || anno> ANNO_ACTUAL ) {
			throw new LibroException("Año incorrecto");
		}
		
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anno = anno;
		setPrecio(precio);
	}
	
	public void setPrecio( int precio) throws LibroException {
		if ( precio <= 0) {
			throw new LibroException("Precio incorrecto");
		}
		this.precio=precio;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public int getAnno() {
		return anno;
	}

	public int getPrecio() {
		return precio;
	}

	public String toString() {		
		String cadena;
		cadena= "TITULO " +  titulo + " AUTOR " +  autor + " EDITORIAL " +  editorial + " PRECIO " +  precio;
		return cadena;
	}
	
	
	
}
