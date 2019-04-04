package info.developia.prevengic.exception;

public class UserDoesNotExistException extends RuntimeException {

    public UserDoesNotExistException() {
        super("User does not exist, please change search criteria");
    }

    public UserDoesNotExistException(String message) {
        super(message);
    }

}
