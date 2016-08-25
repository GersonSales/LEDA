package adt.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Essa comparação não é feita diretamente com os elementos armazenados,
 * mas sim usando um comparator. Dessa forma, dependendo do comparator, a heap
 * pode funcionar como uma max-heap ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

    protected T[] heap;
    protected int index = -1;
    /**
     * O comparador é utilizado para fazer as comparações da heap. O ideal é
     * mudar apenas o comparator e mandar reordenar a heap usando esse
     * comparator. Assim os metodos da heap não precisam saber se vai funcionar
     * como max-heap ou min-heap.
     */
    protected Comparator<T> comparator;

    private static final int INITIAL_SIZE = 20;
    private static final int INCREASING_FACTOR = 10;

    /**
     * Construtor da classe. Note que de inicio a heap funciona como uma
     * min-heap.
     */
    @SuppressWarnings("unchecked")
    public HeapImpl(Comparator<T> comparator) {
        this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
        this.comparator = comparator;
    }

    // /////////////////// METODOS IMPLEMENTADOS
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Deve retornar o indice que representa o filho a esquerda do elemento
     * indexado pela posicao i no vetor
     */
    private int left(int i) {
        return (i * 2 + 1);
    }

    /**
     * Deve retornar o indice que representa o filho a direita do elemento
     * indexado pela posicao i no vetor
     */
    private int right(int i) {
        return (i * 2 + 1) + 1;
    }

    @Override
    public boolean isEmpty() {
        return (index == -1);
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] resp = (T[]) new Comparable[(index + 1)];// Util.makeArray(index +
                                                     // 1);
        for (int i = 0; i <= index; i++) {
            resp[i] = this.heap[i];
        }
        return resp;
    }

    // ///////////// METODOS A IMPLEMENTAR
    /**
     * Valida o invariante de uma heap a partir de determinada posicao, que pode
     * ser a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
     * (comparados usando o comparator) elementos na parte de cima da heap.
     */
    private void heapify(int position) {
        heapify(getHeap(), position);

    }

    private void heapify(T[] array, int position) {
        if (isAValidIndex(array, position)) {
            int max = maxOfThree(array, position);

            if (position != max) {
                util.Util.swap(array, position, max);
                heapify(array, max);
            }
        }
    }

    private int maxOfThree(T[] array, int position) {
        int max = position;

        if (isAValidIndex(array, left(position))) {
            max = maxIndex(array, position, left(position));

            if (isAValidIndex(array, right(position))) {
                max = maxIndex(array, max, right(position));
            }
        }
        return max;
    }

    private int maxIndex(T[] array, int indexOne, int indexTwo) {
        return getComparator().compare(array[indexOne], array[indexTwo]) > 0
                ? indexOne : indexTwo;

    }

    private boolean isAValidIndex(T[] array, int index) {
        return index >= 0 && index < array.length && array[index] != null;
    }

    @Override
    public void insert(T element) {
        if (element != null) {
            // ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
            if (index == heap.length - 1) {
                heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
            }
            // /////////////////////////////////////////////////////////////////

            if (element != null) {
                this.index++;
                getHeap()[index] = element;
                putInCorrectPosition(index);
            }
        }
    }

    private void putInCorrectPosition(int index) {
        if (getComparator().compare(getHeap()[index],
                getHeap()[parent(index)]) > 0) {
            util.Util.swap(getHeap(), index, parent(index));
            putInCorrectPosition(parent(index));
        }
    }

    @Override
    public void buildHeap(T[] array) {
        if (array != null) {
            for (int i = (array.length / 2); i >= 0; i--) {
                heapify(array, i);
            }

            this.heap = Arrays.copyOf(array, array.length);
            this.index = array.length - 1;
        }
    }

    @Override
    public T extractRootElement() {
        T extractedRoot = getHeap()[0];
        getHeap()[0] = getHeap()[index];
        getHeap()[index] = null;
        index--;
        heapify(0);
        return extractedRoot;
    }

    @Override
    public T rootElement() {
        return getHeap()[0];
    }

    @Override
    public T[] heapsort(T[] array) {
        Comparator<T> backup = getComparator();
        setComparator((o1, o2) -> (o2.compareTo(o1)));

        buildHeap(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = extractRootElement();
        }

        this.comparator = backup;

        return array;
    }

    @Override
    public int size() {
        return index + 1;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T[] getHeap() {
        return heap;
    }

}
