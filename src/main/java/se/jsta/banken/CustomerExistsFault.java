package se.jsta.banken;

public class CustomerExistsFault extends Exception {
    public CustomerExistsFault() {
        super("Kund existerar redan", new IllegalArgumentException("Kund existerar redan"));
    }
}
