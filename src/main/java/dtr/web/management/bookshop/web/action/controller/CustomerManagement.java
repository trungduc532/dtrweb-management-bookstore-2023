/**
 * 59102901
 */
package dtr.web.management.bookshop.web.action.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import dtr.web.management.bookshop.web.action.systerm.CommonHandle;
import dtr.web.management.bookshop.web.common.DtrKey;
import dtr.web.management.bookshop.web.model.Customer;

/**
 * Customer Management
 * @author Trung Duc
 * @see 2022/10
 *
 */
public class CustomerManagement {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Create a customer
	 * 
	 * @return
	 */
	private static final Customer createCustomer() {
		Customer customer = new Customer();
		
		System.out.print(DtrKey.CUSTOMER_NAME + ": ");
		customer.setName(scanner.nextLine().toUpperCase().trim());
		
		System.out.print(DtrKey.CUSTOMER_USER_NAME + ": ");
		customer.setUserName(scanner.nextLine().trim());
		
		System.out.print(DtrKey.CUSTOMER_PASSWORD + ": ");
		customer.setPassword(CommonHandle.inputPassword());
		
		System.out.print(DtrKey.SHIPPING_ADDRESS + ": ");
		customer.setShippingAddress(scanner.nextLine().toUpperCase().trim());
		
		System.out.print(DtrKey.BILLING_ADDRESS + ": ");
		customer.setBillingAddress(scanner.nextLine().trim().toUpperCase());

		return customer;
	}
	
	private static Customer createAnewCustomerForUpdate(Customer customer) {
		System.out.print("NEW NAME: ");
		customer.setName(scanner.nextLine().trim().toUpperCase());
		
		System.out.print("NEW USER NAME: ");
		customer.setUserName(scanner.nextLine());
		
		System.out.print("NEW PASSWORD: ");
		customer.setPassword(CommonHandle.inputPassword());
		
		System.out.print("NEW SHIPPING ADDRESS: ");
		customer.setShippingAddress(scanner.nextLine().trim().toUpperCase());
		
		System.out.print("NEW BIILING ADDRESS: ");
		customer.setBillingAddress(scanner.nextLine());
		return customer;
	}
	
	public static void addCustomer(Connection conn) throws SQLException {

		System.out.println("========================= ADD A CUSTOMER =======================");

		StringBuilder query = new StringBuilder();
		Customer customer = CustomerManagement.createCustomer();
		query.append("INSERT INTO CUSTOMER_INFORMATION ");
		query.append("(CUSTOMER_NAME, CUSTOMER_USER_NAME, CUSTOMER_PASSWORD, SHIPPING_ADDRESS, BILLING_ADDRESS)");
		query.append("VALUES ( ?, ?, ?, ?, ? );");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setString(bindIndex++, customer.getName());
			ps.setString(bindIndex++, customer.getUserName());
			ps.setString(bindIndex++, customer.getPassword());
			ps.setString(bindIndex++, customer.getShippingAddress());
			ps.setString(bindIndex++, customer.getBillingAddress());
			ps.executeUpdate();
			System.out.println("Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}
	/**
	 * Create data default on database
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void addAListCustomerFromConsole(Connection conn) throws Exception {
		System.out.println("INPUT DATA FROM CONSOLE FILE: ");
		InputStreamReader inputData = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputData);
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO CUSTOMER_INFORMATION ");
			query.append("(CUSTOMER_NAME, CUSTOMER_USER_NAME, CUSTOMER_PASSWORD, SHIPPING_ADDRESS, BILLING_ADDRESS) ");
			query.append("VALUES ( ?, ?, ?, ?, ? );");
			
			String line = reader.readLine();
			while (line != null) {
				String[] listItem = line.split(",");
				if (listItem[0].equals("***")) {
					break;
				} else {
					PreparedStatement ps = null;
					ps = conn.prepareStatement(query.toString());
					int bindIndex = 1;
					ps.setString(bindIndex++, listItem[0]);
					ps.setString(bindIndex++, listItem[1]);
					ps.setString(bindIndex++, listItem[2]);
					ps.setString(bindIndex++, listItem[3]);
					ps.setString(bindIndex++, listItem[4]);
					ps.executeUpdate();
				}
				line = reader.readLine();
			}
			reader.close();

			System.out.println("Success.");
			System.out.println("================================================================");
		} finally {
			System.out.print("");
		}
	}
	
	/**
	 * Add customer with customerId input param
	 * 
	 * @param conn
	 * @param customerId
	 * @throws SQLException
	 */
	public static void addCustomerWithCustomerId(Connection conn, int customerId) throws SQLException {
		StringBuilder query = new StringBuilder();
		Customer customer = createCustomer();
		query.append("SET IDENTITY_INSERT CUSTOMER_INFORMATION ON; ");
		query.append("INSERT INTO CUSTOMER_INFORMATION ");
		query.append("(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_USER_NAME, CUSTOMER_PASSWORD, SHIPPING_ADDRESS, BILLING_ADDRESS)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ?);");
		query.append("SET IDENTITY_INSERT CUSTOMER_INFORMATION OFF; ");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setInt(bindIndex++, customerId);
			ps.setString(bindIndex++, customer.getName());
			ps.setString(bindIndex++, customer.getUserName());
			ps.setString(bindIndex++, customer.getPassword());
			ps.setString(bindIndex++, customer.getShippingAddress());
			ps.setString(bindIndex++, customer.getBillingAddress());
			ps.executeUpdate();
			System.out.println("Add Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}
	}
	
	public static final void updateCustomer(Connection conn, int customerId) throws SQLException {
		Customer customer = CustomerSearch.searchCustomerWithCustomerId(conn, customerId);
		if (customer == null) {
			addCustomerWithCustomerId(conn, customerId);
		} else {
			customer = createAnewCustomerForUpdate(customer);
			try {
				final StringBuilder query = new StringBuilder();
				query.append("SET IDENTITY_INSERT BOOK_INFORMATION ON;");
				query.append("DELETE FROM CUSTOMER_INFORMATION WHERE CUSTOMER_ID = " + customerId + "; ");
				query.append("INSERT INTO CUSTOMER_INFORMATION ");
				query.append("(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_USER_NAME, CUSTOMER_PASSWORD, SHIPPING_ADDRESS, BILLING_ADDRESS)");
				query.append("VALUES ( ?, ?, ?, ?, ?, ?);");
				query.append("SET IDENTITY_INSERT CUSTOMER_INFORMATION OFF;");
				PreparedStatement ps = null;
				ps = conn.prepareStatement(query.toString());
				int bindIndex = 1;
				ps.setInt(bindIndex++, customerId);
				ps.setString(bindIndex++, customer.getName());
				ps.setString(bindIndex++, customer.getUserName());
				ps.setString(bindIndex++, customer.getPassword());
				ps.setString(bindIndex++, customer.getShippingAddress());
				ps.setString(bindIndex++, customer.getBillingAddress());
				ps.executeUpdate();
				System.out.println("Update success.");
			} finally {
				System.out.print("");
			}
		}
	}
	
	public static final void deleteCustomer(Connection conn, int customerId) throws SQLException {
		final StringBuilder query = new StringBuilder();
		query.append("DELETE FROM CUSTOMER_INFORMATION ");
		query.append("WHERE CUSTOMER_ID = ?");
		query.append(";");
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, customerId);
			ps.executeUpdate();

			System.out.println("Delete success.");
		} finally {
			System.out.print("");
		}

	}
}
