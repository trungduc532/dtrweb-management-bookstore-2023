/**
 * 59102901
 */
package dtr.web.management.bookshop.web.action.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dtr.web.management.bookshop.web.common.DtrKey;
import dtr.web.management.bookshop.web.model.Book;

/**
 * 
 * @author Trung Duc
 * @version 1.0
 * @since 2022-10
 *
 */
public class BookManagement {

	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Save function on DB
	 * 
	 * @param book
	 * @param conn
	 */
	public static void save(Book book, Connection conn) throws SQLException{
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO BOOK_INFORMATION ");
		query.append("(TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ? );");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setString(bindIndex++, book.getTitle());
			ps.setString(bindIndex++, book.getAuthor());
			ps.setString(bindIndex++, book.getType());
			ps.setDate(bindIndex++, book.getPublishYear());
			ps.setString(bindIndex++, book.getPublisher());
			ps.setFloat(bindIndex++, book.getPrice());
			ps.executeUpdate();
			System.out.println("Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}

	
	/**
	 * Add a book in data base
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void addBook(Connection conn) throws SQLException {
		System.out.println("=========================== ADD A BOOK =========================");

		StringBuilder query = new StringBuilder();
		Book book = BookManagement.createBook();
		query.append("INSERT INTO BOOK_INFORMATION ");
		query.append("(TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ? );");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setString(bindIndex++, book.getTitle());
			ps.setString(bindIndex++, book.getAuthor());
			ps.setString(bindIndex++, book.getType());
			ps.setDate(bindIndex++, book.getPublishYear());
			ps.setString(bindIndex++, book.getPublisher());
			ps.setFloat(bindIndex++, book.getPrice());
			ps.executeUpdate();
			System.out.println("Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}
	
	/**
	 * Add a book with bookId in data base
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void addBookWithBookId(Connection conn, int bookId) throws SQLException {

		StringBuilder query = new StringBuilder();
		Book book = createBook();
		query.append("SET IDENTITY_INSERT BOOK_INFORMATION ON; ");
		query.append("INSERT INTO BOOK_INFORMATION ");
		query.append("(BOOK_ID, TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ?, ? );");
		query.append("SET IDENTITY_INSERT BOOK_INFORMATION OFF; ");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setInt(bindIndex++, bookId);
			ps.setString(bindIndex++, book.getTitle());
			ps.setString(bindIndex++, book.getAuthor());
			ps.setString(bindIndex++, book.getType());
			ps.setDate(bindIndex++, book.getPublishYear());
			ps.setString(bindIndex++, book.getPublisher());
			ps.setFloat(bindIndex++, book.getPrice());
			ps.executeUpdate();
			System.out.println("Add Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}

	/**
	 * Add a list book in data base
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void addAListBook(Connection conn, List<Book> listBook) throws Exception {

		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO BOOK_INFORMATION ");
		query.append("(TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ? );");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			for (Book book : listBook) {
				ps.setString(bindIndex++, book.getTitle());
				ps.setString(bindIndex++, book.getAuthor());
				ps.setString(bindIndex++, book.getType());
				ps.setDate(bindIndex++, book.getPublishYear());
				ps.setString(bindIndex++, book.getPublisher());
				ps.setFloat(bindIndex, book.getPrice());
				ps.executeUpdate();
				bindIndex = 1;
			}
			System.out.println("Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}

	/**
	 * Add a list book in data base readline from console
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void addAListBookFromConsole(Connection conn) throws Exception {
		System.out.println("INPUT DATA FROM CONSOLE FILE: ");
		InputStreamReader inputData = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputData);
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO BOOK_INFORMATION ");
			query.append("(TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE) ");
			query.append("VALUES ( ?, ?, ?, ?, ?, ? );");
			
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

					SimpleDateFormat format = new SimpleDateFormat(DtrKey.FORMAT_DATE);
					java.util.Date date = format.parse(listItem[3]);
					java.sql.Date sqlDate = new Date(date.getTime());

					ps.setDate(bindIndex++, sqlDate);
					ps.setString(bindIndex++, listItem[4]);
					ps.setFloat(bindIndex++, Float.parseFloat(listItem[5]));
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
	 * Create a book
	 * 
	 * @return
	 */
	private static Book createBook() {
		Book book = new Book();
		System.out.print(DtrKey.BOOK_TITLE + ": ");
		book.setTitle(scanner.nextLine().toUpperCase().trim());
		System.out.print(DtrKey.BOOK_AUTHOR + ": ");
		book.setAuthor(scanner.nextLine().toUpperCase().trim());
		System.out.print(DtrKey.BOOK_TYPE + ": ");
		book.setType(scanner.nextLine().toUpperCase().trim());
		System.out.print(DtrKey.BOOK_PUBLISHER + ": ");
		book.setPublisher(scanner.nextLine().toUpperCase().trim());

		// INPUT PUBLISH_YEAR
		SimpleDateFormat format = new SimpleDateFormat(DtrKey.FORMAT_DATE);
		System.out.println("Enter date and time in the format yyyy-MM-dd");
		java.util.Date date = null;
		while (date == null) {
			System.out.print(DtrKey.BOOK_PUBLISH_YEAR + ": ");
			String line = scanner.nextLine().toUpperCase().trim();
			try {

				date = format.parse(line);
				java.sql.Date sqlDate = new Date(date.getTime());
				book.setPublishYear(sqlDate);
			} catch (ParseException e) {
				System.out.print(DtrKey.BOOK_PUBLISH_YEAR + "AGAIN: ");
			}
		}
		System.out.print(DtrKey.PRICE + ": ");
		book.setPrice(Float.parseFloat(scanner.nextLine()));

		return book;
	}

	/**
	 * Update funtion
	 * 
	 * @param conn
	 * @param bookId
	 * @throws SQLException
	 */
	public static final void update(Connection conn, int bookId) throws SQLException {
		Book book = BookSearch.searchByBookId(conn, bookId);
		if (book == null) {
			addBookWithBookId(conn, bookId);
		} else {
			book = createAnewBookForUpdate(book);
			try {
				final StringBuilder query = new StringBuilder();
				query.append("SET IDENTITY_INSERT BOOK_INFORMATION ON;");
				query.append("DELETE FROM BOOK_INFORMATION WHERE BOOK_ID = " + bookId + "; ");
				query.append("INSERT INTO BOOK_INFORMATION ");
				query.append("(BOOK_ID, TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE) ");
				query.append("VALUES ( ?, ?, ?, ?, ?, ?, ? ); ");
				query.append("SET IDENTITY_INSERT BOOK_INFORMATION OFF;");
				PreparedStatement ps = null;
				ps = conn.prepareStatement(query.toString());
				int bindIndex = 1;
				ps.setInt(bindIndex++, bookId);
				ps.setString(bindIndex++, book.getTitle());
				ps.setString(bindIndex++, book.getAuthor());
				ps.setString(bindIndex++, book.getType());
				ps.setDate(bindIndex++, book.getPublishYear());
				ps.setString(bindIndex++, book.getPublisher());
				ps.setFloat(bindIndex++, book.getPrice());
				ps.executeUpdate();
				System.out.println("Update success.");
			} finally {
				System.out.print("");
			}
		}
	}

	/**
	 * Delete a book
	 * 
	 * @param conn
	 * @param bookId
	 * @throws SQLException
	 */
	public static final void deleteBook(Connection conn, int bookId) throws SQLException {
		final StringBuilder query = new StringBuilder();
		query.append("DELETE FROM BOOK_INFORMATION ");
		query.append("WHERE BOOK_ID = ?");
		query.append(";");
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, bookId);
			ps.executeUpdate();

			System.out.println("Delete success.");
		} finally {
			System.out.print("");
		}

	}
	/**
	 * Create a new book for update function
	 * 
	 * @param book
	 * @return
	 */
	private static Book createAnewBookForUpdate(Book book) {
		System.out.print("NEW TITLE: ");
		book.setTitle(scanner.nextLine().trim().toUpperCase());
		System.out.print("NEW AUTHOR: ");
		book.setAuthor(scanner.nextLine().trim().toUpperCase());
		System.out.print("NEW TYPE: ");
		book.setType(scanner.nextLine().trim().toUpperCase());
		System.out.print("NEW PUBLISHER: ");
		book.setPublisher(scanner.nextLine().trim().toUpperCase());
		SimpleDateFormat format = new SimpleDateFormat(DtrKey.FORMAT_DATE);
		System.out.println("Enter date and time in the format yyyy-MM-dd");
		java.util.Date date = null;
		while (date == null) {
			System.out.print("NEW PUBLISH YEAR: ");
			String line = scanner.nextLine();
			try {

				date = format.parse(line);
				java.sql.Date sqlDate = new Date(date.getTime());
				book.setPublishYear(sqlDate);
			} catch (ParseException e) {
				System.out.print("NEW PUBLISH YEAR AGAIN: ");
			}
		}
		System.out.print("NEW PRICE: ");
		book.setPrice(Float.parseFloat(scanner.nextLine()));
		return book;
	}


}
