package practicasExamenes;

public class ExamenTextoSinComentarios {

	private static final String GUION = "-";
	
	public static void main(String[] args) {
		
		String texto = "Andrés el de la última fila no vino ayer";
		String textoSinComentarios;
		
		//texto = solicitarTexto();
		textoSinComentarios = suprimirComentarios(texto);
		
		System.out.println(textoSinComentarios);
	}

	private static String suprimirComentarios(String texto) {
		
		StringBuilder sbTextoSinComentarios = new StringBuilder(texto);
		int posicionInicioComentario = texto.indexOf(GUION);
		int posicionFinComentario = texto.lastIndexOf(GUION);
		
		//SI no hay ningun guion devolvera el mismo texto
		if (posicionInicioComentario == -1) {
			sbTextoSinComentarios.toString();
		}
		else {
			//Si solo hay un guion, borrara todo a continuacion del guion, y devolvera lo restante
			if (posicionFinComentario == posicionInicioComentario) {
				sbTextoSinComentarios.delete(posicionInicioComentario, texto.length());
			}
			else {
				//Borrara lo que hay entre los guiones, y devolvera lo restante
				sbTextoSinComentarios.delete(posicionInicioComentario, posicionFinComentario+2);
			}
		}
		
		return sbTextoSinComentarios.toString();
	}

}
