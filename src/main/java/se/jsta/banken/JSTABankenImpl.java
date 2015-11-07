
package se.jsta.banken;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "se.jsta.banken.JSTABanken")
public class JSTABankenImpl implements JSTABanken {

	public String sayHi(String text) {
		DBHelper.initDB();
		return "Hello " + text;
	}

	public Customer createCustomer(String name) throws CustomerExistsFault {
		DBHelper.initDB();
		return DBHelper.createCustomer(name);
	}

	public Customer insertMoney(String name, float amount) throws NoCustomerFound {
		DBHelper.initDB();

		if (amount <= 0) {
			return null;
		}
		float balance = DBHelper.getBalance(name).getBalance();
		return DBHelper.setBalance(name, balance + amount);
	}

	public Customer withdrawMoney(String name, float amount) throws NoCustomerFound, InsufficientBalanceFault {
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

	public Customer getBalance(String name) throws NoCustomerFound {
		DBHelper.initDB();
		return DBHelper.getBalance(name);
	}
	
    public Customer[] getCusomers() throws NoCustomerFound{
		DBHelper.initDB();
		return DBHelper.getCustomers();
    }

    public void robTheBank(){
    	throw new SecurityException("Polisen skjuter dig och du fortsätter testa manuellt i nästa liv");
    }


}
