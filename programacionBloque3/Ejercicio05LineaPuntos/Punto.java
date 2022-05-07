package Ejercicio05LineaPuntos;

public class Punto {

	private double latitud, longitud;

	public Punto(double latitud, double longitud) {
		
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Punto [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
	public boolean equals(Punto otro) {
		
		boolean esIgual = false;
		
		if (this.latitud == otro.latitud || this.longitud == otro.longitud) {
			esIgual = true;
		}
		
		return esIgual;
		
	}
	
}
