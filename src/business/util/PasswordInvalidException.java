

package business.util;

public class PasswordInvalidException extends UserException {

	private static final long serialVersionUID = 4081633597571256549L;
	
	public PasswordInvalidException(){
		super("Senha Invalida");
	}
    public PasswordInvalidException(String Message){
        super(Message);
    }
}

