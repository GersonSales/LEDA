package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
        extends AbstractHashtableOpenAddress<T> {

    public HashtableOpenAddressQuadraticProbingImpl(int size,
            HashFunctionClosedAddressMethod method, int c1, int c2) {
        super(size);
        hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1,
                c2);
        this.initiateInternalTable(size);
    }

    @Override
    public void insert(T element) {

        if (element != null) {
            if (isFull()) {
                throw new HashtableOverflowException();
            }

            if (indexOf(element) < 0) {
                for (int i = 0; i < this.table.length; i++) {
                    int elementHash = getHash(element, i);

                    if (isAvaible(elementHash)) {
                        this.table[elementHash] = element;
                        this.elements++;
                        return;
                    } else {
                        this.COLLISIONS++;
                    }
                }
            }
        }
    }

    private boolean isAvaible(int elementHash) {
        if (this.table[elementHash] instanceof HashtableElement) {
            return false;
        }
        return true;
    }

    private int getHash(T element, int probe) {
        return ((HashFunctionQuadraticProbing<T>) getHashFunction())
                .hash(element, probe);
    }

    @Override
    public void remove(T element) {
        int elementIndex = indexOf(element);
        if (elementIndex >= 0) {
            this.table[elementIndex] = new DELETED();
            this.elements--;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public T search(T element) {
        int elementIndex = indexOf(element);
        if (elementIndex > 0) {
            return (T) this.table[elementIndex];
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        if (element != null) {
            for (int i = 0; i <= this.table.length; i++) {
                int elementHash = getHash(element, i);
                if (this.table[elementHash] != null) {
                    if (this.table[elementHash].equals(element)) {
                        return elementHash;
                    }
                }
            }
        }
        return -1;

    }
}
