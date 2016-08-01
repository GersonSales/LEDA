package fifolifo;

public class StackOverflowException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -500923569063349451L;

	public StackOverflowException() {
		super("Stack is full");
	}
}
