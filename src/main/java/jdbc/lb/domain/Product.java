package jdbc.lb.domain;

public class Product {
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String title;
	
	public Product(int id, String title, float price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	float price;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Product() {}
	
	public float getPrice() {
		return price;
	}
	
	public Product(String title, float price) {
		this.title = title;
		this.price = price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
}
