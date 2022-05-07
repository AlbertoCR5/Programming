package recuperacionAbril2022;

public interface Habitable {
	
	public abstract double facturaAgua(double facturaAgua) throws ConstruccionException;
	public abstract double facturaLuz(double facturaLuz) throws ConstruccionException;
	public abstract double impuestos();
}
