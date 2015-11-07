package se.jsta.banken;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface JSTABanken {
    String sayHi(String text);
    @WebMethod(operationName="createCustomer")
    Customer createCustomer(@WebParam(name="name") String name) throws CustomerExistsFault;
    @WebMethod(operationName="insertMoney")
    Customer insertMoney(@WebParam(name="name") String name, @WebParam(name="amount") float amount) throws NoCustomerFound;
    @WebMethod(operationName="withdrawMoney")
    Customer withdrawMoney(@WebParam(name="name") String name,@WebParam(name="amount") float amount) throws NoCustomerFound, InsufficientBalanceFault;
    @WebMethod(operationName="getBalance")
    Customer getBalance(@WebParam(name="name") String name) throws NoCustomerFound;
    @WebMethod(operationName="getCustomers")
    Customer[] getCusomers() throws NoCustomerFound;
    @WebMethod(operationName="robTheBank")
    void robTheBank();
}

