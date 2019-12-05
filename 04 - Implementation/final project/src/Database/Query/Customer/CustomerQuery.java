package Database.Query.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Database.Customer.Customer;

public class CustomerQuery {

    public LinkedList<Customer> queryAllCustomers() {
	LinkedList<Customer> customers = new LinkedList<Customer>();
	try {
	    String url = "jdbc:sqlite:./bs.db";
	    Connection con = DriverManager.getConnection(url);
	    Statement stmt = con.createStatement();

	    ResultSet rset = stmt.executeQuery("SELECT * FROM Customer");
	    while (rset.next()) {
		Customer customer = new Customer();
		customer.customerId = rset.getInt(1);
		customer.name = rset.getString(2);
		customer.Telphone = rset.getString(3);
		customer.VIPLevel = rset.getInt(4);
		customer.description = rset.getString(5);
		System.out.println(customer);
		customers.add(customer);
	    }
	    rset.close();
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return customers;
    }

    public void InsertCustomer(Customer customer) {
	String sql = "INSERT INTO Customer VALUES (null," + customer.name + "," + customer.Telphone + ","
		+ customer.VIPLevel + "," + customer.description + ") ;";
	executeStatement(sql);
    }

    public void executeStatement(String sql) {
	System.out.println(sql);
	String url = "jdbc:sqlite:./bs.db";
	try (Connection conn = DriverManager.getConnection(url)) {
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
	    }
	} catch (SQLException e) {
	    System.err.println("fail to execute " + sql);
	    e.printStackTrace();
	}
    }

}
