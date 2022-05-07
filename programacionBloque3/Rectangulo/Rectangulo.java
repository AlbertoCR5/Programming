package Rectangulo;

public class Rectangulo {

	static final int VALOR_MINIMO = 0;
	static final int VALOR_MAXIMO = 20;
	
	private double base, altura;

	public Rectangulo(double base, double altura) throws RectanguloException {

		setBase(base);
		setAltura(altura);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) throws RectanguloException {
		
		if (base <= VALOR_MINIMO || base >= VALOR_MAXIMO) {
			throw new RectanguloException("La medida de la base del rectangulo debe estar comprendida entre 0 y 20");
		}
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) throws RectanguloException {
		
		if (altura <= VALOR_MINIMO || altura > VALOR_MAXIMO) {
			throw new RectanguloException("La medida de la altura del rectangulo debe estar comprendida entre 0 y 20");
		}
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + "] tiene un perimetro de " + calcularPerimetro(altura, altura) + " y un area de " + calcularArea(base, altura);
	}
	
	public double calcularPerimetro(double base, double altura) {
		
		double perimetro;
		
		perimetro = (base + altura) * 2;
		
		return perimetro;
		
	}
	
	public double calcularArea(double base, double altura) {
		
		double area;
		
		area = (base * altura);
		
		return area;
		
	}
	
}
