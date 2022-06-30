package ejercicio1;

public enum Editorial {
	ALFAGUARA(Libro.PRECIO_MAXIMO_ALFAGUARA), ALIANZA(Libro.PRECIO_MAXIMO_ALIANZA), ANAGRAMA(Libro.PRECIO_MAXIMO_ANAGRAMA);
	
	private double maximoPrecioLibrosDigitales;
	
	private Editorial(double maximoPrecioLibrosDigitales) {
		this.maximoPrecioLibrosDigitales=maximoPrecioLibrosDigitales;
	}
	
	public double getMaximoPrecioLibrosDigitales() {
		return maximoPrecioLibrosDigitales;
	}
}
