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
		return (this.pizza != null ? (getPizza().getName() + " - ") : "") + "Family size";
	}

	@Override
	public Double getPrice() {
		return (this.pizza != null ? getPizza().getPrice() : 0) + price;
	}

	@Override
	public Double getCalories() {
		return (this.pizza != null ? getPizza().getCalories() : 1) * calories;
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
