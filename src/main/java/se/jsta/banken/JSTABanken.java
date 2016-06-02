package se.jsta.banken;

import java.util.concurrent.TimeoutException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.AuthenticationException;

import javafx.fxml.LoadException;

@WebService
public interface JSTABanken {
    String sayHi(String text) throws TimeoutException;
    @WebMethod(operationName="createCustomer")
    Customer createCustomer(@WebParam(name="name") String name) throws CustomerExistsFault, TimeoutException, NullOrEmptyValueException;
    @WebMethod(operationName="insertMoney")
    Customer insertMoney(@WebParam(name="name") String name, @WebParam(name="amount") float amount) throws NoCustomerFound, TimeoutException, NullOrEmptyValueException;
    @WebMethod(operationName="withdrawMoney")
    Customer withdrawMoney(@WebParam(name="name") String name,@WebParam(name="amount") float amount) throws NoCustomerFound, InsufficientBalanceFault, TimeoutException, NullOrEmptyValueException;
    @WebMethod(operationName="getBalance")
    Customer getBalance(@WebParam(name="name") String name) throws NoCustomerFound, TimeoutException, NullOrEmptyValueException;
    @WebMethod(operationName="getCustomers")
    Customer[] getCusomers() throws NoCustomerFound, TimeoutException;
    @WebMethod(operationName="getCustomersSecure")
    Customer[] getCusomersSecure() throws NoCustomerFound, AuthenticationException, TimeoutException;
    @WebMethod(operationName="robTheBank")
    void robTheBank();
}

