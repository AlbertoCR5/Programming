package ejercicio05ArrayListInvertido;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> arrayString = new ArrayList<String>();
		ArrayList<String> invertido;
		
		arrayString.add("Sevilla");
		arrayString.add("Cordoba");
		arrayString.add("Malaga");
		arrayString.add("Granada");
		
		invertido = reverse(arrayString);
		
		for (String string : invertido) {
			System.out.println(string);
		}
		
		ArrayList<Integer> arrayEnteros = new ArrayList<Integer>();
		ArrayList<Integer> enterosInvertidos;
		
		arrayEnteros.add(44);
		arrayEnteros.add(55);
		arrayEnteros.add(33);
		arrayEnteros.add(22);
		
		enterosInvertidos = reverse(arrayEnteros);
		
		for (int integer : enterosInvertidos) {
			System.out.println(integer);
		}
	}

	public static <T> ArrayList<T> reverse(ArrayList<T> original) {
		
		ArrayList<T> arraListInvertido = new ArrayList<T>();
		T elemento;
		
		for (int i = original.size()-1; i >= 0; i--) {
			elemento = original.get(i);
			
			arraListInvertido.add(elemento);
		}
		
		return arraListInvertido;
	}
	
	public static <T> LinkedList<T> reverse(LinkedList<T> original) {
		
		LinkedList<T> linkedListInvertido = new LinkedList<T>();
		
		for (T elemento : original) {
			linkedListInvertido.add(0, elemento);
		}
		
		return linkedListInvertido;
	}
 
}
