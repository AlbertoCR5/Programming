package ejercicio06Diccionario;

import java.util.ArrayList;

public class EntradaDiccionario implements Comparable<EntradaDiccionario>{

	private String palabra;
	private ArrayList<String> significados;
	
	public EntradaDiccionario(String palabra) {

		this.palabra = palabra;
		this.significados = new ArrayList<String>();
	}

	public EntradaDiccionario(String palabra, String significados) throws DiccionarioException {
		
		this.palabra = palabra;
		this.significados = new ArrayList<String>();
		this.anadirSignificado(significados);
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palabra == null) ? 0 : palabra.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaDiccionario other = (EntradaDiccionario) obj;
		if (palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!palabra.equals(other.palabra))
			return false;
		return true;
	}


	@Override
	public String toString() {
		
		StringBuilder sbSignificados = new StringBuilder();
		
		for (String definicion : significados) {
			sbSignificados.append(definicion + "\n");
		}
		return palabra + " con significados: " + sbSignificados.toString();
	}


	@Override
	public int compareTo(EntradaDiccionario otro) {
		
		return this.palabra.compareTo(otro.palabra);
	}


	public void anadirSignificado(String significado) throws DiccionarioException {
		
		if (this.significados.contains(significado)) {
			throw new DiccionarioException("Este significado " + significado + ", ya esta añadido");
		}
		
		this.significados.add(significado);
	}
	
}
