package business.util;

public class BookException extends Exception {

	private static final long serialVersionUID = 9101266191518161188L;

	public BookException() {
		super("Codigo Invalido");
	}

	public BookException(String message) {
		super(message);
	}

	
}
