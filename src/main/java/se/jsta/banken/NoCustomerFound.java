package se.jsta.banken;

public class NoCustomerFound extends Exception {
    public NoCustomerFound() {
        super("There is no customer with this name", new Exception("There is no customer with this name"));
    }
}
