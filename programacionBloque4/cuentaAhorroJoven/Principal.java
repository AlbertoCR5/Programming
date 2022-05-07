package cuentaAhorroJoven;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) throws CuentaException {
		
		
	}
	
	private static CuentaAhorroJoven cuentaJovenConMasPuntos (Cuenta[] cuentas ) {
		
		int cantidadCuentasJoven = 0;
		CuentaAhorroJoven[] cuentasJovenes = new CuentaAhorroJoven[cuentas.length];
		
		for (int i = 0; i < cuentas.length; i++) {
			Cuenta cuenta = cuentas[i];
			
			if(cuenta instanceof CuentaAhorroJoven) {
				CuentaAhorroJoven cuentaJoven = (CuentaAhorroJoven) cuenta;
				cuentasJovenes[cantidadCuentasJoven] = cuentaJoven;
				cantidadCuentasJoven++;
			}
			
		}
		Arrays.sort(cuentasJovenes);
		
		return cuentasJovenes[0];
		
	}


}
