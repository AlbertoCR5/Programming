package Ejercicio05LineaPuntos;

public class Linea {
	
	final int VALOR_MINIMO = 0;
	final double DISTANCIA = 111.195;
	
	private Punto puntoOriginal, puntoDestino;

	public Linea(Punto puntoOriginal, Punto puntoDestino) throws CoordenadaException {
		
		if (puntoOriginal.equals(puntoDestino)) {
			throw new CoordenadaException("No se puede trazar una linea si latitud y longitud son iguales");
		}
		this.puntoOriginal = puntoOriginal;
		this.puntoDestino = puntoDestino;
	}

	public Punto getPuntoOriginal() {
		return puntoOriginal;
	}

	public void setPuntoOriginal(Punto puntoOriginal) {
		this.puntoOriginal = puntoOriginal;
	}

	public Punto getPuntoDestino() {
		return puntoDestino;
	}

	public void setPuntoDestino(Punto puntoDestino) {
		this.puntoDestino = puntoDestino;
	}

	@Override
	public String toString() {
		return "Linea [(" + puntoOriginal.getLatitud() + "," + puntoOriginal.getLongitud() + "),(" + puntoDestino.getLatitud() + "," + puntoDestino.getLongitud() + ")]"
				+ " y la distancia entre los dos puntos es de " + calcularDistancia() + "Km";
	}
	
	public void comprobarMovimiento(double movimiento) throws CoordenadaException {
		
		if (movimiento <= VALOR_MINIMO) {
			throw new CoordenadaException("No se puede realizar un movimiento negativo");
		}
	}
	
	public void desplazarHaciaArriba(double movimiento) throws CoordenadaException {
		
		double nuevoPuntoOrigen, nuevoPuntoDestino;
		
		this.comprobarMovimiento(movimiento);
		
		nuevoPuntoOrigen = puntoOriginal.getLongitud() + movimiento;
		puntoOriginal.setLongitud(nuevoPuntoOrigen);
		
		nuevoPuntoDestino = puntoDestino.getLongitud() + movimiento;
		puntoDestino.setLongitud(nuevoPuntoDestino);
	}
	
	public void desplazarHaciaAbajo(double movimiento) throws CoordenadaException {
		
		double nuevoPuntoOrigen, nuevoPuntoDestino;
		
		this.comprobarMovimiento(movimiento);
		
		nuevoPuntoOrigen = puntoOriginal.getLongitud() - movimiento;
		puntoOriginal.setLongitud(nuevoPuntoOrigen);
		
		nuevoPuntoDestino = puntoDestino.getLongitud() - movimiento;
		puntoDestino.setLongitud(nuevoPuntoDestino);
	}
	
	public void desplazarHaciaDerecha(double movimiento) throws CoordenadaException {
		
		double nuevoPuntoOrigen, nuevoPuntoDetino;
		
		this.comprobarMovimiento(movimiento);
		
		nuevoPuntoOrigen = puntoOriginal.getLatitud() + movimiento;
		puntoOriginal.setLatitud(nuevoPuntoOrigen);
		
		nuevoPuntoDetino = puntoDestino.getLatitud() + movimiento;
		puntoDestino.setLatitud(nuevoPuntoDetino);
	}
	
	public void desplazarHaciaIzquierda(double movimiento) throws CoordenadaException {
		
		double nuevoPuntoOrigen, nuevoPuntoDestino;
		
		this.comprobarMovimiento(movimiento);
		
		nuevoPuntoOrigen = puntoOriginal.getLatitud() - movimiento;
		puntoOriginal.setLatitud(nuevoPuntoOrigen);
		
		nuevoPuntoDestino = puntoDestino.getLatitud() - movimiento;
		puntoDestino.setLatitud(nuevoPuntoDestino);
	}
	
	public double calcularDistancia() {
		
		double distancia, distanciaLatitudes, distanciaLongitudes;
		
		distanciaLatitudes = puntoOriginal.getLatitud() - puntoDestino.getLatitud();
		distanciaLatitudes = distanciaLatitudes * distanciaLatitudes;System.out.println(distanciaLatitudes);
		
		distanciaLongitudes = puntoOriginal.getLongitud() - puntoDestino.getLongitud();
		distanciaLongitudes = distanciaLongitudes * distanciaLongitudes;System.out.println(distanciaLongitudes);
		
		distancia = Math.sqrt(distanciaLatitudes + distanciaLongitudes) * DISTANCIA;
		
		return distancia;
		
	}
	public boolean equals(Linea otro) {
		
		boolean esInvalido = false;
		
		if (this.puntoOriginal.equals(otro.puntoOriginal) && this.puntoDestino.equals(otro.puntoDestino) || this.puntoOriginal.equals(otro.puntoDestino) && this.puntoDestino.equals(otro.puntoOriginal)) {
			esInvalido = true;
		}
		
		return esInvalido;
		
	}
	
}