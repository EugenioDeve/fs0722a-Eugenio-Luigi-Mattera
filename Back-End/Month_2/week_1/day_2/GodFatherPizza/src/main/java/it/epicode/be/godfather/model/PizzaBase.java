package it.epicode.be.godfather.model;

public abstract class PizzaBase implements Pizza {
	public PizzaBase(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	private final String name;
	private final Double price;
	private final Double calories;
	

	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Double getCalories() {
		return calories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCalories() == null) ? 0 : getCalories().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaBase other = (PizzaBase) obj;
		if (getCalories() == null) {
			if (other.getCalories() != null)
				return false;
		} else if (!getCalories().equals(other.getCalories()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}
	
	

}
