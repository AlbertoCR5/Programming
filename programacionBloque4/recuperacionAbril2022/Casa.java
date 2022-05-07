package recuperacionAbril2022;

public class Casa extends Vivienda implements Habitable {

	private static final double INCREMENTO_FACTURA_PISCINA = 0.2;
	private int numeroPlantas;
	private int metrosCuadradosJardin;
	private boolean piscina;
	
	public Casa(int referenciaCatastral, String direccion, double eficienciaEnergetica, int metrosCuadrados,
			int numeroHabiaciones, int numeroBannos, int plazasGaraje, boolean esOcupada, boolean esHabitable,
			Persona persona, int numeroPlantas, int metrosCuadradosJardin, boolean piscina) throws ConstruccionException {
		super(referenciaCatastral, direccion, eficienciaEnergetica, metrosCuadrados, numeroHabiaciones, numeroBannos,
				plazasGaraje, esOcupada, esHabitable, persona);
		
		setNumeroPlantas(numeroPlantas);
		setMetrosCuadradosJardin(metrosCuadradosJardin);
		this.piscina = piscina;		
	}

	public int getNumeroPlantas() {
		return numeroPlantas;
	}

	public void setNumeroPlantas(int numeroPlantas) throws ConstruccionException {
		if (numeroPlantas < 1 || numeroPlantas > 2) {
			throw new ConstruccionException("ERROR");
		}
		this.numeroPlantas = numeroPlantas;
	}

	public int getMetrosCuadradosJardin() {
		return metrosCuadradosJardin;
	}

	public void setMetrosCuadradosJardin(int metrosCuadradosJardin) throws ConstruccionException {
		if (metrosCuadradosJardin < 0) {
			throw new ConstruccionException("ERROR");
		}
		this.metrosCuadradosJardin = metrosCuadradosJardin;
	}

	public boolean isPiscina() {
		return piscina;
	}

	@Override
	public double facturaAgua(double facturaAgua) throws ConstruccionException {
		facturaAgua = facturaAgua * getNumeroBannos() * getMetrosCuadradosJardin() / 100;
		if (isPiscina()) {
			facturaAgua = facturaAgua + facturaAgua * INCREMENTO_FACTURA_PISCINA;
		}
		return facturaAgua;
		
	}

	@Override
	public double facturaLuz(double facturaLuz) throws ConstruccionException {
		return facturaLuz = facturaLuz * getNumeroBannos() * getEficienciaEnergetica();
		
	}

	@Override
	public double impuestos() {
		
		double impuestos = getMetrosCuadrados() * getPlazasGarage() * numeroPlantas / (metrosCuadradosJardin / 100);
		
		if (piscina) {
			impuestos = impuestos + impuestos * INCREMENTO_FACTURA_PISCINA;
		}
		return impuestos;
		
	}




}
