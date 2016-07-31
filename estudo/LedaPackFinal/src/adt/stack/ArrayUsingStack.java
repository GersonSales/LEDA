package adt.stack;

public class ArrayUsingStack<T> {
	T[] array;
	int size;
	int top1;
	int top2;

	public ArrayUsingStack(Integer size) {
		this.size = size;
		array = (T[]) new Object[size];
		top1 = -1;
		top2 = size;
	}

	public void push1(T x) throws StackOverflowException {
		if (top1 < top2 - 1) {
			top1++;
			array[top1] = x;
		} 
		
		else {
			throw new StackOverflowException();
		}
	}

	public void push2(T x) throws StackOverflowException {
		if (top1 < top2 - 1) {
			top2--;
			array[top2] = x;
		} 
		
		else {
			throw new StackOverflowException();
		}
	}

	public T pop1() throws StackUnderflowException {
		if (top1 >= 0) {
			T x = array[top1];
			top1--;
			return x;
		} 
		
		else {
			throw new StackUnderflowException();
		}
	}

	public T pop2() throws StackUnderflowException {
		if (top2 < size) {
			T x = array[top2];
			top2++;
			return x;
		} 
		
		else {
			throw new StackUnderflowException();
		}
	}
}
/*
 * twoStacks ts(5);
    ts.push1(5);
    ts.push2(10);
    ts.push2(15);
    ts.push1(11);
    ts.push2(7);
    cout << "Popped element from stack1 is " << ts.pop1();
    ts.push2(40);
    cout << "\nPopped element from stack2 is " << ts.pop2();
    return 0;
    
    Output
    Popped element from stack1 is 11
  	Popped element from stack2 is 40
 */

