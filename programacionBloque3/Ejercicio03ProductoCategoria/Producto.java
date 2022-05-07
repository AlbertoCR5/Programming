package Ejercicio03ProductoCategoria;

public class Producto {

	public static final int PRECIO_MINIMO = 0;
	public static final int CODIGO_MINIMO = 10000000;
	
	private int codigo;
	private double precioSinIVA;
	private String descripcion;
	private Categoria categoria;
	private static int generaCodigo = CODIGO_MINIMO;
	
	public Producto(double precioSinIVA, String descripcion, Categoria categoria) throws MarketException {
		
		setPrecioSinIVA(precioSinIVA);
		setDescripcion(descripcion);
		this.categoria = categoria;
		this.codigo = generaCodigo++;
	}

	public double getPrecioSinIVA() {
		return precioSinIVA;
	}

	public void setPrecioSinIVA(double precioSinIVA) throws MarketException {
		
		if (precioSinIVA <= PRECIO_MINIMO) {
			throw new MarketException("El Precio del producto debe tener un valor mayor a " + PRECIO_MINIMO);
		}
		this.precioSinIVA = precioSinIVA;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws MarketException {
		
		if (descripcion.length() <= 3) {
			throw  new MarketException("El producto debe tener una descripcion");
		}
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", precioSinIVA=" + precioSinIVA + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + "]";
	}
	
	public double precioConIVA() {
		
		double precioConIVA;
		
		precioConIVA = precioSinIVA + (precioSinIVA * categoria.getIVA()/100);
		
		return precioConIVA;
		
	}
	
}