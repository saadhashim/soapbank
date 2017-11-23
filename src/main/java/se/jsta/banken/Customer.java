package se.jsta.banken;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
public class Customer implements Serializable{
	 @XmlElement(required = true)
	private String name;
	 @XmlElement(required = true)
	private float balance;
	
    @Override
    public String toString(){
        return "Customer{name="+name+",balance="+balance +"}";
    }

	public Customer(String name, float balance){
		this.name = name;
		this.balance = balance;
	}
	
	public Customer (){
		name = "";
		balance = 0;
	}
	
	public String getName()
	{
		return name;
	}

	
	public float getBalance(){
		return balance;
	}

}
