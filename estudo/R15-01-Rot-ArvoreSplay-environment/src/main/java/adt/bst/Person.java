package adt.bst;

public class Person<T> {
	private T age;
	
	public Person(T age) {
		this.age = age;  
	}
	
	public int zx() {
		return (int)age;
	}
	

}
