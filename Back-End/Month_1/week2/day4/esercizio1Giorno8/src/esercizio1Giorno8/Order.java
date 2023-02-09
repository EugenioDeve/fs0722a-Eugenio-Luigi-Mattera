package esercizio1Giorno8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;


public class Order {

	long id;
	String status;
	LocalDate orderDate;
	LocalDate deliveryDate;
	List<Product> products;
	Customer customer;
	
	public Order(long id, List<Product> products, Customer customer, String status) {
		this.id = id;
		this.products = products;
		this.customer = customer;
		this.orderDate = getCurrentDate();
		this.deliveryDate = getExstimatedDelivery();
		this.status = status;
	}
	
	public Order(long id, List<Product> products, Customer customer, String status, String date) {
		this.id = id;
		this.products = products;
		this.customer = customer;
		this.orderDate = setDate(date);
		this.deliveryDate = getExstimatedDelivery();
		this.status = status;
	}
	
	
	public LocalDate setDate(String s) {
		LocalDate current = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		return current;
	}
	
	public LocalDate getCurrentDate() {
		LocalDate current = LocalDate.now();
		return current;
	}
	
	public LocalDate getExstimatedDelivery() {
		String orderD = this.orderDate.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(orderD));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 3);
		LocalDate delivery = c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return delivery;
	}
	
	public Stream<LocalDate> checkDate() {
		String startDate = "2023/02/09";
		String endDate = "2023/02/14";
		LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		Stream<LocalDate> dateStream = start.datesUntil(end, Period.ofDays(1)).filter( d -> d.equals(this.orderDate));
		return dateStream;
	}

	
	
}
