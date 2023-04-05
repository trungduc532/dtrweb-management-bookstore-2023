/**
 * 59102901
 */
package dtr.web.management.bookshop.web.action.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtr.web.management.bookshop.web.model.Customer;

/**
 * Search customer information
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class CustomerSearch {
	public static final Customer searchCustomerWithCustomerId(Connection conn, int customerId) throws SQLException {
		Customer customer = new Customer();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("CUSTOMER_INFORMATION ");
		query.append("WHERE CUSTOMER_ID = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				customer.setCustomerId(rs.getInt(columnIndex++));
				customer.setName(rs.getString(columnIndex++));
				customer.setUserName(rs.getString(columnIndex++));
				customer.setPassword(rs.getString(columnIndex++));
				customer.setShippingAddress(rs.getString(columnIndex++));
				customer.setBillingAddress(rs.getString(columnIndex++));
				return customer;
			}
		} finally {
			System.out.print("");
		}
		return null;
	}
	
	public static final List<Customer> searchCustomerByName(Connection conn, String name) throws SQLException {
		List<Customer> listCustomer = new ArrayList<Customer>();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("CUSTOMER_INFORMATION ");
		query.append("WHERE CUSTOMER_NAME = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, name);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				final Customer customer = new Customer();
				customer.setCustomerId(rs.getInt(columnIndex++));
				customer.setName(rs.getString(columnIndex++));
				customer.setUserName(rs.getString(columnIndex++));
				customer.setPassword(rs.getString(columnIndex++));
				customer.setShippingAddress(rs.getString(columnIndex++));
				customer.setBillingAddress(rs.getString(columnIndex++));
				listCustomer.add(customer);
				columnIndex = 1;
			}
			return listCustomer;
		} finally {
			System.out.print("");
		}
	}
	
}
