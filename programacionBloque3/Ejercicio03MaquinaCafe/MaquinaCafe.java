package Ejercicio03MaquinaCafe;

public class MaquinaCafe {
	
	static final int VALOR_MINIMO = 0;
	static final int DEPOSITO_DOSIS_CAFE = 50;
	static final int DEPOSITO_DOSIS_LECHE = 50;
	static final int DEPOSITO_VASOS = 80;
	static final double PRECIO_LECHE = 0.8;
	static final double PRECIO_CAFE = 1.0;
	static final double PRECIO_CAFE_LECHE = 1.5;
	
	double monedero, importeIntroducido, cambio;
	int dosisCafe, dosisLeche, vasos;
	
	public MaquinaCafe(double monedero) {
	
		llenarDepositos();
		setMonedero(monedero);
	}

	private void llenarDepositos() {
		
		dosisCafe = DEPOSITO_DOSIS_CAFE;
		dosisLeche = DEPOSITO_DOSIS_LECHE;
		vasos = DEPOSITO_VASOS;		
	}

	public double getMonedero() {
		return monedero;
	}

	public void setMonedero(double monedero) {
		
		if (monedero <= VALOR_MINIMO) {
			System.out.println("No puede darse valor " + monedero + " al monedero inicial.");
		}
		else {
			this.monedero = monedero;
		}
		
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

	public static double getPrecioLeche() {
		return PRECIO_LECHE;
	}

	public static double getPrecioCafe() {
		return PRECIO_CAFE;
	}

	public static double getPrecioCafeLeche() {
		return PRECIO_CAFE_LECHE;
	}
	
	public double sevirLeche(double importeIntroducido) {
			
		cambio = VALOR_MINIMO;
		
		if (importeIntroducido < PRECIO_LECHE) {
			System.out.println("Importe introducido insuficiente: " + importeIntroducido);
			cambio = importeIntroducido;
		}
		else {			
			if (cambio > monedero) {
				System.out.println("Cambio insuficiente");
				cambio = importeIntroducido;
			}
			else {
				if (dosisLeche == VALOR_MINIMO) {
					System.out.println("Producto agotado");
					cambio = importeIntroducido;
				}
				else {
					if (vasos == VALOR_MINIMO) {
						System.out.println("Vasos agotados");
						cambio = importeIntroducido;
					}
					else {
						cambio = importeIntroducido - PRECIO_LECHE;
						monedero = monedero + PRECIO_LECHE;
						vasos--;
						dosisLeche--;
					}
				}
			}
		}
		
		return cambio;
		
	}
	
	public double sevirCafe(double importeIntroducido) {
		
		cambio = VALOR_MINIMO;
		
		if (importeIntroducido < PRECIO_CAFE) {
			System.out.println("Importe introducido insuficiente: " + importeIntroducido);
			cambio = importeIntroducido;
		}
		else {			
			if (cambio > monedero) {
				System.out.println("Cambio insuficiente");
				cambio = importeIntroducido;
			}
			else {
				if (dosisLeche == VALOR_MINIMO) {
					System.out.println("Producto agotado");
					cambio = importeIntroducido;
				}
				else {
					if (vasos == VALOR_MINIMO) {
						System.out.println("Vasos agotados");
						cambio = importeIntroducido;
					}
					else {
						cambio = importeIntroducido - PRECIO_CAFE;
						monedero = monedero + PRECIO_CAFE;
						vasos--;
						dosisCafe--;
					}
				}
			}
		}
		
		return cambio;
		
	}
	
	public double sevirCafeConLeche(double importeIntroducido) {
		
		cambio = VALOR_MINIMO;
		
		if (importeIntroducido < PRECIO_CAFE_LECHE) {
			System.out.println("Importe introducido insuficiente: " + importeIntroducido);
			cambio = importeIntroducido;
		}
		else {						
			if (cambio > monedero) {
				System.out.println("Cambio insuficiente");
				cambio = importeIntroducido;
			}
			else {
				if (dosisLeche == VALOR_MINIMO || dosisCafe == VALOR_MINIMO) {
					System.out.println("Producto agotado");
					cambio = importeIntroducido;
				}
				else {
					if (vasos == VALOR_MINIMO) {
						System.out.println("Vasos agotados");
						cambio = importeIntroducido;
					}
					else {
						cambio = importeIntroducido - PRECIO_CAFE_LECHE;
						monedero = monedero + PRECIO_CAFE_LECHE;
						vasos--;
						dosisLeche--;
						dosisCafe--;
					}
				}
			}
		}
		
		return cambio;
		
	}

	@Override
	public String toString() {
		return "El monedero dispone de " + monedero + "€, " + dosisCafe + " dosisCafe, " + dosisLeche
				+ " dosisLeche, y " + vasos + " vasos.";
	}

}