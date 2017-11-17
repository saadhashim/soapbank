package se.jsta.banken;

public class InsufficientBalanceFault extends Exception {
    public InsufficientBalanceFault() {
        super("The balance is too low", new IllegalArgumentException("The balance is too low"));
    }
}
