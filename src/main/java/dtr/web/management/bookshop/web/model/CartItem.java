/**
 * 59102901
 */
package dtr.web.management.bookshop.web.model;

/**
 * Cart Item
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class CartItem {
	private Book book;
	private int quantity;
	private float price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
		
}
