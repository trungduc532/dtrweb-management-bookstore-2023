package dtr.web.management.bookshop.web.model;

import java.util.List;

import dtr.web.management.bookshop.web.common.DtrKey;

public class ShoppingCart {
	private int cartId;
	private Customer customer;
	private float shippingFee;
	private float total;
	private String paymentMethod;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public float getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void addItem (Customer customer) {
		
	}
	public void displayCart(List<ShoppingCart> shoppingCart, int cartId) {
		int count = 0;
		for (ShoppingCart shopingCart : shoppingCart) {
			if(shopingCart.getCartId() == cartId) {
				DtrKey.printInfo();
				System.out.printf("|%12s|%20s|%12s|%20s|%20|", cartId, customer, shippingFee, total, paymentMethod);
				count++;
			} 
		}
		if(count == 0)
			System.out.println("CART_ID NOT EXIST.");
		
	}
	public void saveCart() {
		
	}
}
