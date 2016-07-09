package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

/**
 * This selection sort variation has two internal iterations. In the first, it
 * takes the smallest elements from the array, and puts it in the first
 * position. In the second, the iteration is done backwards, that is, from right
 * to left, and this time the biggest element is selected and stored in the last
 * position. Then it repeats the process, excluding the positions already filled
 * in, until the whole array is ordered.
 */
public class BidirectionalSelectionSort<T extends Comparable<T>>
        extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i < rightIndex; i++) {
            int menor = i;
            for (int j = i + 1; j < rightIndex + 1; j++) {
                if (array[j].compareTo(array[menor]) < 0) {
                    menor = j;
                }
            }
            util.Util.swap(array, menor, i);
            leftIndex++; 

            int maior = rightIndex - i;
            for (int j = rightIndex; j > leftIndex; j--) {
                if (array[j].compareTo(array[maior]) > 0) {
                    maior = j;
                }
            }
            util.Util.swap(array, maior, rightIndex);

            rightIndex--;

        }
    }
}
