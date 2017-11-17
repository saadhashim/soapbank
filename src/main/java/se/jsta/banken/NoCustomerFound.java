package se.jsta.banken;

public class NoCustomerFound extends Exception {
    public NoCustomerFound() {
        super("There is no customer with this name", new IllegalArgumentException("There is no customer with this name"));
    }
}
