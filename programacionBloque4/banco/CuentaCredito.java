package banco;

public class CuentaCredito extends Cuenta {

	private static final int VALOR_MINIMO = 0;
	private static final int CREDITO_MAXIMO = 300;
	private static final int CREDITO_POR_DEFECTO = 100;
	
	private int credito;
	
	public CuentaCredito(String titular) throws CuentaException {
		super(titular);
		this.credito = CREDITO_POR_DEFECTO;
	}
	
	public CuentaCredito(double saldo, String titular, int credito) throws CuentaException {
		super(saldo, titular);
		this.setCredito(credito);
	}

	public int getCredito() {
		return credito;
	}

	/**
	 * Para modificar el credito
	 * @param nuevoCredito
	 * @throws CuentaException: Si el nuevo credito es negativo o supera el crédito máximo o
	 * intenta disminuir el credito con un saldo inferior al credito nuevo
	 */
	public void setCredito(int credito) throws CuentaException {
		
		if (credito < VALOR_MINIMO) {
			throw new CuentaException("ERROR, La cuenta no puede tener un credito negativo");
		}
		
		if (credito > CREDITO_MAXIMO) {
			throw new CuentaException("ERROR, La cuenta no puede tener un credito superior a 300€");
		}
		
		this.credito = credito;
	}

	@Override
	public String toString() {
		return super.toString() + " y credito " + credito;
	}
	
	/**
	 * Se sobreescribe el método realizarReintegro de la clase Cuenta, para que permita sacar su saldo
	 * más el crédito.
	 */
	public void realizarReintegro(double reintegro) throws CuentaException {
		
		double maximoDineroASacar = super.getSaldo() + credito;
		
		if (reintegro < VALOR_MINIMO) {
			throw new CuentaException("ERROR, No se puede retirar una cantidad negativa");
		}
		
		if (reintegro > maximoDineroASacar) {
			throw new CuentaException("ERROR, No puedes retirar una cantidad superior al de tu saldo y credito");
		}
		
		super.saldo = super.saldo - maximoDineroASacar;
		super.contadorReintegros++;
		
	}

}
