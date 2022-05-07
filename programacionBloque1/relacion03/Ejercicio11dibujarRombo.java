package relacion03;

public class Ejercicio11dibujarRombo {

	public static void main(String[] args) {
		int base = 7;
		int totalLineas;
		int caracteresPorLinea;
		int espaciosPorLinea;
		char caracter = '*';
		
				
			totalLineas = (base/2) +1;
			
			caracteresPorLinea=1;
			espaciosPorLinea = (base/2);
			
			for (int linea=1; linea <= totalLineas; linea++) {
				
				for (int contadorEspacios=1; contadorEspacios<=espaciosPorLinea; contadorEspacios++) {
					System.out.print("s");
				}
				
				for (int contadorCaracteres=1; contadorCaracteres<=caracteresPorLinea; contadorCaracteres++) {
					System.out.print(caracter);
				}
				System.out.println();
				
				caracteresPorLinea= caracteresPorLinea +2;
				espaciosPorLinea--;
			}	
	}

}
