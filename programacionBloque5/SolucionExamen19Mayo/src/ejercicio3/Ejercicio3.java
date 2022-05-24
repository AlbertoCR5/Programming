package ejercicio3;

import java.util.HashSet;

public class Ejercicio3 {

	
	public static <T> HashSet<T> crearEquipoDiferencia(HashSet<T> equipo1, HashSet<T> equipo2 ){
		
		HashSet<T> resultado=new HashSet<T>();
		
		for ( T elemento: equipo1) {
			
			if (!equipo2.contains(elemento)) {
				resultado.add(elemento);
			}
		}
	
		
		return resultado;
		
		
	}
	
}
