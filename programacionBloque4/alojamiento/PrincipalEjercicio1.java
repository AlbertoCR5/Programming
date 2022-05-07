package alojamiento;

import java.util.Arrays;

public class PrincipalEjercicio1 {

	public static void main(String[] args){
		
		Alojamiento[] tour = new Alojamiento[3];
		
		try {
			tour[0] = new CasaRural("daad", "dasd", 16, 4, Categoria.BAJA, true);
			tour[1] = new CasaRural("dadda", "dassad", 22, 4, true);
			tour[2] = new Hotel("df", "fsdf", 30, 4);
		} catch (AlojamientoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int numeroCasasConJacuzzi = numeroCasasConJacuzzi(tour);
		
		System.out.println(numeroCasasConJacuzzi);
		listadoAlojamientosOrdenadoPorPrecio(tour);
		
		//DESDE EL TRY HASTA AQUI EN EL EXAMEN NO HACE FALTA HACERLO
	}
	
	//TODO
	private static int numeroCasasConJacuzzi(Alojamiento[] tour) {
		
		int numeroCasasConJacuzzi = 0; //inicio a 0 
		
		for (int i = 0; i < tour.length; i++) { //recorro el array de tour con tamaño 3
			if (tour[i] instanceof CasaRural) { //comprueba que sea casa rural y no hotel
					//HAY QUE HACER CASTING
				if (((CasaRural)tour[i]).isJacuzzi()) { // si es casa rural, comprueba que Boolean jacuzzi sea verdadero
					numeroCasasConJacuzzi++; //si es verdadero, lo suma
				}
			}
		}
		
		return numeroCasasConJacuzzi; // lo muestra
		
	}
	
	//TODO
	private static void listadoAlojamientosOrdenadoPorPrecio(Alojamiento[] tour) {
			
		Arrays.sort(tour); //Ordenar array de objetos segun precio--> VER METODO COMPARETO EN ALOJAMIENTO
		
		for (int i = 0; i < tour.length; i++) {
			System.out.println(tour[i]); //Muestra todos los alojamientos de manera ordenada
		}
	}
}
