package Parking;

public class Categoria {

	public static final double MAXIMO_PRECIO_POR_MINUTO = 0.08;
	private String nombreCategoria;
	private double precioPorMinuto;
	
	public Categoria(String nombreCategoria, double precioPorMinuto) throws ParkingException {
		this.nombreCategoria = nombreCategoria;
		setPrecioPorMinuto(precioPorMinuto);
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public double getPrecioPorMinuto() {
		return precioPorMinuto;
	}
	public void setPrecioPorMinuto(double precioPorMinuto) throws ParkingException {
		if ( precioPorMinuto <= 0 || precioPorMinuto> MAXIMO_PRECIO_POR_MINUTO) {
			throw new ParkingException("El precio por minuto no puede ser negativo ni mayor a " + MAXIMO_PRECIO_POR_MINUTO);
		}
		this.precioPorMinuto = precioPorMinuto;
	}
	@Override
	public String toString() {
		return nombreCategoria + ", Precio por minuto" + precioPorMinuto ;
	}
	
	
}
