package adt.hashtable;

public class HashFunctionQuadraticProbingImpl<T> implements
		HashFunctionOpenAddress {

	
	protected Hashtable<T> hashtable;
	protected int c1;
	protected int c2;
	
	// The auxiliary hash function used by quadratic probing.
	protected HashFunctionClosedAddress originalHashFunction;
	
	public HashFunctionQuadraticProbingImpl(Hashtable<T> hashtable, 
			HashFunctionClosedAddressMethod method, //the method of the original hash function
			int c1, int c2) {
		super();
		this.hashtable = hashtable;
		//Adjust your constructor to initialize the attribute originalHashFunction with the correct hash function
	}
	
	/**
	 * The hash function might use the length of the hashtable. This can be captured through the method
	 * capacity of the hashtable.
	 */
	
	//Metodo que usa a funcao hash com probing quadratico - duas constantes
	//Evita o clustering primario;
	@Override
	public int hash(Object element, int probe) {
		return ( originalHashFunction.hash(element) + c1 * probe + c2 * (probe * probe) ) % hashtable.capacity();
	}

}
