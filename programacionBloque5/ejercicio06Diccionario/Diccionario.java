package ejercicio06Diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Diccionario {
	
	private HashMap<String, EntradaDiccionario> entradas;

	public Diccionario() {
	
		this.entradas = new HashMap<String, EntradaDiccionario>();
	}
	
	public void anadirPalabra(String palabra, String significado) throws DiccionarioException {
		
		EntradaDiccionario entradaNueva;
		EntradaDiccionario entradaRecogida = this.entradas.get(palabra);
		
		if (entradaRecogida != null) {
			entradaRecogida.anadirSignificado(significado);
		}
		else {
			entradaNueva = new EntradaDiccionario(palabra, significado);
			this.entradas.put(palabra, entradaNueva);
		}
	}
	
	public String buscarPalabra(String palabraABuscar) throws DiccionarioException {
		
		EntradaDiccionario entradaEncontrada;
		entradaEncontrada = entradas.get(palabraABuscar);
		
		if (entradaEncontrada == null) {
			throw new DiccionarioException("No se encuentra la palabra");
		}
		
		return entradaEncontrada.toString();
	}

	public void borrarPalabra(String palabraABorrar) throws DiccionarioException {
		
		EntradaDiccionario entradaBorrada;
		
		entradaBorrada = entradas.remove(palabraABorrar);
		
		if (entradaBorrada == null) {
			throw new DiccionarioException("No se ha encontrado la palabra " + palabraABorrar);
		}
	}
	
	public String listadoPalabrasComienzanPor(String comienzo) throws DiccionarioException {
		
		ArrayList<EntradaDiccionario> arrayEntradas = new ArrayList<EntradaDiccionario>();
		StringBuilder sbPalabras = new StringBuilder();
		
		for (EntradaDiccionario entradaDiccionario : entradas.values()) {
			if (entradaDiccionario.getPalabra().startsWith(comienzo)) {
				arrayEntradas.add(entradaDiccionario);
			}
		}
		
		if (arrayEntradas.isEmpty()) {
			throw new DiccionarioException("No existen palabras que comienzen por " + comienzo);
		}
		
		Collections.sort(arrayEntradas);
		
		for (EntradaDiccionario entradaDiccionario : arrayEntradas) {
			sbPalabras.append(entradaDiccionario + "\n");
		}
		
		return sbPalabras.toString();
	}
}
