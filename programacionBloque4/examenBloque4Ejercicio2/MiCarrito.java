package examenBloque4Ejercicio2;

public class MiCarrito {

	private static final int CAPACIDAD_CARRITO = 10;
	private LineaCarrito[] detalleCarrito;

	public MiCarrito() {
		detalleCarrito = new LineaCarrito[CAPACIDAD_CARRITO];
	}

	/*
	 * Annade al carro una unidad de ese producto. Si ya existe ese producto en el
	 * carro, sumará uno al número de unidades.
	 */
	public void annadirAlCarroUnaUnidadDelProducto(Producto producto) throws Exception {

		boolean productoExistente = false;
		boolean productoAnnadido = false;

		// Se comprueba si el producto existe; de ser el caso, se agrega 1 a su cantidad
		for (int i = 0; i < detalleCarrito.length && !productoExistente; i++) {
			if (detalleCarrito[i] != null) {
				if (detalleCarrito[i].getProducto().equals(producto)) {
					detalleCarrito[i].setCantidad(detalleCarrito[i].getCantidad() + 1);
					productoExistente = true;
				}
			}
		}

		// Si el producto no existe, se añade al array con cantidad 1
		if (!productoExistente) {
			for (int i = 0; i < detalleCarrito.length && !productoAnnadido; i++) {
				if (detalleCarrito[i] == null) { //Busco el primer null para añadirlo
					detalleCarrito[i] = new LineaCarrito(producto, 1);
					productoAnnadido = true;
				}
			}
		}

		// Excepción en caso de que no haya huecos en el array
		if (!productoAnnadido) {
			throw new Exception("No hay espacio para más productos");
		}

	}

	/**
	 * Devuelve el precio total del carro de la compra
	 * 
	 * @return
	 */
	public double precioTotalCarro() {

		double totalCarro = 0;

		for (int i = 0; i < detalleCarrito.length; i++) {
			if (detalleCarrito[i] != null) {
				totalCarro = totalCarro
						+ (detalleCarrito[i].getProducto().getPrecio() * detalleCarrito[i].getCantidad());
			}
		}

		return totalCarro;

	}

	/**
	 * Elimina del carro todos los productos con ese nombre
	 * 
	 * @param nombreDelProducto
	 */

	public void eliminarDelCarro(String nombreDelProducto) {

		for (int i = 0; i < detalleCarrito.length; i++) {
			if (detalleCarrito[i] != null) {
				if (detalleCarrito[i].getProducto().getNombre().equals(nombreDelProducto)) {
					detalleCarrito[i] = null;
				}
			}

		}
	}
}