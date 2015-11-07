package se.jsta.banken;

public class NoCustomerFound extends Exception {
    public NoCustomerFound() {
        super("Finns ingen kund med det namnet", new IllegalArgumentException("Finns ingen kund med det namnet"));
    }
}
