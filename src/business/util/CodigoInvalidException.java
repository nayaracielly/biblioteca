package business.util;


public class CodigoInvalidException extends BookException {

	private static final long serialVersionUID = -3797234359811694207L;

	public CodigoInvalidException(){
    	super("C�digo inv�lido");
    }
   
    public CodigoInvalidException(String Message){
        super(Message);
    }
}
