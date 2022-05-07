package Ejercicio08MiEntradaSalida;

public class MiEntradaSalida {

	private static final char NO = 'N';
	private static final char SI = 'S';
	private int numero, numeroPositivo, numeroEnRango, limiteInferior, limiteSuperior;
	char caracter, caracterSN;
	String cadena;
	
	public MiEntradaSalida() throws MiEntradaSalidaException {
		setNumero(numero);
		setNumeroPositivo(numeroPositivo);
		setNumeroEnRango(numeroEnRango);
		setCaracter(caracter);
		setCaracterSN(caracterSN);
		setCadena(cadena);
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroPositivo() {
		return numeroPositivo;
	}

	public void setNumeroPositivo(int numeroPositivo) throws MiEntradaSalidaException {
		
		if (numeroPositivo < 0) {
			throw new MiEntradaSalidaException("Error, no has introducido un numero positivo");
		}
		this.numeroPositivo = numeroPositivo;
	}

	public int getNumeroEnRango() {
		return numeroEnRango;
	}

	public void setNumeroEnRango(int numeroEnRango) throws MiEntradaSalidaException {
		
		if (this.limiteInferior == this.limiteSuperior) {
			throw new MiEntradaSalidaException("Los limites introducidos deben ser distintos");
		}
		this.numeroEnRango = numeroEnRango;
	}
	
	public int getLimiteInferior() {
		return limiteInferior;
	}

	public void setLimiteInferior(int limiteInferior) throws MiEntradaSalidaException {
		
		if(limiteInferior < Integer.MIN_VALUE) {
			throw new MiEntradaSalidaException("No puedes introducir un limite inferior menor a " + Integer.MIN_VALUE);
		}
		this.limiteInferior = limiteInferior;
	}


	public int getLimiteSuperior() {
		return limiteSuperior;
	}

	public void setLimiteSuperior(int limiteSuperior) throws MiEntradaSalidaException {
		
		if (limiteSuperior > Integer.MAX_VALUE) {
			throw new MiEntradaSalidaException("No puedes introducir un limite superior mayor a " + Integer.MAX_VALUE);
		}
		this.limiteSuperior = limiteSuperior;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public char getCaracterSN() {
		return caracterSN;
	}

	public void setCaracterSN(char caracterSN) throws MiEntradaSalidaException {
		
		if (caracter != SI && caracter != NO) {
			throw new MiEntradaSalidaException("Debes introducir el caracter " + SI + " o " + NO);
		}
		this.caracterSN = caracterSN;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) throws MiEntradaSalidaException {
		
		if (cadena.length() <= 1) {
			throw new MiEntradaSalidaException("Debes introducir al menos dos caracteres");
		}
		this.cadena = cadena;
	}

	@Override
	public String toString() {
		return "MiEntradaSalida [numero=" + numero + ", numeroPositivo=" + numeroPositivo + ", numeroEnRango="
				+ numeroEnRango + ", limiteInferior=" + limiteInferior + ", limiteSuperior=" + limiteSuperior
				+ ", caracter=" + caracter + ", caracterSN=" + caracterSN + ", cadena=" + cadena + "]";
	}
	
	
}
