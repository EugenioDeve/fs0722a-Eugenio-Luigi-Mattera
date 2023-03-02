package it.epicode.be.godfather;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.PizzaFamilySize;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.ToppingCheese;

public class GestioneMenu {

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");

	}

	public void stampaMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZA");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();

		System.out.println("DRINK");
		menu.getMenuDrink().forEach(p -> System.out.println(p.getMenuItemLine()));

		System.out.println();

		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(p -> System.out.println(p.getMenuItemLine()));

	}

	public void testTopping() {

		PizzaMargherita pizza = ctx.getBean(PizzaMargherita.class);
		
		
		ToppingCheese topping1 = new ToppingCheese(pizza);

		System.out.println(topping1.getName());
		
		ToppingCheese topping2 = new ToppingCheese(topping1);

		System.out.println(topping2.getName());
		
		PizzaFamilySize toppingBig = new PizzaFamilySize(topping2);
		System.out.println(toppingBig.getName());
		System.out.println(toppingBig.getPrice());


		
	}

}
