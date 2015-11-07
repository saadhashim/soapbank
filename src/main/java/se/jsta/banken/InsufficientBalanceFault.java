package se.jsta.banken;

public class InsufficientBalanceFault extends Exception {
    public InsufficientBalanceFault() {
        super("Det finns för lite pengar", new IllegalArgumentException("Det finns för lite pengar"));
    }
}
