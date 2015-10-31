package se.jsta.banken;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface JSTABanken {
    String sayHi(String text);
    @WebMethod(operationName="createCustomer")
    boolean createCustomer(@WebParam(name="name") String name);
    @WebMethod(operationName="insertMoney")
    boolean insertMoney(@WebParam(name="name") String name, @WebParam(name="amount") float amount);
    @WebMethod(operationName="withdrawMoney")
    boolean withdrawMoney(@WebParam(name="name") String name,@WebParam(name="amount") float amount);
    @WebMethod(operationName="getBalance")
    float getBalance(@WebParam(name="name") String name);
}

