package relacion03;



public class Ejercicio09tablasMultiplicar0a10 {

	private static final int VALOR_MINIMO = 0;
	private static final int VALOR_MAXIMO = 10;

	public static void main(String[] args) {

		for (int i = VALOR_MINIMO; i <= VALOR_MAXIMO; i++) {
			System.out.println();
			for (int j = VALOR_MINIMO; j <= VALOR_MAXIMO; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}

		}

	}

}
