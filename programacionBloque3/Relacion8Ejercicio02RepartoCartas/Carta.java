package Relacion8Ejercicio02RepartoCartas;

public class Carta implements Comparable<Carta>{
	public static final int CARTAS_POR_PALO = 12;
	private int numero;
	private String palo;
	public static final String[] PALOS= {"OROS", "ESPADAS", "COPAS", "BASTOS"};
	
	public Carta(int numero, String palo) throws CartaException {
		if (numero < 1 || numero > CARTAS_POR_PALO) {
			throw new CartaException("Numero incorrecto" + numero);
		}
		if (! paloCorrecto(palo)) {
			throw new CartaException("Palo incorrecto");
		}
		this.numero = numero;
		this.palo = palo;
	}
	private boolean paloCorrecto(String palo) {
		boolean esCorrecto = false;
		
		for (int i = 0; i < PALOS.length && esCorrecto == false; i++) {
			if (PALOS[i].equals(palo)) {
				esCorrecto = true;
			}
		}
		
		return esCorrecto;
	}
	public int getNumero() {
		return numero;
	}
	
	public String getPalo() {
		return palo;
	}
	
	@Override
	public String toString() {
		return numero + " " + palo;
	}
	
	public int compareTo(Carta otro) {
		
		// Ordenado por numero	
		return Integer.compare(this.numero, otro.numero);
	}
	
}
