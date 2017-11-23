package se.jsta.banken;

import java.util.concurrent.TimeoutException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.AuthenticationException;

@WebService
public interface SoapBank {
    String sayHi(String text) throws Exception;
    @WebMethod(operationName="createCustomer")
    Customer createCustomer(@WebParam(name="name") String name) throws Exception;
    @WebMethod(operationName="insertMoney")
    Customer insertMoney(@WebParam(name="name") String name, @WebParam(name="amount") float amount) throws Exception;
    @WebMethod(operationName="withdrawMoney")
    Customer withdrawMoney(@WebParam(name="name") String name,@WebParam(name="amount") float amount) throws  Exception;
    @WebMethod(operationName="getBalance")
    Customer getBalance(@WebParam(name="name") String name) throws Exception;
    @WebMethod(operationName="getCustomers")
    Customer[] getCusomers() throws NoCustomerFound, Exception;
    @WebMethod(operationName="getCustomersSecure")
    Customer[] getCusomersSecure() throws Exception;
    @WebMethod(operationName="robTheBank")
    void robTheBank();
}

