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

import dtr.web.management.bookshop.web.model.Book;

/**
 * 
 * @author Trung Duc
 * @version 1.0
 * @since 2022-10
 *
 */
public class BookSearch {
	
	/**
	 * Search bookinformation by BooId
	 * @param conn
	 * @param bookId
	 * @return book
	 * @throws SQLException
	 */
	public static final Book searchByBookId(Connection conn, int bookId) throws SQLException {
		Book book = new Book();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION ");
		query.append("WHERE BOOK_ID = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				book.setBookId(rs.getInt(columnIndex++));
				book.setTitle(rs.getString(columnIndex++));
				book.setAuthor(rs.getString(columnIndex++));
				book.setType(rs.getString(columnIndex++));
				book.setPublishYear(rs.getDate(columnIndex++));
				book.setPublisher(rs.getString(columnIndex++));
				book.setPrice(rs.getFloat(columnIndex++));
				return book;
			}
		} finally {
			System.out.print("");
		}
		return null;
	}
	
	/**
	 * Search book by title
	 * @param conn
	 * @param Title
	 * @return
	 * @throws SQLException
	 */
	public static final List<Book> searchByBookTitle(Connection conn, String title) throws SQLException {
		List<Book> listBook = new ArrayList<Book>();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION ");
		query.append("WHERE TITLE = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, title);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				final Book book = new Book();
				book.setBookId(rs.getInt(columnIndex++));
				book.setTitle(rs.getString(columnIndex++));
				book.setAuthor(rs.getString(columnIndex++));
				book.setType(rs.getString(columnIndex++));
				book.setPublishYear(rs.getDate(columnIndex++));
				book.setPublisher(rs.getString(columnIndex++));
				book.setPrice(rs.getFloat(columnIndex++));
				listBook.add(book);
				columnIndex = 1;
			}
			return listBook;
		} finally {
			System.out.print("");
		}
	}
	
	/**
	 * Search by book title and author
	 * @param conn
	 * @param title
	 * @param author
	 * @return
	 * @throws SQLException
	 */
	public static final Book searchByTitleAndAuthor(Connection conn, String title, String author) throws SQLException {
		final Book book = new Book();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION ");
		query.append("WHERE TITLE = ? ,");
		query.append(" AUTHOR = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, title);
			ps.setString(2, author);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				book.setBookId(rs.getInt(columnIndex++));
				book.setTitle(rs.getString(columnIndex++));
				book.setAuthor(rs.getString(columnIndex++));
				book.setType(rs.getString(columnIndex++));
				book.setPublishYear(rs.getDate(columnIndex++));
				book.setPublisher(rs.getString(columnIndex++));
				book.setPrice(rs.getFloat(columnIndex++));
				return book;
			}
		} finally {
			System.out.print("");
		}
		return null;
	}

}
