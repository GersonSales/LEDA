package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = getHead();
		if (element != null) {
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
		}
		return aux.getData();
	}

	private SingleLinkedListNode<T> getNewNode() {
		return new SingleLinkedListNode<>();

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = getHead();

			while (!aux.isNIL()) {
				aux = aux.getNext();
			}

			if (aux.isNIL()) {
				aux.setData(element);
				aux.setNext(getNewNode());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (getHead().getData().equals(element)) {
				getHead().setData(null);
			} else {
				SingleLinkedListNode<T> previous = null;
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				}

				if (!aux.isNIL()) {
					previous.setNext(aux.getNext());
				}
			}
		}

	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[size()];
		int index = 0;

		SingleLinkedListNode<T> aux = getHead();

		while (!aux.isNIL()) {
			result[index] = aux.getData();
			aux = aux.getNext();
			index++;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
