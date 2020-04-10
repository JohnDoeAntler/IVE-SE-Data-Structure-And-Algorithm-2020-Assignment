package app.Exceptions;

public class DuplicationException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DuplicationException(int num) {
		super("[DuplicationException " + num + " caught!]");
	}
}