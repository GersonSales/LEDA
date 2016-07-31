package util;

public class Util {
	
	public static void swap(Object[] array, int i, int j) {
		Object aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
