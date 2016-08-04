package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> aux = head;
		int count = 0;
		while (aux != null && !aux.isNIL()) {
			aux = aux.getNext();
			count++;
		}

		return count;

	}

	@Override
	public T search(T element) {
		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = head;
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}

			if (!aux.isNIL()) {
				return aux.getData();
			}
		}
		return null;

	}

	@Override
	public void insert(T element) {

		if (element == null)
			return;
		SingleLinkedListNode<T> newElement = new SingleLinkedListNode<>();
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, newElement);
		newNode.setData(element);

		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = head;
			while (!aux.getNext().isNIL()) {
				aux = aux.getNext();
			}

			aux.setNext(newNode);

		} else {
			head = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			SingleLinkedListNode<T> previous = head;
			SingleLinkedListNode<T> aux = previous.getNext();

			while (!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux = aux.getNext();
			}

			if (!aux.isNIL()) {
				previous.setNext(aux.getNext());
			}

		}
	}

	@Override
	public T[] toArray() {

		int size = size();

		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size];
		if (size > 0) {

			SingleLinkedListNode<T> aux = head;

			int i = 0;
			while (aux != null && !aux.isNIL()) {
				array[i] = aux.getData();
				aux = aux.getNext();
				i++;
			}
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
