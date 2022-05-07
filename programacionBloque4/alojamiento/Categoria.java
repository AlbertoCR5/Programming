package alojamiento;

public enum Categoria {
	
	ALTA(CasaRural.PRECIO_ALTA),
	MEDIA(CasaRural.PRECIO_MEDIA),
	BAJA(CasaRural.PRECIO_BAJA);
	
	private int precioCasaRural;
	
	private Categoria(int precioCasaRural) {
		this.precioCasaRural=precioCasaRural;
	}
	
	public int getPrecioCasaRural() {
		return precioCasaRural;
	}

}
