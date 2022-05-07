package Ejercicio01Rectangulo;

public class Rectangulo {
	
	public static final int VALOR_MINIMO = 0;
	public static final int VALOR_MAXIMO = 20;
	
	private double altura, ancho;

	public Rectangulo(double altura, double ancho) {

		setAltura(altura);
		setAncho(ancho);
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		
		if (altura < VALOR_MINIMO || altura > VALOR_MAXIMO) {
			System.out.println("Altura introducidad (" + altura + ") fuera de rango (" + VALOR_MINIMO + "-" + VALOR_MAXIMO + ")");
		}
		else {
			this.altura = altura;
		}
		
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		
		if (ancho < VALOR_MINIMO || ancho > VALOR_MAXIMO) {
			System.out.println("Ancho introducido (" + ancho + ") fuera de rango (" + VALOR_MINIMO + "-" + VALOR_MAXIMO + ")");
		}
		else {
			this.ancho = ancho;
		}
		this.ancho = ancho;
	}

	public double perimetro (double altura, double ancho) {
		
		double perimetro;
		
		perimetro = (altura + ancho) * 2;
		
		return perimetro;
		
	}
	
	public double area (double altura, double ancho) {
		
		double area;
		
		area = (altura * ancho);
		
		return area;
	}

	@Override
	public String toString() {
		
		return "El rectangulo con altura = " + altura + ", y ancho= " + ancho + ", Tiene un perimetro de " + perimetro(altura, ancho) + ", y un area de " + area(altura, ancho);
	}
	
}
