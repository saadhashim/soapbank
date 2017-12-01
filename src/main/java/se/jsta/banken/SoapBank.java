package se.jsta.banken;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
    Customer[] getCusomers() throws Exception;
    @WebMethod(operationName="robTheBank")
    void robTheBank();
}

