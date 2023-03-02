package it.epicode.be.godfather.model;

public class Drink implements FoodItem {
	
	public Drink(String name, Double price, Double calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	private String name;
	private Double price;
	private Double calories;
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
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
		Drink other = (Drink) obj;
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
