package se.jsta.banken;

public class CustomerExistsFault extends Exception {
    public CustomerExistsFault() {
        super("Customer already exist", new IllegalArgumentException("Customer already exist"));
    }
}
