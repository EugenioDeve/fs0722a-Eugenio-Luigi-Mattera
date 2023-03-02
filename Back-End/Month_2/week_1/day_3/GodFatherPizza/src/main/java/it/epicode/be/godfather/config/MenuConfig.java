package it.epicode.be.godfather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.godfather.model.Drink;
import it.epicode.be.godfather.model.DrinkLemonade;
import it.epicode.be.godfather.model.Franchise;
import it.epicode.be.godfather.model.FranchiseMug;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.Pizza;
import it.epicode.be.godfather.model.PizzaHawaiian;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.PizzaSalami;
import it.epicode.be.godfather.model.PizzaTopping;
import it.epicode.be.godfather.model.Tavolo;
import it.epicode.be.godfather.model.ToppingCheese;
import it.epicode.be.godfather.model.ToppingHam;

@Configuration
public class MenuConfig {

	@Bean
	@Scope("singleton")
	public Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(pizzaSalami());
		menu.getMenuTopping().add(toppingCheese(null));
		menu.getMenuTopping().add(toppingHam(null));
		menu.getMenuDrink().add(drinkLemonade());
		return menu;
	}

	@Bean
	@Scope("prototype")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	@Scope("prototype")
	public Ordine ordine() {
		return new Ordine();
	}
	
	
	@Bean
	@Scope("application")
	public Ordine tavolo() {
		return new Ordine();
	}

	@Bean
	@Scope("prototype")
	public Tavolo tavolo(Integer numero, Integer numeroMassimoCoperti, Boolean occupato) {
		return new Tavolo(numero, numeroMassimoCoperti, occupato);
	}

	@Bean
	@Scope("prototype")
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	@Scope("prototype")
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	@Scope("prototype")
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}

	@Bean
	@Scope("prototype")
	public Franchise franchiseMug() {
		return new FranchiseMug();
	}

	@Bean
	@Scope("prototype")
	public PizzaTopping toppingCheese(Pizza pizza) {
		return new ToppingCheese(pizza);
	}

	@Bean
	@Scope("prototype")
	public PizzaTopping toppingHam(Pizza pizza) {
		return new ToppingHam(pizza);
	}
}
