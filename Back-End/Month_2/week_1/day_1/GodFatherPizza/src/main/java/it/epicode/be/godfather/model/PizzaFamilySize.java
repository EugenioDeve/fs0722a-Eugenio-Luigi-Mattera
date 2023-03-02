package it.epicode.be.godfather.model;

public class PizzaFamilySize implements Pizza {

	private Pizza pizza;
	private Double calories = 1.95;
	private Double price = 4.15;

	public PizzaFamilySize(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getName() {
		return this.getPizza().getName() + " - " + "Family size";
	}

	@Override
	public Double getPrice() {
		return this.getPizza().getPrice() + price;
	}

	@Override
	public Double getCalories() {
		return this.getPizza().getCalories() * calories;
	}

	@Override
	public String getMenuItemLine() {
		return "Family size for Pizza" + " - Calories: x" + this.calories + " - Price: " + price;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
