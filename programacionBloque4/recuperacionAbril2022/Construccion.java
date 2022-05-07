package recuperacionAbril2022;

public class Construccion {

	public static final double COEFICIENTE_ENERGETICO_A = 0.1;
	public static final double COEFICIENTE_ENERGETICO_B = 0.2;
	public static final double COEFICIENTE_ENERGETICO_C = 0.3;
	public static final double COEFICIENTE_ENERGETICO_D = 0.4;
	public static final double COEFICIENTE_ENERGETICO_E = 0.5;
	
	private static int referenciaCatastral;
	private String direccion;
	private double eficienciaEnergetica;
	
	public Construccion(int referenciaCatastral, String direccion, double eficienciaEnergetica) throws ConstruccionException {
		referenciaCatastral++;
		this.direccion = direccion;
		setEficienciaEnergetica(eficienciaEnergetica);
	}
	
	public int getReferenciaCatastral() {
		return referenciaCatastral;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getEficienciaEnergetica() {
		return eficienciaEnergetica;
	}
	public void setEficienciaEnergetica(double eficienciaEnergetica) throws ConstruccionException {
		if (eficienciaEnergetica < COEFICIENTE_ENERGETICO_A || eficienciaEnergetica > COEFICIENTE_ENERGETICO_E) {
			throw new ConstruccionException("ERROR,...");
		}
		this.eficienciaEnergetica = eficienciaEnergetica;
	}
	
}
