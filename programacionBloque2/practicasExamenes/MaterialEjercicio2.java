package practicasExamenes;

import java.util.Random;

public class MaterialEjercicio2 {
	
	Random serie=new Random();
	int longitud = serie.nextInt(9);
	String contrasena = contrasennaAleatoria(longitud);
	
	

	
	/**
	 * Método que devuelve una contraseña aleatoria de la longitud indicada
	 * @param longitud
	 * @return contraseña aleatoria de la longitud indicada. Si la longitud es <=0 devolverá
	 * una cadena vacía.
	 */
	public static String contrasennaAleatoria( int longitud) {

		StringBuilder sbContrasena = new StringBuilder();
		char caracter;
				
		for (int i = 0; i <= longitud; i++) {
			caracter = caracterAleatorio();
			sbContrasena.append(caracter);
		}
		String contrasena = sbContrasena.toString();
		System.out.println(contrasena);
		return sbContrasena.toString();
		
	}

	/**
	 * Método que devuelve un caracter aleatorio de entre los caracteres admitidos
	 * @return
	 */
	public static char caracterAleatorio() {
		Random serie=new Random();
		char caracterAleatorio;
		String caracteresAdmitidos="ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789*_?+";
		int i = serie.nextInt(caracteresAdmitidos.length());

		caracterAleatorio = caracteresAdmitidos.charAt(i);

		return caracterAleatorio;
				
	}

}
