package se.jsta.banken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	private static String dbConnectionName = "jdbc:sqlite:jstabanken.db";

	public static void initDB(){
		createTableIfNotExist();
	}
	
	public static void executeUpdate(String sql){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(dbConnectionName);
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      stmt = c.createStatement();
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("SQL executed created successfully");
	}
	
	private static void createTableIfNotExist(){
		if(!isTableAlreadyCreted()){
			  Connection c = null;
			    Statement stmt = null;
			    try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection(dbConnectionName);
			      System.out.println("Opened database successfully");

			      stmt = c.createStatement();
			      String sql = "CREATE TABLE CUSTOMERS " +
			                   "(ID INT PRIMARY KEY     NOT NULL," +
			                   " NAME           TEXT    NOT NULL, " + 
			                   " BALANCE            REAL     NOT NULL)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.close();
			      
			      executeUpdate("INSERT INTO CUSTOMERS (ID,NAME,BALANCE) " +
		                   "VALUES (1, 'Saad', 20000.2);");
			      executeUpdate("INSERT INTO CUSTOMERS (ID,NAME,BALANCE) " +
		                   "VALUES (2, 'Rickard', 20055.2);");
			    } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			    }
			    System.out.println("Table created successfully");
		}
	}
	
	
	  private static boolean isTableAlreadyCreted()
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection(dbConnectionName);
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT name FROM sqlite_master WHERE type='table' AND name='CUSTOMERS';" );
	      boolean exist = false;
	      while ( rs.next() ) {
	    	  exist = true;
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return exist;
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	    return false;
	  }
	  
	  private static int getNextId(){
	      System.out.println("Getting the next id");

		   Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(dbConnectionName);
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM CUSTOMERS" );
		      int lastIndex = 0;
		      while ( rs.next() ) {
		    	  lastIndex = rs.getInt(1);
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      return lastIndex + 1;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
		    return 0;
	  }
	  
	  private static boolean isCustomerExist(String name){
	      System.out.println("Checking if customer exist");
		  Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(dbConnectionName);
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT name FROM CUSTOMERS WHERE name='"+name+"';" );
		      boolean exist = false;
		      while ( rs.next() ) {
			      System.out.println("Found customer");
		    	  exist = true;
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      if(exist == false){
			      System.out.println("Found no customer");
		      }
		      return exist;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
		    return false;
	  }
	  
	  
	  public static boolean createCustomer(String name){
		  if(isCustomerExist(name)){
			  return false;
		  }
		  int index = getNextId();
	      executeUpdate("INSERT INTO CUSTOMERS (ID,NAME,BALANCE) " +
                  "VALUES ("+ index +", '"+ name +"', 0);");
	      return true;
	  }
	  
	  public static float getBalance(String name){
	      System.out.println("Getting balance for " + name);

		  if(!isCustomerExist(name)){
		      System.out.println("Could not find the customer");

			  return -1;
		  }
		  Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection(dbConnectionName);
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM CUSTOMERS WHERE name='"+name+"';" );
		      float balance = -1;
		      while ( rs.next() ) {
	    	 
		    	  balance = rs.getFloat("balance");
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      return balance;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
		    return -1;
	  }
	
	 public static boolean setBalance(String name, float balance){
		 if(!isCustomerExist(name)){
			 return false;
		 }
		 
		 executeUpdate("UPDATE CUSTOMERS set balance = "+ balance + " where NAME = '"+name+"';");
		 return true;
	 }

	
}
