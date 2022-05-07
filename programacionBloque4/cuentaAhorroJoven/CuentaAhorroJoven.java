package cuentaAhorroJoven;

public class CuentaAhorroJoven extends Cuenta implements Comparable<CuentaAhorroJoven>{

	private static final double PUNTOS_EURO_INGRESO = 0.4;
	private static final int SALDO_MINIMO_PUNTOS = 500;
	private static final double PUNTOS_EURO_REINTEGRO = 0.3;
	private static final int MAXIMO_REINTEGRO = 120;
	private static final int SALDO_MINIMO_RESTANTE = 100;
	private static final int SALDO_MINIMO_JOVEN = 300;
	private static final int MAXIMO_REINTEGROS = 40;
	private static final int EDAD_MAXIMA = 35;
	public static final int CANJEAR_REGALO_1 = 50;
	public static final int CANJEAR_REGALO_2 = 110;
	public static final int CANJEAR_REGALO_3 = 150;
	public static final int CANJEAR_REGALO_4 = 220;
	public static final int CANJEAR_REGALO_5 = 260;
	public static final int CANJEAR_REGALO_6 = 280;
	
	private int edad;
	protected double puntos;
	TipoRegalo regalo;
	private double saldoAlCanjearRegalo;
	boolean regaloCanjeado;
	
	public CuentaAhorroJoven(double saldoInicial, Titular titular) throws CuentaException {
		super(saldoInicial, titular);
		puntos = 0;
		regaloCanjeado = false;
	}


	public void setTitular(Titular titular) throws CuentaException  {
		
		if (titular.getEdad() > EDAD_MAXIMA) {
			throw new CuentaException("ERROR, No puedes hacerte una cuenta joven ya que superas la edad" + edad);
		}
		super.setTitular(titular);
	}
	
	public void setSaldo(double saldoInicial)throws CuentaException {
		if (saldo < SALDO_MINIMO_JOVEN){
			throw new CuentaException("No puede crear una  cuenta joven con un saldo inferior a " + SALDO_MINIMO_JOVEN);
		}
		
		super.saldo = saldo;
	}
	
	public void ingresarDinero (double dineroAIngresar) throws CuentaException{
		if ( dineroAIngresar < 0 )
			throw new CuentaException("No puede ingresar cantidades negativas");
		
		if (super.saldo > SALDO_MINIMO_PUNTOS) {
			puntos = puntos + PUNTOS_EURO_INGRESO * dineroAIngresar;
		}
		else {
			if(super.saldo + dineroAIngresar > SALDO_MINIMO_PUNTOS) {
				puntos = puntos + PUNTOS_EURO_INGRESO * (super.saldo + dineroAIngresar - SALDO_MINIMO_PUNTOS);
			}
		}
		
		super.saldo = super.saldo + dineroAIngresar;
		
		
	}
	
	public void sacarDinero(double dineroASacar)throws CuentaException{
		
		if(getCantidadReintegros() == MAXIMO_REINTEGROS) {
			throw new CuentaException("ERROR, No puedes realizar mas reintegros al haber llegado al limite" + MAXIMO_REINTEGROS);
		}
		if ( dineroASacar < 0)
			throw new CuentaException("Imposible sacar cantidades negativas");
		
		if(dineroASacar>this.getSaldo()){
			throw new CuentaException("Imposible sacar esa cantidad,su saldo no se lo permite");
		}
		
		if (regaloCanjeado && (super.saldo - dineroASacar) < saldoAlCanjearRegalo) {
			throw new CuentaException("Imposible sacar esa cantidad, debe tener un saldo minimo de " + saldoAlCanjearRegalo);		
		}
		else {
			if ((super.saldo - dineroASacar) < SALDO_MINIMO_RESTANTE ) {
				throw new CuentaException("Imposible sacar esa cantidad, debe tener un saldo minimo de " + SALDO_MINIMO_RESTANTE);
			}
		}
		
		
		if (dineroASacar > MAXIMO_REINTEGRO) {
			puntos = puntos - PUNTOS_EURO_REINTEGRO * (double)(dineroASacar - MAXIMO_REINTEGRO);
		}
		if (puntos < 0) {
			puntos = 0;
		}
		
		super.saldo = super.saldo - dineroASacar;
		super.cantidadReintegros++;
	}

	public double getPuntos() {
		return puntos;
	}
	
	public double getSaldoAlCanjearRegalo() {
		return saldoAlCanjearRegalo;
	}

	public boolean isRegaloCanjeado() {
		return regaloCanjeado;
	}

	@Override
	public String toString() {
		return "CuentaAhorroJoven [edad=" + edad + ", puntos=" + puntos + "]";
	}
	
	public void canjearRegalo() throws CuentaException {
		
		if (puntos < regalo.getTipoRegalo()) {
			throw new CuentaException("ERROR, No dispones de suficientes puntos(" + puntos + ") para canjear este regalo." + regalo.getTipoRegalo());
		}
		puntos = puntos - regalo.getTipoRegalo();
		
		saldoAlCanjearRegalo = super.saldo;
		
		regaloCanjeado = true;
	}
	
	public void nuevoAnno() {
		puntos = 0;
		regaloCanjeado = false;
	}

	@Override
	public int compareTo(CuentaAhorroJoven otro) {

		return Double.compare(otro.getPuntos(), this.getPuntos());
	}

}
