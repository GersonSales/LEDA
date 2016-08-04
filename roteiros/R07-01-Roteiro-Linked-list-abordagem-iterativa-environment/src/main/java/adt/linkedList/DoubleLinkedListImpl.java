package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private DoubleLinkedListNode<T> nillNode;

	public DoubleLinkedListImpl() {
		this.nillNode = new DoubleLinkedListNode<>();
		this.last = new DoubleLinkedListNode<>();
		setHead(last);
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, nillNode, nillNode);
		newNode.setNext(getHead());
		setHead(newNode);
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, nillNode, nillNode);

		if (!isEmpty()) {
			this.last.setNext(newNode);
			newNode.setPrevious(last);
			this.last = newNode;
		}else {
			setHead(newNode);
			setLast(newNode);
			
		}

	}

	@Override
	public void removeFirst() {
		setHead(getHead().getNext());
	}

	@Override
	public void removeLast() {
		last = last.getPrevious();
		last.setNext(nillNode);
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
