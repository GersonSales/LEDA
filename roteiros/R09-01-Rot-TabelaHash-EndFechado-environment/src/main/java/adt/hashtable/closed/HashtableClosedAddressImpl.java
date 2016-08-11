package adt.hashtable.closed;

import java.util.ArrayList;
import java.util.List;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;

public class HashtableClosedAddressImpl<T>
        extends AbstractHashtableClosedAddress<T> {

    /**
     * A hash table with closed address works with a hash function with closed
     * address. Such a function can follow one of these methods: DIVISION or
     * MULTIPLICATION. In the DIVISION method, it is useful to change the size
     * of the table to an integer that is prime. This can be achieved by
     * producing such a prime number that is bigger and close to the desired
     * size.
     * 
     * For doing that, you have auxiliary methods: Util.isPrime and
     * getPrimeAbove as documented bellow.
     * 
     * The length of the internal table must be the immediate prime number
     * greater than the given size. For example, if size=10 then the length must
     * be 11. If size=20, the length must be 23. You must implement this idea in
     * the auxiliary method getPrimeAbove(int size) and use it.
     * 
     * @param desiredSize
     * @param method
     */

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public HashtableClosedAddressImpl(int desiredSize,
            HashFunctionClosedAddressMethod method) {
        int realSize = desiredSize;

        if (method == HashFunctionClosedAddressMethod.DIVISION) {
            realSize = this.getPrimeAbove(desiredSize); // real size must the
                                                        // the immediate prime
                                                        // above
        }
        initiateInternalTable(realSize);
        HashFunction function = HashFunctionFactory.createHashFunction(method,
                realSize);
        this.hashFunction = function;
    }

    // AUXILIARY
    /**
     * It returns the prime number that is closest (and greater) to the given
     * number. You can use the method Util.isPrime to check if a number is
     * prime.
     */
    int getPrimeAbove(int number) {
        int primeNumber = number % 2 == 0 ? ++number : number;
        while (!util.Util.isPrime(primeNumber)) {
            primeNumber += 2;
        }
        return primeNumber;
    }

    private int getHashIndexOf(T element) {
        if (getHashFunction() instanceof HashFunctionClosedAddress) {
            return ((HashFunctionClosedAddress<T>) getHashFunction())
                    .hash(element);
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void insert(T element) {
        if (element != null) {
            int elementIndex = getHashIndexOf(element);
            if (this.table[elementIndex] == null) {
                List<T> newTableValue = new ArrayList<>();
                newTableValue.add(element);
                this.table[elementIndex] = newTableValue;
            } else {
                ((List<T>) this.table[elementIndex]).add(element);
                this.COLLISIONS++;

            }
        }
        this.elements++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void remove(T element) {
        int elementIndex = indexOf(element);
        if (elementIndex != -1) {
            ((List<T>) this.table[elementIndex]).remove(element);
            this.elements--;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T search(T element) {
        int elementIndex = getHashIndexOf(element);
        List<T> tableElement = ((List<T>) this.table[elementIndex]);
        if (tableElement != null) {
            elementIndex = tableElement.indexOf(element);
            if (elementIndex != -1) {
                T foundElement = tableElement.get(elementIndex);
                return foundElement;
            }

        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(T element) {
        if (element != null) {
            int elementIndex = getHashIndexOf(element);

            if (this.table[elementIndex] != null) {
                return ((List<T>) this.table[elementIndex]).contains(element)
                        ? elementIndex : -1;
            }
        }

        return -1;
    }

}
