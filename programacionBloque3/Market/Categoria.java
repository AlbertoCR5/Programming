package Market;

public class Categoria {

	private static final String DIGITOS = "0123456789";
	static final int IVA_MAXIMO = 25;
	static final int LONGITUD_MINIMA = 2;
	static final int IVA_SUPERREDUCIDO = 4;
	static final int IVA_REDUCIDO = 10;
	static final int IVA_GENERAL = 21;
	
	private String nombreCategoria;
	private int IVA;
	
	public Categoria(String nombreCategoria, int IVA) throws MarketExcepetion {

		setNombreCategoria(nombreCategoria);;
		setIVA(IVA);;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) throws MarketExcepetion {
		
		if(nombreCategoria.length() < 3 || nombreCategoria.contains(DIGITOS)) {
			throw new MarketExcepetion("ERROR, nombre de la categoria no valido");
		}
		this.nombreCategoria = nombreCategoria;
	}

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int IVA) throws MarketExcepetion {
		
		if (IVA != IVA_REDUCIDO && IVA != IVA_SUPERREDUCIDO && IVA != IVA_GENERAL && IVA != IVA_MAXIMO) {
			throw new MarketExcepetion("ERROR, IVA no valido");
		}
		this.IVA = IVA;
	}

	@Override
	public String toString() {
		return "Categoria [nombreCategoria=" + nombreCategoria + ", IVA=" + IVA + "]";
	}
	
}
