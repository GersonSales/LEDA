package fifolifo;

public class QueueUnderflowException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 501102123327810366L;

	public QueueUnderflowException() {
		super("Fila vazia");
	}

}
