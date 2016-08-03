package main.java.adt.queue;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Fila cheia");
	}

}
