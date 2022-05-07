package Ejercicio04Jarra;

public class Jarra {
	
	static final int VALOR_MINIMO = 0;
	static final int CAPACIDAD_MINIMA = 1;
	
	int capacidadJarra, cantidadJarra;
	public static int totalAguaServida;

	public Jarra(int capacidadJarra) throws JarraException {
		
		if (capacidadJarra < CAPACIDAD_MINIMA) {
			throw new JarraException("Error, no puede haber capacidades menores a " + CAPACIDAD_MINIMA);
		}
		
		this.capacidadJarra = capacidadJarra;
	}

	public int getCapacidadJarra() {
		return capacidadJarra;
	}

	public int getCantidadJarra() {
		return cantidadJarra;
	}

	public int getTotalAguaServida() {
		return totalAguaServida;
	}

	@Override
	public String toString() {
		return "Jarra [capacidadJarra=" + capacidadJarra + ", cantidadJarra=" + cantidadJarra + ", totalAguaServida="
				+ totalAguaServida + "]";
	}
	
	public void llenarJarra() throws JarraException {
		
		int aguaServida;
		
		if (cantidadJarra == capacidadJarra) {
			throw new JarraException("Error, no se puede rellenar una jarra que ya esta llena");
		}
		
		aguaServida = capacidadJarra - cantidadJarra;
		totalAguaServida = totalAguaServida + aguaServida;
	}
	
	public void vaciarJarra() {
		
		cantidadJarra = VALOR_MINIMO;
	}
	
	public void volcarJarra(Jarra vuelco) throws JarraException {
		
		int cantidadAguaVolcada;
		
		if (vuelco.cantidadJarra == vuelco.capacidadJarra) {
			throw new JarraException("Error, no se puede  volcar la jarra porque ya sta llena");
		}
		
		if (this.cantidadJarra == VALOR_MINIMO) {
			throw new JarraException("Error, no se puede volcar la jarra porque esta vacia");
		}
		
		cantidadAguaVolcada = vuelco.cantidadJarra - vuelco.capacidadJarra;
		
		if (this.cantidadJarra <= cantidadAguaVolcada) {
			vuelco.cantidadJarra = vuelco.cantidadJarra + this.cantidadJarra;
			this.cantidadJarra = VALOR_MINIMO;
		}
		else {
			this.cantidadJarra = this.cantidadJarra - cantidadAguaVolcada;
			vuelco.cantidadJarra = vuelco.capacidadJarra;
		}
	}
}
