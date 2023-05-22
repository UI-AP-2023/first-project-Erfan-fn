package Exceptions;

public class InvalidDiscount extends Exception {
    public InvalidDiscount() {
        super("InvalidDiscount!!__");
    }

    public InvalidDiscount(String massage) {
        super(massage);
    }
}
