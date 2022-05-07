package recuperacionAbril2022;

public class Edificio extends Construccion{
	
	private int numeroPlantas;
	private int ascensores;

	public Edificio(int referenciaCatastral, String direccion, double eficienciaEnergetica, int numeroPlantas, int ascensores) throws ConstruccionException {
		super(referenciaCatastral, direccion, eficienciaEnergetica);
		setNumeroPlantas(numeroPlantas);
		setAscensores(ascensores);
	}

	public int getNumeroPlantas() {
		return numeroPlantas;
	}

	public void setNumeroPlantas(int numeroPlantas) throws ConstruccionException {
		if (numeroPlantas < 1) {
			throw new ConstruccionException("Error,...");
		}
		this.numeroPlantas = numeroPlantas;
	}

	public int getAscenores() {
		return ascensores;
	}

	public void setAscensores(int ascensores) throws ConstruccionException {
		if (numeroPlantas > 1 && ascensores <= 0) {
			throw new ConstruccionException("Error,...");
		}
		else {
			if (ascensores < 0) {
				throw new ConstruccionException("Error,...");
			}
		}
		this.ascensores = ascensores;
	}

}
