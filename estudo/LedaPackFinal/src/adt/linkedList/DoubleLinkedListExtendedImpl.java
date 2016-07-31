package adt.linkedList;

public class DoubleLinkedListExtendedImpl<T extends Comparable<T>> extends
		DoubleLinkedListImpl<T> implements DoubleLinkedListExtended<T> {

	@Override
	public void insertionSort() {
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head;

		while (!isEmpty() && !aux.isNIL()) {
			if (aux.previous.isNIL()) {

			} else {
				DoubleLinkedListNode<T> pivot = aux;
				DoubleLinkedListNode<T> i = (DoubleLinkedListNode<T>) aux.previous;

				while (!i.isNIL()) {
					if (i.getData().compareTo(pivot.getData()) > 0) {

						T dataAux = pivot.getData();
						pivot.data = i.getData();
						i.data = dataAux;

						pivot = i;
					}
					i = i.previous;

				}

			}
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}
	}

	@Override
	public void splitAndInvert() {
		Integer para = this.size() / 2;
		for (int i = 1; i <= para; i++) {
			this.insert(this.head.getData());
			this.removeFirst();
		}
	}
}