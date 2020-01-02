

public class NoPathException extends Exception {

	/**
	 * The default constructor.
	 */
	public NoPathException() {
        super();
    }

	/**
	 * Contruct an exception with a particular error message.
	 */
    public NoPathException(String msg) {
        super(msg);
    }
}
