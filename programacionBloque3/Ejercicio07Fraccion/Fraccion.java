package Ejercicio07Fraccion;

public class Fraccion {
	
	private static final int VALOR_MINIMO = 0;
	//private static final String[] OPERADORES = {"+", "-", "*", "/"};

	Fraccion resultado;
	public int numeradorA, numeradorB, nuevoNumerador, denominadorComun;
	private int numerador;
	private int denominador;
	
	public Fraccion(int numerador, int denominador) throws FraccionException {

		setNumerador(numerador);
		setDenominador(denominador);
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) throws FraccionException {
		if (numerador == VALOR_MINIMO) {
			throw new FraccionException("El numerador no puden tener valor" + VALOR_MINIMO);
		}
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) throws FraccionException {
		if (denominador == VALOR_MINIMO) {
			throw new FraccionException("El denominador no puden tener valor" + VALOR_MINIMO);
		}
		this.denominador = denominador;
	}

	public String toString() {

//		String info;
//		info = this.numerador + "/" + this.denominador;
//		es lo mismo --> return info

		
		return this.numerador + "/" + this.denominador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominador;
		result = prime * result + numerador;
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
		Fraccion other = (Fraccion) obj;
		if (denominador != other.denominador)
			return false;
		if (numerador != other.numerador)
			return false;
		return true;
	}
	
	public Fraccion sumar(Fraccion otro) throws FraccionException {
	
		numeradorA = this.numerador * otro.denominador;
		numeradorB = otro.numerador * this.denominador;
		nuevoNumerador = numeradorA + numeradorB;
		denominadorComun = this.denominador * otro.denominador;
		
		resultado = new Fraccion(nuevoNumerador, denominadorComun);
		
		return resultado;
		
	}
	
	public Fraccion restar(Fraccion otro) throws FraccionException {
		
		numeradorA = this.numerador * otro.denominador;
		numeradorB = otro.numerador * this.denominador;
		nuevoNumerador = numeradorA - numeradorB;
		denominadorComun = this.denominador * otro.denominador;
		
		resultado = new Fraccion(nuevoNumerador, denominadorComun);
		
		return resultado;
		
	}
	
	public Fraccion multiplicar(Fraccion otro) throws FraccionException {
		
		nuevoNumerador = this.numerador * otro.numerador;
		denominadorComun = this.denominador * otro.denominador;
		
		resultado = new Fraccion(nuevoNumerador, denominadorComun);
		
		return resultado;
		
	}
	
	public Fraccion dividir(Fraccion otro) throws FraccionException {
		
		nuevoNumerador = this.numerador * otro.denominador;
		denominadorComun = otro.numerador * this.denominador;
		
		resultado = new Fraccion(nuevoNumerador, denominadorComun);
		
		return resultado;
		
	}
	
	public void simplificar() {
		
	}
	
}
