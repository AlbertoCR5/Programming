package Market;

public class Producto {

	private int codigoProducto = 1;
	private String descripcion;
	Categoria categoria;
	private double precionSinIVA;
	public Producto(String descripcion, Categoria categoria, double precionSinIVA) throws MarketExcepetion {
		
		setDescripcion(descripcion);
		this.categoria = categoria;
		setPrecionSinIVA(precionSinIVA);
		codigoProducto++;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) throws MarketExcepetion {
		
		if(descripcion.length() < 3) {
			throw new MarketExcepetion("ERROR, Descripcion incorrecta");
		}
		this.descripcion = descripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public double getPrecionSinIVA() {
		return precionSinIVA;
	}
	public void setPrecionSinIVA(double precionSinIVA) throws MarketExcepetion {
		if (precionSinIVA <= 0) {
			throw new MarketExcepetion("ERROR, no se le puede dar un valor nulo o negativo a un producto");
		}
		this.precionSinIVA = precionSinIVA;
	}
	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", descripcion=" + descripcion + ", categoria="
				+ categoria.getNombreCategoria()+ "] tiene un precio de " + calculoPrecioConIVA() + " con IVA";
	}
	
	public double calculoPrecioConIVA() {
		
		double precioConIVA;
		
		precioConIVA = precionSinIVA + (precionSinIVA * categoria.getIVA()/100);
		
		return precioConIVA;		
	}
	
}
