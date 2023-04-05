package dtr.web.management.bookshop.web.model;

import java.sql.Date;


public class Book {
	private Integer bookId;
	private String title;
	private String author;
	private String type;
	private String publisher;
	private Date publishYear;
	private float price;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Date publishYear) {
		this.publishYear = publishYear;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Book(Integer bookId, String title, String author, String type, String publisher, Date publishYear, float price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.type = type;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.price = price;
	}

	public Book() {
		super();
	}

	public void showInfo() {
		System.out.println("***");
		System.out.println("BOOK ID= " + bookId + ", TITLE= " + title + ", AUTHOR= " + author + ", TYPE= " + type + ", PUBLISHER= "
				+ publisher + ", PUBLISH YEAR= " + publishYear + ", PRICE= " + price + "; ");
		System.out.println("***");
	}
	
	/**
	 * Show info with param >  1. Beatifull screen
	 * @param n
	 */
	public void showInfo(int n) {
		// TO DO: after
		System.out.println("BOOK ID= " + bookId + ", TITLE= " + title + ", AUTHOR= " + author + ", TYPE= " + type + ", PUBLISHER= "
				+ publisher + ", PUBLISH YEAR= " + publishYear + ", PRICE= " + price);
	}
	
	
}
