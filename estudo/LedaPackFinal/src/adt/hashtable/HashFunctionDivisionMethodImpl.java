package adt.hashtable;

public class HashFunctionDivisionMethodImpl<T> implements
		HashFunctionClosedAddress {

	protected Hashtable<T> hashtable;

	public HashFunctionDivisionMethodImpl(Hashtable<T> hashtable) {
		this.hashtable = hashtable;
		//Adjust your constructor to initialize the hashtable attribute with the correct hash function
	}
	
	/**
	 * The hash function might use the length of the hashtable. This can be captured through the method
	 * capacity of the hashtable.
	 */
	
	//Metodo de funcao Hash que usa o metodo da divisao (no caso, o resto da mesma);
	@Override
	public int hash(Object element) {
		return element.hashCode() % hashtable.capacity();
	}

}
