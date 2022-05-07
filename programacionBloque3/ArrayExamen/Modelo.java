package ArrayExamen;

public class Modelo {

	private String nombreModelo;
	private int precio;
	private int plazas;
	private boolean electrico;
	
	public Modelo(String nombreModelo, int precio, int plazas,boolean electrico) {
		super();
		this.nombreModelo = nombreModelo;
		this.precio = precio;
		this.plazas = plazas;
		this.electrico=electrico;
	}
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	public boolean isElectrico() {
		return electrico;
	}
	
	@Override
	public String toString() {
		return "ModeloCoche [nombreModelo=" + nombreModelo + ", precio=" + precio + ", plazas=" + plazas + " Electrico " + electrico;
	}
	
	
}
