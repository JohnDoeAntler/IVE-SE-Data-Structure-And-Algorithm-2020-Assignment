package app.LinkedList;

public class EmptyListException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException() {
		super("The list is empty.");
	}

}