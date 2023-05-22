package Exceptions;

public class InvalidPhoneNumber extends InvalidInput {
    public InvalidPhoneNumber(String message) {
        super(message);
    }

    public InvalidPhoneNumber() {
        super("InvalidPhoneNumber!!");
    }
}
