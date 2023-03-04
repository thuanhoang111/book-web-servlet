package model;

public class Book {
	
	private int id;
	private String bookName;
	private String NXB;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public float getPrice() {
		return price;
	}
	public Book(String bookName, String nXB, float price) {
		super();
		this.bookName = bookName;
		NXB = nXB;
		this.price = price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Book(int id, String bookName, String nXB, float price) {
		super();
		this.id = id;
		this.bookName = bookName;
		NXB = nXB;
		this.price = price;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", NXB=" + NXB + ", price=" + price + "]";
	}
	
}
