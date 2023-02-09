package esercizio1Giorno8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;


public class Main {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<Product>();
		List<Order> orders = new ArrayList<Order>();

		products.add(new Product(1, "Cent'anni di solitudine", Category.BOOKS, 110));
		products.add(new Product(2, "Il Decamerone", Category.BOOKS, 130));
		products.add(new Product(3, "Delitto e castigo", Category.BOOKS, 10));
		products.add(new Product(4, "Odissea", Category.BOOKS, 25));

		products.add(new Product(5, "La piccola fiammiferaia", Category.BABY, 70));
		products.add(new Product(6, "Il giornalino di Gian Burrasca", Category.BABY, 5));
		products.add(new Product(7, "Il Piccolo Principe", Category.BABY, 10));
		products.add(new Product(8, "Io e il mio amico Vuoto", Category.BABY, 30));

		products.add(new Product(9, "Cappello", Category.BOYS, 60));
		products.add(new Product(10, "Bicicletta", Category.BOYS, 110));
		products.add(new Product(11, "Pallone", Category.BOYS, 5));
		products.add(new Product(12, "Skateboard", Category.BOYS, 200));

		Customer c1 = new Customer(232, "Simone Rossi", 1);
		Customer c2 = new Customer(233, "", 2);
		Customer c3 = new Customer(234, "Giorgio Verdi", 1);
		
		findBooks(products);
		findBaby(products);
		findBoys(products);
		
		Order o1 = new Order(8237, new ArrayList<Product>() {{
			add(new Product(1, "Cent'anni di solitudine", Category.BOOKS, 110));
			add(new Product(3, "Delitto e castigo", Category.BOOKS, 10));
			add(new Product(9, "Cappello", Category.BOYS, 60));
			add(new Product(6, "Il giornalino di Gian Burrasca", Category.BABY, 5));
		}}, c2, "Pending");
		
		Order o2 = new Order(8237, new ArrayList<Product>() {{
			add(new Product(1, "Cent'anni di solitudine", Category.BOOKS, 110));
			add(new Product(3, "Delitto e castigo", Category.BOOKS, 10));
			add(new Product(9, "Cappello", Category.BOYS, 60));
			add(new Product(6, "Il giornalino di Gian Burrasca", Category.BABY, 5));
		}}, c2, "Pending", "2023/02/14");
		
		orders.add(o1);
		orders.add(o2);
		
		orderList(orders);
		

	}

	static void findBooks(List<Product> prod) {
		Stream<Product> booksCategory = prod.stream()
											.filter(p -> p.category.equals(Category.BOOKS))
											.filter(p -> p.price > 100);
		System.out.println("-------------------------------------------------");
		System.out.println("Libri con prezzo maggiore a 100 €");
		System.out.println("-------------------------------------------------");
		booksCategory.forEach(b -> System.out.println(b));
	}
	
	static void findBaby(List<Product> prod) {
		Stream<Product> babyCategory = prod.stream()
											.filter(p -> p.category.equals(Category.BABY));
		System.out.println("-------------------------------------------------");
		System.out.println("Prodotti categoria Baby");
		System.out.println("-------------------------------------------------");
		babyCategory.forEach(b -> System.out.println(b));
	}
	
	static void findBoys(List<Product> prod) {
		Stream<Product> boysCategory = prod.stream()
											.filter(p -> p.category.equals(Category.BOYS));
		System.out.println("-------------------------------------------------");
		System.out.println("Prodotti categoria Boys con sconto del 10%");
		System.out.println("-------------------------------------------------");
		boysCategory.forEach(b -> b.applyDiscount());
	}
	
	public static void orderList(List<Order> ord) {
		Stream<Order> orderCategory = ord.stream()
										.filter(p -> p.customer.tier == 2)
										.filter(p -> p.checkDate().count() == 1);
		System.out.println("-------------------------------------------------");
		orderCategory.forEach(p -> System.out.println("La data dell'ordine è nel range tra il 02-09-2023 e il 02-14-2023"));
	}
}
