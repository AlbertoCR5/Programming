package Relacion8Ejercicio01Refranes;

public class Refran implements Comparable<Refran> {

	private static final int POPULARIDAD_MINIMA = 0;
	private static final int POPULARIDAD_MAXIMA = 100;
	
	private String refran;
	private int popularidad;

	
	public Refran(String refran, int popularidad) throws RefranException {

		this.refran = refran;
		setPopularidad(popularidad);
	}

	public String getRefran() {
		return refran;
	}

	public void setRefran(String refran) {
		this.refran = refran;
	}

	public int getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(int popularidad) throws RefranException {
		
		if (popularidad > POPULARIDAD_MAXIMA || popularidad < POPULARIDAD_MINIMA) {
			throw new RefranException("Popularidad fuera de rango indicado (" + POPULARIDAD_MINIMA + "-" + POPULARIDAD_MAXIMA + ")");
		}
		this.popularidad = popularidad;
	}
	
	@Override
	public String toString() {
		return "Refran: " + refran + " (" + popularidad + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + popularidad;
		result = prime * result + ((refran == null) ? 0 : refran.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refran other = (Refran) obj;
		if (popularidad != other.popularidad)
			return false;
		if (refran == null) {
			if (other.refran != null)
				return false;
		} else if (!refran.equals(other.refran))
			return false;
		return true;
	}

	@Override
	public int compareTo(Refran otro) {
		
//		int resultado;
//		if(this.popularidad == otro.getPopularidad())
//			resultado = 0;
//		else if (this.popularidad < otro.getPopularidad())
//			resultado = -1;
//		else
//			resultado = 1;
		// Ordenado por popularidad	
		return Integer.compare(otro.popularidad, this.popularidad);
	}
	
}
