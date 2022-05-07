package cuentaAhorroJoven;

public enum TipoRegalo {
	
	REGALO1(CuentaAhorroJoven.CANJEAR_REGALO_1),
	REGALO2(CuentaAhorroJoven.CANJEAR_REGALO_2),
	REGALO3(CuentaAhorroJoven.CANJEAR_REGALO_3),
	REGALO4(CuentaAhorroJoven.CANJEAR_REGALO_4),
	REGALO5(CuentaAhorroJoven.CANJEAR_REGALO_5),
	REGALO6(CuentaAhorroJoven.CANJEAR_REGALO_6);

	private int puntosRegalo;
	
	private TipoRegalo(int puntosRegalo) {
		this.puntosRegalo = puntosRegalo;
	}
	
	public int getTipoRegalo() {
		return puntosRegalo;
	}

}
