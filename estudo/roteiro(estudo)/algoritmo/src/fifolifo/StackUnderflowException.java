package fifolifo;

public class StackUnderflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080741343052408381L;

	public StackUnderflowException() {
		super("Stack is empty");
	}
}
