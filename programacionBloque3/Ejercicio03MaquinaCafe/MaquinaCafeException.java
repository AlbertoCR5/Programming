package Ejercicio03MaquinaCafe;

public class MaquinaCafeException {
	
	static final int VALOR_MINIMO = 0;
	static final int DEPOSITO_DOSIS_CAFE = 50;
	static final int DEPOSITO_DOSIS_LECHE = 50;
	static final int DEPOSITO_VASOS = 80;
	static final double PRECIO_LECHE = 0.8;
	static final double PRECIO_CAFE = 1.0;
	static final double PRECIO_CAFE_LECHE = 1.5;
	
	double monedero, importeIntroducido, cambio;
	int dosisCafe, dosisLeche, vasos;
	
	public MaquinaCafeException(double monedero) throws ExceptionMaquinaCafe{
	
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

	public void setMonedero(double monedero) throws ExceptionMaquinaCafe{
		
		if (monedero <= VALOR_MINIMO) {
			throw new ExceptionMaquinaCafe("No puede darse valor " + monedero + " al monedero inicial.");
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
	
	public double sevirLeche(double importeIntroducido) throws ExceptionMaquinaCafe{
			
		cambio = importeIntroducido - PRECIO_LECHE;
		
		if (importeIntroducido < PRECIO_LECHE) {

			throw new ExceptionMaquinaCafe("Importe introducido insuficiente: " + importeIntroducido + ", recoja el importe introducido " + importeIntroducido);			
		}
		else {			
			if (cambio > monedero) {

				throw new ExceptionMaquinaCafe("Cambio insuficiente, recoja el importe introducido " + importeIntroducido);		
			}
			else {
				if (dosisLeche == VALOR_MINIMO) {

					throw new ExceptionMaquinaCafe("Producto agotado, recoja el importe introducido "  + importeIntroducido);					
				}
				else {
					if (vasos == VALOR_MINIMO) {

						throw new ExceptionMaquinaCafe("Vasos agotados, recoja el importe introducido " + importeIntroducido);						
					}
					else {
						monedero = monedero + PRECIO_LECHE;
						vasos--;
						dosisLeche--;
					}
				}
			}
		}
		
		return cambio;
		
	}
	
	public double sevirCafe(double importeIntroducido) throws ExceptionMaquinaCafe{
		
		cambio = VALOR_MINIMO;
		
		if (importeIntroducido < PRECIO_CAFE) {
			cambio = importeIntroducido;
			throw new ExceptionMaquinaCafe("Importe introducido insuficiente: " + importeIntroducido);
			
		}
		else {			
			if (cambio > monedero) {
				cambio = importeIntroducido;
				throw new ExceptionMaquinaCafe("Cambio insuficiente");
				
			}
			else {
				if (dosisLeche == VALOR_MINIMO) {
					cambio = importeIntroducido;
					throw new ExceptionMaquinaCafe("Producto agotado");
					
				}
				else {
					if (vasos == VALOR_MINIMO) {
						cambio = importeIntroducido;
						throw new ExceptionMaquinaCafe("Vasos agotados");
						
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
	
	public double sevirCafeConLeche(double importeIntroducido) throws ExceptionMaquinaCafe {
		
		cambio = VALOR_MINIMO;
		
		if (importeIntroducido < PRECIO_CAFE_LECHE) {
			cambio = importeIntroducido;
			throw new ExceptionMaquinaCafe("Importe introducido insuficiente: " + importeIntroducido);			
		}
		else {						
			if (cambio > monedero) {
				cambio = importeIntroducido;
				throw new ExceptionMaquinaCafe("Cambio insuficiente");				
			}
			else {
				if (dosisLeche == VALOR_MINIMO || dosisCafe == VALOR_MINIMO) {
					cambio = importeIntroducido;
					throw new ExceptionMaquinaCafe("Producto agotado");					
				}
				else {
					if (vasos == VALOR_MINIMO) {
						cambio = importeIntroducido;
						throw new ExceptionMaquinaCafe("Vasos agotados");						
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