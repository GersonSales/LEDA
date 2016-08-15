package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}

		if (element != null) {
			for (int i = 0; i <= elements; i++) {
				int elementHash = getHash(element, i);
				if (isAvaible(elementHash)) {
					if (!this.table[elementHash].equals(element)) {
						table[elementHash] = element;
						elements++;
					}
					return;
				} else {
					COLLISIONS++;
				}
			}
		}
	}

	private boolean isAvaible(int hash) {
		if (this.table[hash] instanceof HashtableElement) {
			return false;
		}
		return true;
	}

	private int getHash(T element, int probe) {
		return ((HashFunctionLinearProbing<T>) getHashFunction()).hash(element, probe);
	}

	@Override
	public void remove(T element) {
		if (element != null) {

			for (int i = 0; i <= elements; i++) {
				int elementHash = getHash(element, i);
				if (this.table[elementHash] != null) {
					if (this.table[elementHash].equals(element)) {
						this.table[elementHash] = new DELETED();
						elements--;
					}
				}
			}

		}

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T search(T element) {
		if (element != null) {

			for (int i = 0; i <= elements; i++) {
				int elementHash = getHash(element, i);
				if (this.table[elementHash] != null) {
					if (this.table[elementHash].equals(element)) {
						return element;
					}
				} else {
					return null;
				}

			}
		}

		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
