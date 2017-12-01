
package se.jsta.banken;
import javax.jws.WebService;

@WebService(endpointInterface = "se.jsta.banken.SoapBank")
public class SoapBankImpl implements SoapBank {

	public String sayHi(String text) throws Exception {
		DBHelper.initDB();
		return "Hello " + text;
	}

	public Customer createCustomer(String name) throws Exception {
		DBHelper.initDB();
		return DBHelper.createCustomer(name);
	}

	public Customer insertMoney(String name, float amount) throws Exception{
		DBHelper.initDB();
		

		if (amount <= 0) {
			throw new IllegalArgumentException("The amount should be positive");
		}
		float balance = DBHelper.getBalance(name).getBalance();
		return DBHelper.setBalance(name, balance + amount);
	}

	public Customer withdrawMoney(String name, float amount) throws Exception {
		DBHelper.initDB();

		if (amount <= 0) {
			throw new IllegalArgumentException("The amount should be positive");
		}
		float balance = DBHelper.getBalance(name).getBalance();
		if (balance - amount < 0) {
			throw new InsufficientBalanceFault();
		}
		return DBHelper.setBalance(name, balance - amount);

	}

	public Customer getBalance(String name) throws Exception {
		DBHelper.initDB();
		return DBHelper.getBalance(name);
	}
	
    public Customer[] getCusomers() throws Exception{
		DBHelper.initDB();
		return DBHelper.getCustomers();
    }


    public void robTheBank(){
    	throw new SecurityException("You get shot by the police and spend your life testing manually");
    }

    

}
