package examenBloque4Ejercicio2;

public class LineaCarrito {

	private Producto producto;
	private int cantidad;

	public LineaCarrito(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Linea [producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}