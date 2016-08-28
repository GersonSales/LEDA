package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T>
		implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		setHead(last);
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!isEmpty()) {
				if (getHead().getData().equals(element)) {
					removeFirst();
				} else if (getLast().getData().equals(element)) {
					removeLast();
				} else {

					DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead()
							.getNext();

					while (!aux.isNIL() && !aux.getData().equals(element)) {
						aux = (DoubleLinkedListNode<T>) aux.getNext();
					}

					if (!aux.isNIL() && aux.getData().equals(element)) {
						((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
						aux.getPrevious().setNext(aux.getNext());
					}
				}

			}
		}

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setHead(getNewNode(element));
				((DoubleLinkedListNode<T>) getHead()).setPrevious(null);
				setLast((DoubleLinkedListNode<T>) getHead());
			} else {

				DoubleLinkedListNode<T> newNode = getNewNode(element);
				getLast().setNext(newNode);
				newNode.setPrevious(getLast());
				setLast(newNode);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (getHead().isNIL()) {
				insert(element);
			} else {
				DoubleLinkedListNode<T> newNode = getNewNode(element);
				newNode.setNext(getHead());
				((DoubleLinkedListNode<T>) getHead()).setPrevious(newNode);
				newNode.setPrevious(null);
				setHead(newNode);
			}
		}
	}

	public DoubleLinkedListNode<T> getNewNode() {
		return getNewNode(null);
	}

	private DoubleLinkedListNode<T> getNewNode(T element) {
		DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<>();
		return new DoubleLinkedListNode<>(element, nilNode, nilNode);
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			setHead(getHead().getNext());
			((DoubleLinkedListNode<T>) getHead()).setPrevious(null);
			if (getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			setLast(getLast().getPrevious());
			if (getLast() == null) {
				setLast(getNewNode());
				setHead(getNewNode());
			} else {
				getLast().setNext(getNewNode());
			}

		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
