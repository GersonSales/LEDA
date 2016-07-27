package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = head;
		
		while (!auxHead.isNIL()) {
			auxHead = auxHead.next;
			size++;
		}
		return size;
	}


	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		
		while (!auxHead.isNIL()) {
			if(auxHead.getData().equals(element)) {
				break;
			}
			
			auxHead = auxHead.next;
		}
		return auxHead.getData();
	}


	@Override
	public void insert(T element) {
		if (element == null){
			return;
		}
		
		if (head.isNIL()) {
			head = new SingleLinkedListNode<T>(element, head);
		}
		
		else {
			SingleLinkedListNode<T> auxHead = head;
			
			while (!auxHead.next.isNIL()) {
				auxHead = auxHead.next;
			}
			auxHead.next = new SingleLinkedListNode<T>(element, auxHead.next);
		}
	}


	@Override
	public void remove(T element) {
		if (!head.isNIL()) {
			if (head.getData().equals(element)) {
				head = head.next;
			} 
			
			else {
				SingleLinkedListNode<T> auxHead = head;
				while (!auxHead.next.isNIL()) {
					if(auxHead.next.getData().equals(element)) {
						break;
					}
					
					auxHead = auxHead.next;
				}
				
				if (!auxHead.next.isNIL()) {
					auxHead.next = auxHead.next.next;
				}
			}
		}
	}

	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> auxHead = head;
		
		for (int i = 0; !auxHead.isNIL(); i++) {
			array[i] = auxHead.getData();
			auxHead = auxHead.next;
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
