package Ejercicio03ProductoCategoria;

public class Categoria {

	public static final int IVA_MAXIMO = 25;
	public static final int LONGITUD_MINIMA = 2;
	public static final int IVA_SUPERREDUCIDO = 4;
	public static final int IVA_REDUCIDO = 10;
	public static final int IVA_GENERAL = 21;
	
	private String nombre;
	private int IVA;
	
	public Categoria(String nombre, int IVA) throws MarketException {
		
		setNombre(nombre);
		setIVA(IVA);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws MarketException {
		
		if (nombre.length() < LONGITUD_MINIMA) {
			throw new MarketException("La categoria debe tener al menos un minimo de " + LONGITUD_MINIMA + " letras");
		}
		this.nombre = nombre;
	}

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int IVA) throws MarketException {
		
		if (IVA < Producto.PRECIO_MINIMO || IVA > IVA_MAXIMO) {
			throw new MarketException("El IVA debe de tener un valor comprendido entre 0 y " + IVA_MAXIMO);
		}
		this.IVA = IVA;
	}

	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", IVA=" + IVA + "]";
	}
	
	
}