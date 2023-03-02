package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Franchise implements MenuItem {
	
	private String name;
	private Double price;
	
	public Franchise(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getMenuItemLine() {
		return this.getName() + " - price: " + getPrice();	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Franchise other = (Franchise) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getPrice() == null) {
			if (other.getPrice()  != null)
				return false;
		} else if (!getPrice() .equals(other.getPrice() ))
			return false;
		return true;
	}
}
