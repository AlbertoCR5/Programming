package Cuenta;

import EjemplosOrientacionObjetos.EjemploAtributoEstatico.CuentaException;

public class Cuenta {

	static final int VALOR_MINIMO = 0;
	
	private String nombreCuenta;
	private double saldo;
	private static int movimientos;
	
	public Cuenta(String nombreCuenta, double saldo) throws CuentaException {
		
		setNombreCuenta(nombreCuenta);
		setSaldo(saldo);
		movimientos = VALOR_MINIMO;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) throws CuentaException {
		
		if (nombreCuenta.length() <= 2) {
			throw new CuentaException("Nombre introducido no valido");
		}
		this.nombreCuenta = nombreCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) throws CuentaException {
		if (saldo <= 0) {
			throw new CuentaException("El saldo inicial de la cuenta debe ser superior a " + VALOR_MINIMO);
		}
		this.saldo = saldo;
	}

	public static int getMovimientos() {
		return movimientos;
	}

	@Override
	public String toString() {
		return "Cuenta [nombreCuenta=" + nombreCuenta + ", saldo=" + saldo + "] Ha realizado un total de " + movimientos + " movimientos";
	}
	
	public double realizarReintegro(double reintegro) throws CuentaException {
		
		if (reintegro <= VALOR_MINIMO) {
			throw new CuentaException("El ingreso debe ser un valor superior a " + VALOR_MINIMO);
		}
		else {
			if (reintegro > saldo) {
				throw new CuentaException("No puedes retirar mas saldo del que dispones" + saldo);
			}			
			
		}
		
		movimientos++;
		
		return saldo = saldo - reintegro;
		
	}
	
	public double realizarIngreso(double ingreso) throws CuentaException {
		
		if (ingreso <= VALOR_MINIMO) {
			throw new CuentaException("El ingreso debe ser un valor superior a " + VALOR_MINIMO);
		}
		
		movimientos++;
		
		return saldo = saldo + ingreso;
	}
	
	
}
