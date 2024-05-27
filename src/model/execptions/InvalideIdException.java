package model.execptions;

public class InvalideIdException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalideIdException(String msg) {
        super(msg);
    }
}