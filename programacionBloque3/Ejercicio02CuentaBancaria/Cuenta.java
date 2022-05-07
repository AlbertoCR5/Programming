package Ejercicio02CuentaBancaria;

public class Cuenta {

	public static final int SALDO_MINIMO = 0;
	public static final int VALOR_MINIMO = 0;
	
	int saldo, reintegro, ingreso, cantidadIngresos, cantidadReintegros, movimientos;

	public Cuenta(int saldo) {
		
		setSaldo(saldo);
		this.cantidadIngresos = 0;
		this.cantidadReintegros = 0;
		this.movimientos = 0;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		
		if (saldo < SALDO_MINIMO) {
			System.out.println("El saldo inicial no puede ser inferior a " + SALDO_MINIMO);
		}
		else {
			this.saldo = saldo;
		}
		
	}

	public void reintegro(int reintegro) {
		
		if (reintegro > saldo || reintegro <= VALOR_MINIMO) {
			System.out.println("No puedes retirar una cantidad superior a " + saldo + ", o una cantidad negativa ");
		}
		else {
			saldo = saldo - reintegro;
			cantidadReintegros++;
		}
		
	}

	public void ingreso(int ingreso) {
		
		if (ingreso <= VALOR_MINIMO) {
			System.out.println("Debes introducir una cantidad positiva");
		}
		else {
			saldo = saldo + ingreso;
			cantidadIngresos++;
		}
		
	}

	@Override
	public String toString() {
		
		movimientos = cantidadIngresos + cantidadReintegros;
		
		return "La cuenta tiene un saldo de " + saldo + ", ha realizado " + cantidadIngresos + " ingresos, y "
				+ cantidadReintegros + " reintegros, haciendo un total de " + movimientos + " movimientos." ;	
		
	}
	
}
