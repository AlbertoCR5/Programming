package ejercicio01Banca;

public class Cuenta {
	
	/**
	 * Se cree el campo protegido porque es necesario que la clase CuentaDeCredito que 
	 * hereda de ella lo pueda modificar.
	 */
	protected double saldo; 
	private String titular;
	private int numeroDeIngresos;
	protected int numeroDeReintegros;
	
	public Cuenta(String titular){
		this.titular=titular;
		saldo=0;
		numeroDeReintegros=0;
		numeroDeIngresos=0;
	}
	
	
	
	public Cuenta(String titular, double saldoInicial)throws CuentaException{
		this.titular=titular;
		this.setSaldo(saldoInicial);
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	
	
	private void setSaldo(double saldo)throws CuentaException {
		if (saldo<0){
			throw new CuentaException("No puede crear una  cuenta con un saldo negativo");
		}
		
		this.saldo = saldo;
	}
	
	
	public String getTitular() {
		return titular;
	}



	/**
	 * Método para sacar dinero de una cuenta
	 * @param dineroASacar cantidad de dinero que se desea sacar
	 * @throws CuentaException Si el dineroASacar es negativo o quiere sacar más dinero del que dispone la cuenta
	 */
	public void realizarReintegro(double dineroASacar)throws CuentaException{
		if ( dineroASacar < 0)
			throw new CuentaException("Imposible sacar cantidades negativas");
		
		if(dineroASacar>this.saldo){
			throw new CuentaException("Imposible sacar esa cantidad,su saldo no se lo permite");
		}
		
		this.saldo=this.saldo-dineroASacar;
		this.numeroDeReintegros++;
		
	}
	
	/**
	 * Método para ingresar dinero en la cuenta
	 * @param dineroAIngresar cantidad que se va a ingresar
	 * @throws CuentaException Si el dineroAIngresar es negativo
	 */
	public void realizarIngreso (double dineroAIngresar) throws CuentaException{
		if ( dineroAIngresar < 0 )
			throw new CuentaException("No puede ingresar cantidades negativas");
		
		this.saldo=this.saldo+dineroAIngresar;
		this.numeroDeIngresos++;
	}
	
	
	
	public int getNumeroDeIngresos() {
		return numeroDeIngresos;
	}


	public int getNumeroDeReintegros() {
		return numeroDeReintegros;
	}

	public String toString() {
		return  "Cuenta con saldo: "+ saldo + " euros" + " Reintegros:" + numeroDeReintegros + " Ingresos " + numeroDeIngresos;
	}
}
