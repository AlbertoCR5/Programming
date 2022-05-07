package cuentaAhorroJoven;

public class Cuenta implements Cuantificable {
	
	protected double saldo; 
	private Titular titular;
	protected int cantidadReintegros;

	public Cuenta(double saldoInicial, Titular titular)throws CuentaException{
		this.setSaldo(saldoInicial);
		this.setTitular(titular);
		this.cantidadReintegros = 0;
		
	}
	
	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) throws CuentaException  {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}
		
	public int getCantidadReintegros() {
		return cantidadReintegros;
	}
		
	protected void setSaldo(double saldo)throws CuentaException {
		if (saldo<0){
			throw new CuentaException("No puede crear una  cuenta con un saldo negativo");
		}
		
		this.saldo = saldo;
	}
	
	/**
	 * Método para sacar dinero de una cuenta
	 * @param dineroASacar cantidad de dinero que se desea sacar
	 * @throws CuentaException Si el dineroASacar es negativo o quiere sacar más dinero del que dispone la cuenta
	 */
	public void sacarDinero(double dineroASacar)throws CuentaException{
		if ( dineroASacar < 0)
			throw new CuentaException("Imposible sacar cantidades negativas");
		
		if(dineroASacar>this.saldo){
			throw new CuentaException("Imposible sacar esa cantidad,su saldo no se lo permite");
		}
		
		this.saldo=this.saldo-dineroASacar;
		
		cantidadReintegros++;
	}
	
	/**
	 * Método para ingresar dinero en la cuenta
	 * @param dineroAIngresar cantidad que se va a ingresar
	 * @throws CuentaException Si el dineroAIngresar es negativo
	 */
	public void ingresarDinero (double dineroAIngresar) throws CuentaException{
		if ( dineroAIngresar < 0 )
			throw new CuentaException("No puede ingresar cantidades negativas");
		
		this.saldo=this.saldo+dineroAIngresar;
	}
	
	public String toString() {
		return  "Cuenta de " +  titular + "  con saldo: "+ saldo + " euros" ;
	}

	@Override
	public void getCantidad(double cantidad) {
		// TODO Auto-generated method stub
		
	}

	
}
