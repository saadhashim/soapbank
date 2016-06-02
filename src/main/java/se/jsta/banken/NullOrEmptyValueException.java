package se.jsta.banken;

public class NullOrEmptyValueException extends Exception {
    public NullOrEmptyValueException() {
        super("Du angav ett ogiltigt värde, antingen är det tomt eller null", new IllegalArgumentException("Du angav ett ogiltigt värde, antingen är det tomt eller null"));
    }
}
