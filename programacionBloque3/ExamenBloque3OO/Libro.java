package ExamenBloque3OO;


public class Libro {
	
	private String titulo;
	private String autor;
	private Tematica tematica;
	private int ejemplares;
	private double precioBase;
	private int sumaOpiniones;
	private int totalOpiniones;
	
	
	
	
	
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

	public void incrementarEjemplares ( int cantidadEjemplares) throws LibreriaException {
		if ( cantidadEjemplares <=0)
			throw new LibreriaException("Cantidad de ejemplares a incrementar incorrecta");
		
		ejemplares=ejemplares + cantidadEjemplares;
	}




	@Override
	public String toString() {
		
		return "Titulo: " + titulo + ", autor: " + autor + ", tematica: " + tematica.getNombre() + ", ejemplares: " + ejemplares;
	}
	
	
	

}
