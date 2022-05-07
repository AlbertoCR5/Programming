package profesorado;

public class Principal {

	private static final int NOTA_DE_CORTE = 4;

	public static void main(String[] args) {

	}

	public static void profesoresDePrimariaConUn4oMas(Profesor[] profesores) {

		for (int i = 0; i < profesores.length; i++) {

			Profesor profesor = profesores[i];
			if (profesor instanceof ProfesorPrimaria) {

				ProfesorPrimaria profePrimaria = (ProfesorPrimaria) profesor;
				if (profePrimaria.getNotaUltimaEvaluacion() >= NOTA_DE_CORTE) {
					System.out.println(profePrimaria);
				}
			}
		}

	}
}