package EjemplosOrientacionObjetos.EjemploBasicoIMC;


public class IMCPersona {
	private static final int PESO_MAXIMO = 200;
	private static final double ALTURA_MAXIMA =3;
	
	private String dni;
	private String nombre;
	private int peso;
	private double altura;
	
	
	public IMCPersona(String dni, String nombre, int peso, double altura) {
		this.dni = dni;
		this.nombre = nombre;
		
		setPeso(peso);
		
		this.altura = altura;
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		if (peso <=0  || peso> PESO_MAXIMO) {
			System.out.println("Dato peso incorrecto " + peso);
		}else {
			this.peso = peso;
		}
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		if (altura <=0  || altura> ALTURA_MAXIMA) {
			System.out.println("Dato peso incorrecto " + altura);
		}else {
			this.altura = altura;
		}
	}


	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + "]";
	}
	
	
	public double calcularIMC ( ) {
		double imc;
		imc=peso/(altura*altura);
		return imc;
	}
	
	public String clasificacionPorPeso() {
		String clasificacion=null;
		double imc=calcularIMC();
		
		// Terminarlo darle valores según el IMC
		
		return clasificacion;
		
		
	}
	
	
}