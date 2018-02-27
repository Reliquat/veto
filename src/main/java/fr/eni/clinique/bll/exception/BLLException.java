package fr.eni.clinique.bll.exception;

public class BLLException extends Exception{

	private static final long serialVersionUID = -731429109932846184L;

    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);  
    }
}
