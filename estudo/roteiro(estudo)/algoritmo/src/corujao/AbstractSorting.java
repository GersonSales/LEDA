package corujao;

public abstract class AbstractSorting<E extends Comparable<E>> implements SortingInterface<E> {

	@Override
	public void sort(E[] array) {
		sort(array, 0, array.length - 1);
	}

	public abstract void sort(E[] array, int leftIndex, int rightIndex);

}
