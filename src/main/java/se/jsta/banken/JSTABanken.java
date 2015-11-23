package se.jsta.banken;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.AuthenticationException;

import javafx.fxml.LoadException;

@WebService
public interface JSTABanken {
    String sayHi(String text) throws LoadException;
    @WebMethod(operationName="createCustomer")
    Customer createCustomer(@WebParam(name="name") String name) throws CustomerExistsFault, LoadException;
    @WebMethod(operationName="insertMoney")
    Customer insertMoney(@WebParam(name="name") String name, @WebParam(name="amount") float amount) throws NoCustomerFound, LoadException;
    @WebMethod(operationName="withdrawMoney")
    Customer withdrawMoney(@WebParam(name="name") String name,@WebParam(name="amount") float amount) throws NoCustomerFound, InsufficientBalanceFault, LoadException;
    @WebMethod(operationName="getBalance")
    Customer getBalance(@WebParam(name="name") String name) throws NoCustomerFound, LoadException;
    @WebMethod(operationName="getCustomers")
    Customer[] getCusomers() throws NoCustomerFound, LoadException;
    @WebMethod(operationName="getCustomersSecure")
    Customer[] getCusomersSecure() throws NoCustomerFound, AuthenticationException, LoadException;
    @WebMethod(operationName="robTheBank")
    void robTheBank();
}

