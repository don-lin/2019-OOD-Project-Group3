package Database.Customer;

import com.sun.crypto.provider.DESCipher;

public class Customer{
	public int customerId;
	public String name;
	public String Telphone;
	public int VIPLevel;
	public String description;
	
	
	/**
	 * convert the customer to string
	 * @return a string
	 */
	@Override
	public String toString() {
		String result=new String();
		
		result="Customer Id: "+customerId+", name:"+name+" telphone:"+Telphone+" vipLevel: "+VIPLevel+" description:"+description;
		
		return result;
	}

}
