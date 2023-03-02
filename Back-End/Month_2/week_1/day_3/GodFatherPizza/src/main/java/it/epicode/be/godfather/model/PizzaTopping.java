package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PizzaTopping implements Pizza {
	
	private final Pizza pizza;
	private final String name;
	private final Double price;
	private final Double calories;	
	
	@Override
	public String getName() {
		return (this.getPizza() != null ? (getPizza().getName() + " - ") : "") + this.name;
	}

	@Override
	public Double getPrice() {
		return (this.getPizza() != null ? getPizza().getPrice() : 0) + price;
	}

	@Override
	public Double getCalories() {
		return (this.getPizza() != null ? getPizza().getCalories() : 0) + calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
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
		Pizza other = (Pizza) obj;
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

	public Pizza getPizza() {
		return pizza;
	}

}
