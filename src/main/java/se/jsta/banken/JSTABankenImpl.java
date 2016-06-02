
package se.jsta.banken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.AuthenticationException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.jaxws.context.WrappedMessageContext;
import org.apache.cxf.message.Message;
import org.w3c.dom.Element;

import javafx.fxml.LoadException;

@WebService(endpointInterface = "se.jsta.banken.JSTABanken")
public class JSTABankenImpl implements JSTABanken {

	public String sayHi(String text) throws TimeoutException {
		DBHelper.initDB();
		return "Hello " + text;
	}

	public Customer createCustomer(String name) throws CustomerExistsFault, TimeoutException, NullOrEmptyValueException {
		DBHelper.initDB();
		return DBHelper.createCustomer(name);
	}

	public Customer insertMoney(String name, float amount) throws NoCustomerFound, TimeoutException, NullOrEmptyValueException {
		DBHelper.initDB();

		if (amount <= 0) {
			throw new IllegalArgumentException("Beloppet är inte ett positivt tal");
		}
		float balance = DBHelper.getBalance(name).getBalance();
		return DBHelper.setBalance(name, balance + amount);
	}

	public Customer withdrawMoney(String name, float amount) throws NoCustomerFound, InsufficientBalanceFault, TimeoutException, NullOrEmptyValueException {
		DBHelper.initDB();

		if (amount <= 0) {
			throw new IllegalArgumentException("Beloppet är inte ett positivt tal");
		}
		float balance = DBHelper.getBalance(name).getBalance();
		if (balance - amount < 0) {
			throw new InsufficientBalanceFault();
		}
		return DBHelper.setBalance(name, balance - amount);

	}

	public Customer getBalance(String name) throws NoCustomerFound, TimeoutException, NullOrEmptyValueException {
		DBHelper.initDB();
		return DBHelper.getBalance(name);
	}
	
    public Customer[] getCusomers() throws NoCustomerFound, TimeoutException{
		DBHelper.initDB();
		return DBHelper.getCustomers();
    }
    
    public Customer[] getCusomersSecure() throws NoCustomerFound, AuthenticationException, TimeoutException{
    	if(!isAuthenticated()){
    		throw new AuthenticationException("Du behöver rätt användarnamn och lösen");
    	}
    	
		DBHelper.initDB();
		return DBHelper.getCustomers();
    }

    public void robTheBank(){
    	throw new SecurityException("Polisen skjuter dig och du fortsätter testa manuellt i nästa liv");
    }
    
    @Resource
    WebServiceContext wsctx;
    
	private boolean isAuthenticated() {
		MessageContext mctx = wsctx.getMessageContext();
		Message message = ((WrappedMessageContext) mctx).getWrappedMessage();
		List<Header> headers = CastUtils.cast((List<?>) message.get(Header.HEADER_LIST));
		System.out.println("Number of headers: " + headers.size());
		for (Iterator<Header> i = headers.iterator(); i.hasNext();) {
			Header h = i.next();
			Element n = (Element) h.getObject();
			System.out.println("header name=" + n.getLocalName());
			//System.out.println("header content=" + n.getTextContent());
			if(n.getLocalName().contains("BasicAuth")){
				String[] content = n.getTextContent().trim().split("\n");
				if(content.length<2){
					System.out.println("Too few rows");
					return false;
				}
				
				String username = content[content.length-2].trim();
				String password = content[content.length-1].trim();
				// Should validate username and password with database
				if (username.equalsIgnoreCase("system") && password.equalsIgnoreCase("password")) {
					return true;
				} else {
					return false;
				}
			}
		}
		System.out.println("No basic auth header");


		return false;

	}

}
