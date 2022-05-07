package MaquinaCafe;

public class MaquinaCafe {

	static final int VALOR_MINIMO = 0;
	static final int DOSIS_CAFE = 50;
	static final int DOSIS_LECHE = 50;
	static final int VASOS = 80;
	static final double PRECIO_CAFE = 1;
	static final double PRECIO_LECHE = 0.8;
	static final double PRECIO_CAFELECHE = 1.5;

	private double monedero;
	private int dosisCafe, dosisLeche, vasos;
	private static int totalMaquinas;

	public MaquinaCafe(double monedero) throws MaquinaCafeException {

		setMonedero(monedero);
		llenarDepositos();
		totalMaquinas = getTotalMaquinas() + 1;
	}

	private void llenarDepositos() {

		this.dosisCafe = DOSIS_CAFE;
		this.dosisLeche = DOSIS_LECHE;
		this.vasos = VASOS;

	}

	public double getMonedero() {
		return monedero;
	}

	public void setMonedero(double monedero) throws MaquinaCafeException {

		if (monedero <= VALOR_MINIMO) {
			throw new MaquinaCafeException("El monedero inicial de la maquina debe ser mayor que " + VALOR_MINIMO);
		}
		this.monedero = monedero;
	}

	public int getDosisCafe() {
		return dosisCafe;
	}

	public int getDosisLeche() {
		return dosisLeche;
	}

	public int getVasos() {
		return vasos;
	}

	public static int getTotalMaquinas() {
		return totalMaquinas;
	}

	public double servirCafe(double importe) throws MaquinaCafeException {

		double cambio = importe - PRECIO_CAFE;

		if (importe < PRECIO_CAFE) {
			throw new MaquinaCafeException(
					"Importe introducido insuficiente " + importe + "El precio del cafe es " + PRECIO_CAFE);
		} else {
			if (cambio > monedero) {
				throw new MaquinaCafeException(
						"Lo sentimos, la maquino no dispone de cambio suficiente, recoja su dinero " + importe);
			} else {
				if (dosisCafe == VALOR_MINIMO) {
					throw new MaquinaCafeException("Lo sentimos, producto agotado, recoja su dinero " + importe);
				} else {
					if (vasos == VALOR_MINIMO) {
						throw new MaquinaCafeException("Lo sentimos, vasos agotados, recoja su dinero " + importe);
					}
				}
			}
		}

		dosisCafe--;
		vasos--;
		monedero = monedero + PRECIO_CAFE;

		return cambio;

	}

	public double servirLeche(double importe) throws MaquinaCafeException {

		double cambio = importe - PRECIO_LECHE;

		if (importe < PRECIO_LECHE) {
			throw new MaquinaCafeException(
					"Importe introducido insuficiente " + importe + "El precio del cafe es " + PRECIO_LECHE);
		} else {
			if (cambio > monedero) {
				throw new MaquinaCafeException(
						"Lo sentimos, la maquino no dispone de cambio suficiente, recoja su dinero " + importe);
			} else {
				if (dosisLeche == 0) {
					throw new MaquinaCafeException("Lo sentimos, producto agotado, recoja su dinero " + importe);
				} else {
					if (vasos == VALOR_MINIMO) {
						throw new MaquinaCafeException("Lo sentimos, vasos agotados, recoja su dinero " + importe);
					}
				}
			}
		}

		dosisLeche--;
		vasos--;
		monedero = monedero + PRECIO_LECHE;
		return cambio;
	}

	public double servirCafeConLeche(double importe) throws MaquinaCafeException {

		double cambio = importe - PRECIO_CAFELECHE;

		if (importe < PRECIO_CAFELECHE) {
			throw new MaquinaCafeException(
					"Importe introducido insuficiente " + importe + "El precio del cafe es " + PRECIO_CAFELECHE);
		} else {
			if (cambio > monedero) {
				throw new MaquinaCafeException(
						"Lo sentimos, la maquino no dispone de cambio suficiente, recoja su dinero " + importe);
			} else {
				if (dosisLeche == VALOR_MINIMO) {
					throw new MaquinaCafeException("Lo sentimos, producto agotado, recoja su dinero " + importe);
				} else {
					if (dosisCafe == VALOR_MINIMO) {
						throw new MaquinaCafeException("Lo sentimos, producto agotado, recoja su dinero " + importe);
					} else {
						if (vasos == VALOR_MINIMO) {
							throw new MaquinaCafeException("Lo sentimos, vasos agotados, recoja su dinero " + importe);
						}
					}

				}
			}
		}
		
		dosisCafe--;
		dosisLeche--;
		vasos--;
		monedero = monedero + PRECIO_CAFELECHE;

		return cambio;
	}

	@Override
	public String toString() {
		return "MaquinaCafe [monedero=" + monedero + ", dosisCafe=" + dosisCafe + ", dosisLeche=" + dosisLeche
				+ ", vasos=" + vasos + "]";
	}
	

}
