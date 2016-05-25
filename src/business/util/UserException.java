package business.util;

public class UserException extends Exception {

	private static final long serialVersionUID = 9101266191518161188L;

	public UserException() {
		super("Usuário invalido");
	}

	public UserException(String message) {
		super(message);
	}

	
}
