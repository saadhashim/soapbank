package se.jsta.banken;

import javax.jws.WebService;

@WebService
public interface JSTABanken {
    String sayHi(String text);
    boolean createCustomer(String name);
    boolean insertMoney(String name, float amount);
    boolean withdrawMoney(String name, float amount);
    float getBalance(String name);
}

