package EjemplosOrientacionObjetos.EjemploBasicoIMC;

public class MainIMC {

	public static void main(String[] args) {
		

		IMCPersona persona1=new IMCPersona("2599155", "LAURA GUERRA",54, 1.65);
		
		System.out.println("El IMC de la persona 1 es " + persona1.calcularIMC());
		
		System.out.println("La clasificacion por peso de persona 1 es " + persona1.clasificacionPorPeso());

	}

}
