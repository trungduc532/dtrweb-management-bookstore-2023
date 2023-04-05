package dtr.web.management.bookshop.web.common;

public class DtrKey {
	
	// Book Key
	public static final String BOOK_ID = "BOOK_ID";
	public static final String BOOK_TITLE  = "BOOK_TITLE";
	public static final String BOOK_AUTHOR = "AUTHOR";
	public static final String BOOK_TYPE = "BOOK_TYPE";
	public static final String BOOK_PUBLISHER = "PUBLISHER";
	public static final String BOOK_PUBLISH_YEAR = "BOOK_PUBLISH_YEAR";
	public static final String PRICE = "PRICE";
	
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	
	// Customer key
	public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
	public static final String CUSTOMER_USER_NAME = "CUSTOMER_USER_NAME";
	public static final String CUSTOMER_PASSWORD = "CUSTOMER_PASSWORD";
	public static final String SHIPPING_ADDRESS = "SHIPPING_ADDRESS";
	public static final String BILLING_ADDRESS = "BILLING_ADDRESS";
	
	// database information
	public static final String DATABASE_NAME = "BookShop";
	public static final String DB_PASSWORD = "1234567890d";
	
	// regex password key
	public static final String PASSWORD_REGEX = "^[a-zA-Z0-9&&(@|#|/|\\]$";
	
	
	public static void printInfo() {
		System.out.println("|  CART_ID   |      CUSTOMER      |SHIPPING_FEE|     TOTAL     |   PAYMENT_METHOD  |\n");
	}
	
	
}
