package Exceptions;

public abstract class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super("InvalidInput!!__" + message);
    }
}
