package info.developia.prevengic.exception;

public class CompoundDoesNotExistException extends RuntimeException {

    public CompoundDoesNotExistException() {
        super("Compound does not exist, please change search criteria");
    }

    public CompoundDoesNotExistException(String message) {
        super(message);
    }

}
