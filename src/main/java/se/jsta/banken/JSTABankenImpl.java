
package se.jsta.banken;

import javax.jws.WebService;

@WebService(endpointInterface = "se.jsta.banken.JSTABanken")
public class JSTABankenImpl implements JSTABanken {

	public String sayHi(String text) {
		DBHelper.initDB();
		return "Hello " + text;
	}

	public boolean createCustomer(String name) {
		DBHelper.initDB();
		return DBHelper.createCustomer(name);
	}

	public boolean insertMoney(String name, float amount) {
		DBHelper.initDB();

		if (amount <= 0) {
			return false;
		}
		float balance = DBHelper.getBalance(name);
		return DBHelper.setBalance(name, balance + amount);
	}

	public boolean withdrawMoney(String name, float amount) {
		DBHelper.initDB();

		if (amount <= 0) {
			return false;
		}
		float balance = DBHelper.getBalance(name);
		if (balance - amount < 0) {
			return false;
		}
		return DBHelper.setBalance(name, balance - amount);

	}

	public float getBalance(String name) {
		DBHelper.initDB();
		return DBHelper.getBalance(name);
	}

}
