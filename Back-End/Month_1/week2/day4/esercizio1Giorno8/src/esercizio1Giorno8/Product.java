package esercizio1Giorno8;

public class Product {

	long id;
	String name;
	Category category;
	double price;
	
	public Product(long id, String name, Category category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	@Override
	public String toString() {
		String str = "id: " + this.id + " - Name: " + this.name + " - Category: " + this.category + " - Price: " + this.price + " €";
		return str;
	}
	
	public void applyDiscount() {
		double newPrice =  this.price - ((this.price*10)/100);
		System.out.println("id: " + this.id + " - Name: " + this.name + " - Category: " + this.category + " - Price: " + newPrice + " €");
	}
	
	
}
