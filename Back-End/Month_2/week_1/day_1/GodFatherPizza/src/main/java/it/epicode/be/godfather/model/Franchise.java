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
	
	public String getMenuItemLine() {
		return this.name + " - price: " + price;	
	}
}
