package fr.eni.clinique.dal.exception;

public class DalException extends Exception {

	private static final long serialVersionUID = 8706373604050790022L;
	
    public DalException(String message) {
        super(message);
    }

    public DalException(String message, Throwable cause) {
        super(message, cause);
    }
}
