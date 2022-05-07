package Ejercicio07FraccionBIs;

public class Fraccion {

	//Atributos
	private int numerador;
	private int denominador;
	
	//Constructor
	public Fraccion(int numerador, int denominador) throws FraccionException {

		this.numerador = numerador;
		this.denominador = denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) throws FraccionException {
		
		if (denominador == 0) {
			throw new FraccionException("El denominador no puede ser 0.");
		}
		
		this.denominador = denominador;
	}

	public String toString() {
		
		return this.numerador + "/" + this.denominador;
	}
	
	public boolean equals(Fraccion otro) {
		
		boolean resultado = false;
		
		//this.simplificar();
		//otro.simplificar();
		
		if (this.numerador == otro.numerador && this.denominador == otro.denominador) {
			resultado = true;
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que suma dos fracciones
	 * @param otro
	 * @return objeto fraccional que representa la suma de dos fracciones
	 */
	public Fraccion sumar(Fraccion otro) {
		
		int numerador1, numerador2, numeradorTotal, denominadorComun;
		Fraccion resultado = null;
		
		denominadorComun = this.denominador * otro.denominador;
		numerador1 = otro.denominador * this.numerador;
		numerador2 = this.denominador * otro.numerador;
		numeradorTotal = numerador1 + numerador2;
		
		try {
			resultado = new Fraccion(numeradorTotal, denominadorComun);
			//resultado.simplificar();
		} catch(FraccionException e) { //este error no va a producirse, porque el denominador nun ca va aser 0.					
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que resta dos fracciones
	 * @param otro
	 * @return objeto fraccional que representa la resta de dos fracciones
	 */
	public Fraccion restar(Fraccion otro) {
		
		int numerador1, numerador2, nuevoNumerador, nuevoDenominador;
		Fraccion resultado = null;
		
		numerador1 = otro.denominador * this.numerador;
		numerador2 = this.denominador * otro.numerador;
		nuevoNumerador = numerador1 - numerador2;
		nuevoDenominador = this.denominador * otro.getDenominador();
		
		try {
			resultado = new Fraccion(nuevoNumerador, nuevoDenominador);
			//resultado.simplificar();
		} catch(FraccionException e) { //este error no va a producirse, porque el denominador nun ca va aser 0.					
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que multiplica dos fracciones
	 * @param otro
	 * @return objeto fraccional que representa la multiplicacion de dos fracciones
	 */
	public Fraccion multiplicar(Fraccion otro) {
		
		int nuevoNumerador, nuevoDenominador;
		Fraccion resultado = null;
		
		nuevoNumerador = this.numerador * otro.getNumerador();
		nuevoDenominador = this.denominador * otro.getDenominador();
		
		try {
			resultado = new Fraccion(nuevoNumerador, nuevoDenominador);
			//No es necesario simplificar en este caso
		} catch(FraccionException e) { //este error no va a producirse, porque el denominador nun ca va aser 0.					
		}
		
		return resultado;
	}
	
	/**
	 * Metodo que divide dos fracciones
	 * @param otro
	 * @return objeto fraccional que representa la division de dos fracciones
	 */
	public Fraccion dividir(Fraccion otro) throws FraccionException {
		
		int nuevoNumerador, nuevoDenominador;
		Fraccion resultado = null;
		
		nuevoNumerador = this.numerador * otro.getDenominador();
		nuevoDenominador = this.denominador * otro.getNumerador();
		

			resultado = new Fraccion(nuevoNumerador, nuevoDenominador);
			//resultado.simplificar();
		
		
		return resultado;
	}
//
//	public void simplificar() {
//		
//		int resultadoMcd;
//		
//		try {
//			resultadoMcd = MisFuncionesMatematicas.mcd(this.numerador, this.denominador);
//			this.numerador = this.numerador / resultadoMcd;
//			this.denominador = this.denominador / resultadoMcd;
//		} catch(MisFuncionesMatematicasException e) {
//			//solo se va a dar si el numerador es 0.
//			//En este caso no es necesario simplificar
//		}
//		
//		
//	}
//	
	
}