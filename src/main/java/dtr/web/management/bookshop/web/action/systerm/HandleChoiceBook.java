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
import dtr.web.management.bookshop.web.action.controller.BookSearch;
import dtr.web.management.bookshop.web.menu.Menu;
import dtr.web.management.bookshop.web.model.Book;

/**
 * 
 * @author Trung Duc
 * @see 10-2022
 *
 */
public class HandleChoiceBook {
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
	 * Handle request with book
	 * 
	 * @throws Exception
	 */
	public static void handleRequestWithBook() throws Exception {
		setConnection();
		while (true) {
			Menu.menuBook();
			int choice = CommonHandle.inputChoice();
			switch (choice) {
			case 1:
				BookManagement.addBook(conn);
				break;
			case 2:
				BookManagement.addAListBook(conn, null);
				break;
			case 3:
				BookManagement.addAListBookFromConsole(conn);
				break;
			case 4:
				handleUpdate();
				break;
			case 5:
				handleSearchByBookId();
				break;
			case 6:
				handleSearchByBookTitle();
				break;
			case 7:
				handleSearchByTitleAndAuthor();
				break;
			case 8: 
				handleDeleteBookByBookId();
				break;
			case 9: 
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
	
	private static final void  handleUpdate() {
		try {
			System.out.print("INPUT BOOK_ID YOU WANT TO UPDATE: ");
			Integer bookId = Integer.parseInt(scanner.nextLine());
			while (true) {
				if (bookId == (int) bookId) {
					BookManagement.update(conn, bookId);
					break;
				} else {
					System.out.println("INPUT VALUE INCORECT FORMAT. ");
					System.out.print("INPUT BOOK_ID YOU WANT TO UPDATE AGAIN: ");
					bookId = Integer.parseInt(scanner.nextLine());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final void handleSearchByBookId() {
		try {
			System.out.print("INPUT BOOK_ID YOU WANT TO SEARCH: ");
			Integer bookId = Integer.parseInt(scanner.nextLine());
			while (true) {
				if ( bookId == (int)bookId ) {
					Book book = BookSearch.searchByBookId(conn, bookId);
					book.showInfo();
					break;
				} else {
					System.out.println("INPUT VALUE INCORECT FORMAT. ");
					System.out.print("INPUT BOOK_ID YOU WANT TO SEARCH AGAIN: ");
					bookId = Integer.parseInt(scanner.nextLine());
				}
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	private static final void handleSearchByBookTitle() {
		try {
			System.out.print("INPUT TITLE OF BOOK YOU WANT TO SEARCH: ");
			String title = scanner.nextLine().trim().toUpperCase();
			List<Book> listBook = BookSearch.searchByBookTitle(conn, title);
			for (Book book : listBook) {
				book.showInfo();
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	private static final void handleSearchByTitleAndAuthor() {
		try {
			System.out.print("INPUT AUTHOR NAME'S: ");
			String author = scanner.nextLine();
			System.out.println();
			System.out.print("INPUT TITLE OF BOOK: ");
			String title = scanner.nextLine();
			BookSearch.searchByTitleAndAuthor(conn, title, author);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	private static final void handleDeleteBookByBookId() throws SQLException {
		System.out.print("INPUT BOOK_ID YOU WANT TO DELETE: ");
		Integer bookId = Integer.parseInt(scanner.nextLine());
		while (true) {
			if (bookId == (int)bookId) {
				Book book = BookSearch.searchByBookId(conn, bookId);
				book.showInfo();
				System.out.print("ARE YOU SURE DELETE THIS BOOK?(Y/N): ");
				String answer = scanner.nextLine();
				if(answer.equalsIgnoreCase("Y")) {
					BookManagement.deleteBook(conn, bookId);
					break;
				}
			} else {
				System.out.println("INPUT VALUE INCORECT FORMAT. ");
				System.out.print("INPUT BOOK_ID YOU WANT TO SEARCH AGAIN: ");
				bookId = Integer.parseInt(scanner.nextLine());
			}
		}
	}
}
