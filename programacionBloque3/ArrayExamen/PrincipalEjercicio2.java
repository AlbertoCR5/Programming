package ArrayExamen;

public class PrincipalEjercicio2 {

	public static void main(String[] args) {
	
		Modelo[] modelos = null;
		
		try {
			double media = mediaPreciosModelosElectricos(modelos);
			Modelo modeloMasBarato = modeloMasBarato(modelos);
			System.out.println(media);
			System.out.println(modeloMasBarato);
		} catch (ModeloException e) {
			System.out.println(e.getMessage());
		}


	}
	
	private static double mediaPreciosModelosElectricos(Modelo[] modelos) throws ModeloException{
		
		double media = 0;
		int totalModelosElectricos = 0;

		
		for (int i = 0; i < modelos.length; i++) {
			if (modelos[i].isElectrico()) {
				media = media + modelos[i].getPrecio();
				totalModelosElectricos++;
			}
		}
		if (totalModelosElectricos == 0) {
			throw new ModeloException("No se puede calcular la media al no haber modelos electricos");
		}
		return media = media / totalModelosElectricos;
	}
	
	private static Modelo modeloMasBarato(Modelo[] modelos) {
		
		double masBarato = Double.MAX_VALUE;
		Modelo modeloMasBarato = null;
		
		for (int i = 0; i < modelos.length; i++) {
			if (modelos[i].getPrecio() < masBarato) {
				masBarato = modelos[i].getPrecio();
				modeloMasBarato = modelos[i];
			}
			
		}
		
		return modeloMasBarato;
	}

}
