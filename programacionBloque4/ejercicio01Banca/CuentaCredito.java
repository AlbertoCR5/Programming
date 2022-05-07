package ejercicio01Banca;

public class CuentaCredito extends Cuenta {
	
	
	private static final double CREDITO_MAXIMO = 300;
	private static final double CREDITO_POR_DEFECTO = 100;
	
	/**
	 * El crédito que le da el banco. La cantidad que puede sacar es su saldo más el crédito
	 */
	private double credito; 
	
	public CuentaCredito(String titular){
		super(titular);
		this.credito=CREDITO_POR_DEFECTO;
	
	}
	public CuentaCredito (String titular, double saldo, double credito) throws CuentaException
	{
		super (titular, saldo);
		this.setCredito( credito);	
	}
	

	public double getCredito() {
		return credito;
	}

	/**
	 * Para modificar el credito
	 * @param nuevoCredito
	 * @throws CuentaException: Si el nuevo credito es negativo o supera el crédito máximo o
	 * intenta disminuir el credito con un saldo inferior al credito nuevo
	 */
	public void setCredito(double nuevoCredito)throws CuentaException {
		double saldoEnPositivo;
		if(nuevoCredito>CREDITO_MAXIMO || nuevoCredito < 0 ){
			throw new CuentaException("El crédito no puede exceder los " + CREDITO_MAXIMO + " euros ni ser negativo");
		}
			
		if ( saldo < 0 ) {
			saldoEnPositivo=-saldo;
			if ( saldoEnPositivo > nuevoCredito )
				throw new CuentaException ("No puede modificarse el crédito al valor " + nuevoCredito + " porque el saldo de la cuenta es " + saldo);
		}
		this.credito = nuevoCredito;
		
	}
	
	/**
	 * Se sobreescribe el método realizarReintegro de la clase Cuenta, para que permita sacar su saldo
	 * más el crédito.
	 */
	public void realizarReintegro(double dineroASacar) throws CuentaException{
		
		if(dineroASacar<0){
			throw new CuentaException("No se puede sacar cantidades negativas");
		}
		
		if ( dineroASacar > saldo + credito)
				throw new CuentaException("Te pasas del credito, no puedes sacar la cantidad " + dineroASacar);
			
		super.saldo=super.saldo - dineroASacar;
		
			
		super.numeroDeReintegros++;
		
	}
	
	
	
	public String toString() {
		return   super.toString() + " y credito " + credito   ;
	}
	
}
