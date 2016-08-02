package fifolifo;

public class QueueOverflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1537478869323111646L;

	public QueueOverflowException() {
		super("Fila cheia");
	}

}
