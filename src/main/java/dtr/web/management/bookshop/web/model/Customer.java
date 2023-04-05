/**
 * 59102901
 */
package dtr.web.management.bookshop.web.model;
/**
 * Customer
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class Customer {
	private int customerId;
	private String name;
	private String userName;
	private String password;
	private String shippingAddress;
	private String billingAddress;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public void showInfoCustomer() {
		System.out.println("***");
		System.out.println("CUSTOMER_ID = " + customerId + ", NAME = " + name + ", USER_NAME = " + userName + ", SHIPPING_ADDRESS = " + shippingAddress +
				"BILLING_ADDRESS = " + billingAddress );
		System.out.println("***");
	}
}
