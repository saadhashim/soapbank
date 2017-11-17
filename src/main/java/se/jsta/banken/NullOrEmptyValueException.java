package se.jsta.banken;

public class NullOrEmptyValueException extends Exception {
    public NullOrEmptyValueException() {
        super("You typed in an invalid value, either empty or null", new IllegalArgumentException("You typed in an invalid value, either empty or null"));
    }
}
