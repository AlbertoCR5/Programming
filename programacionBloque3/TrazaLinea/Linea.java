package TrazaLinea;

public class Linea {

	Punto puntoA, puntoB;

	public Linea(Punto puntoA, Punto puntoB) throws TrazaLineaException {
		
		if(puntoA.equals(puntoB)) {
			throw new TrazaLineaException("Los puntos deben ser diferentes para poder trazar una linea");
		}
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}

	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}

	@Override
	public String toString() {
		return "[(" + puntoA.getX() + "," + puntoA.getY() + "),(" + puntoB.getX() + "," + puntoB.getY() +")]";
	}
	
	public void moverDerecha(double movimiento) throws TrazaLineaException {

		if (movimiento <= 0) {
			throw new TrazaLineaException("Error, el movimiento no puede ser nulo o negativo");
		}
		
		puntoA.setX(puntoA.getX() + movimiento);
		puntoB.setX(puntoB.getX() + movimiento);

	}
	
	public void moverIzquierda(double movimiento) throws TrazaLineaException {

		if (movimiento <= 0) {
			throw new TrazaLineaException("Error, el movimiento no puede ser nulo o negativo");
		}
		
		puntoA.setX(puntoA.getX() - movimiento);
		puntoB.setX(puntoB.getX() - movimiento);
		
	}
	
	public void moverArriba(double movimiento) throws TrazaLineaException {
		
		if (movimiento <= 0) {
			throw new TrazaLineaException("Error, el movimiento no puede ser nulo o negativo");
		}
		
		puntoA.setY(puntoA.getY() + movimiento);
		puntoB.setY(puntoB.getY() + movimiento);
		
	}

	public void moverAbajo(double movimiento) throws TrazaLineaException {

		if (movimiento <= 0) {
			throw new TrazaLineaException("Error, el movimiento no puede ser nulo o negativo");
		}
		
		puntoA.setY(puntoA.getX() - movimiento);
		puntoB.setY(puntoB.getX() - movimiento);
		
	}	
}
