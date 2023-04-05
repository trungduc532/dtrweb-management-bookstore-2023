package dtr.web.management.bookshop.web.application;
//package app;
//
//import java.util.Scanner;
//
//import action.system.CommonHandle;
//import action.system.HandleCartItem;
//import action.system.HandleChoiceBook;
//import action.system.HandleCustomer;
//import action.system.HandleShoppingCart;
//import menu.Menu;
//
//public class BookShopApp {
//
//	private static final Scanner scanner = new Scanner(System.in);
//	public static void main(String[] args) {
//
//		try {
//			/**
//			 * Prepare data 
//			 * 1. Create BOOK_INFORMATION table on db <br>
//			 * 2. Add data in table: Copy from Data.txt file and run statement below <br>
//			 */
//			// BookManagement.addAListBookFromConsole(conn);  // In the first one, remove comment to set default value.
//			
//			// Run
//			while (true) {
//				Menu.menuSystem();
//				int choice = CommonHandle.inputChoice();
//				switch (choice) {
//					case 1:
//						HandleCustomer.handleRequestToCustomer();
//						break;
//					case 2:
//						HandleChoiceBook.handleRequestWithBook();
//						break;
//					case 3: 
//						HandleCartItem.handleRequestToCartItem();
//						break;
//					case 4:
//						HandleShoppingCart.handleRequestShoppingCart();
//						break;
//					default:
//						System.out.println("CHOICE INCORECT.");
//						Boolean answer = CommonHandle.continueProgram();
//						if(!answer)
//							CommonHandle.cleanScreen();
//							break;
//				}
//			}
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}