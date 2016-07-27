package adt.hashtable;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends AbstractHashtable<T, LinkedList<T>> {

	// DO NOT DELETE THIS CONSTRUCTOR. ADJUST IT.
	public HashtableClosedAddressImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		//TODO Adjust your constructor here
		// The length of the internal table must be the immediate prime number greater than 
		// the given size. For example, if size=10 then the length must be 11. If size=20, the length 
		// must be 23. You may use the method getPrimeAbove(int size) but you must implement it.
	}
	
	//AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given number.  
	 */
	int getPrimeAbove(int number){
		int result = number;
		while(!Util.isPrime(result)){
			result = result + 1;
		}
		return result;
	}
			
	@Override
	public void insert(T element) {
		if(search(element) == null) {
			@SuppressWarnings("unchecked")
			int indice = ((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element);
			if(table[indice] == null) {
				table[indice] = new LinkedList<T>();
			}
			else {
				COLLISIONS++;
			}
			table[indice].add(element);
			elements++;
		}
	}


	@Override
	public void remove(T element) {
		if(search(element) != null) {
			@SuppressWarnings("unchecked")
			int indice = ((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element);
			table[indice].remove(element);
			elements--;
		}
	}


	@Override
	public T search(T element) {
		T result = null;
		@SuppressWarnings("unchecked")
		int indice = ((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element);
		if(table[indice] != null && table[indice].indexOf(element) != -1) {
			result = table[indice].get(table[indice].indexOf(element));
		}
		return result;
	}


	@Override
	public int indexOf(T element) {
		int result = -1;
		if (search(element) != null) {
			result = ((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element);
		}
		return result;
	}


}
