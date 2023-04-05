/**
 * 59102901
 */
package dtr.web.management.bookshop.web.action.systerm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dtr.web.management.bookshop.web.connection.ConnectionDB;
import dtr.web.management.bookshop.web.action.controller.BookManagement;
import dtr.web.management.bookshop.web.action.controller.CustomerManagement;
import dtr.web.management.bookshop.web.action.controller.CustomerSearch;
import dtr.web.management.bookshop.web.menu.Menu;
import dtr.web.management.bookshop.web.model.Customer;

/**
 * Handle Customer
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class HandleCustomer {
	
	private static Scanner scanner = new Scanner(System.in);

	private static Connection conn;
	
	/**
	 * Set connect DB
	 * 
	 * @throws Exception
	 */
	private static void setConnection() throws Exception {
		conn = ConnectionDB.getConnectDatabase();
	}
	
	/**
	 * Handle request customer
	 * 
	 * @throws Exception
	 */
	public static void handleRequestToCustomer() throws Exception {
		setConnection();
		while (true) {
			Menu.menuCustomer();
			int choice = CommonHandle.inputChoice();
			switch (choice) {
			case 1:
				CustomerManagement.addCustomer(conn);
				break;
			case 2:
				CustomerManagement.addAListCustomerFromConsole(conn);
				break;
			case 3:
				handleUpdate();
				break;
			case 4:
				handleSearchByCustomerId();
				break;
			case 5:
				handleSearchByCustomerName();
				break;
			case 6: 
				handleDeleteCustomer();
				break;
			case 7: 
				CommonHandle.cleanScreen();
				break;
			}
			final boolean continuePro = CommonHandle.continueProgram();
			if(!continuePro) {
				CommonHandle.cleanScreen();
				break;
			}
				
		}
		ConnectionDB.closeConnectionDate(conn);
		
	}
	/**
	 * Handle update customer
	 * 
	 */
	private static final void handleUpdate() {
		try {
			System.out.print("INPUT CUSTOMER_ID YOU WANT TO UPDATE: ");
			Integer customerId = Integer.parseInt(scanner.nextLine());
			while (true) {
				if (customerId == (int) customerId) {
					CustomerManagement.updateCustomer(conn, customerId);
					break;
				} else {
					System.out.println("INPUT VALUE INCORECT FORMAT. ");
					System.out.print("INPUT CUSTOMER_ID YOU WANT TO UPDATE AGAIN: ");
					customerId = Integer.parseInt(scanner.nextLine());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final void handleSearchByCustomerId() {
		try {
			System.out.print("INPUT CUSTOMER_ID YOU WANT TO SEARCH: ");
			Integer customerId = Integer.parseInt(scanner.nextLine());
			while (true) {
				if ( customerId == (int) customerId ) {
					Customer customer = CustomerSearch.searchCustomerWithCustomerId(conn, customerId);
					customer.showInfoCustomer();
					break;
				} else {
					System.out.println("INPUT VALUE INCORECT FORMAT. ");
					System.out.print("INPUT CUSTOMER_ID YOU WANT TO SEARCH AGAIN: ");
					customerId = Integer.parseInt(scanner.nextLine());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final void handleSearchByCustomerName() {
		try {
			System.out.print("INPUT NAME OF CUSTOMER YOU WANT TO SEARCH: ");
			String name = scanner.nextLine().trim().toUpperCase();
			List<Customer> listCustomer = CustomerSearch.searchCustomerByName(conn, name);
			for (Customer customer : listCustomer) {
				customer.showInfoCustomer();
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final void handleDeleteCustomer() throws SQLException {
		System.out.print("INPUT CUSTOMER_ID YOU WANT TO DELETE: ");
		Integer customerId = Integer.parseInt(scanner.nextLine());
		while (true) {
			if (customerId == (int) customerId) {
				Customer customer = CustomerSearch.searchCustomerWithCustomerId(conn, customerId);
				customer.showInfoCustomer();
				System.out.print("ARE YOU SURE DELETE THIS CUSTOMER? (Y/N): ");
				String answer = scanner.nextLine();
				if(answer.equalsIgnoreCase("Y")) {
					BookManagement.deleteBook(conn, customerId);
					break;
				}
			} else {
				System.out.println("INPUT VALUE INCORECT FORMAT. ");
				System.out.print("INPUT CUSTOMER_ID YOU WANT TO SEARCH AGAIN: ");
				customerId = Integer.parseInt(scanner.nextLine());
			}
		}
	}
}
