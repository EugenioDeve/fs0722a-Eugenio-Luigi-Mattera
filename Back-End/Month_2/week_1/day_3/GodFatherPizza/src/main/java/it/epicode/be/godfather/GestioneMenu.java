package it.epicode.be.godfather;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.PizzaFamilySize;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.ToppingCheese;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GestioneMenu {

	private Menu menu;
	private AnnotationConfigApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) ctx.getBean("menu");

	}

	public void stampaMenu() {
		log.info("******* Menu *******");
		log.info("PIZZA");
		menu.getMenuPizza().forEach(p -> log.info(p.getMenuItemLine()));
		log.info("");

		log.info("DRINK");
		menu.getMenuDrink().forEach(p -> log.info(p.getMenuItemLine()));

		System.out.println();

		System.out.println("FRANCHISE");
		menu.getMenuFranchise().forEach(p -> log.info(p.getMenuItemLine()));

	}

	public void testTopping() {

		PizzaMargherita pizza = ctx.getBean(PizzaMargherita.class);
		
		
		ToppingCheese topping1 = new ToppingCheese(pizza);

		log.info(topping1.getName());
		
		ToppingCheese topping2 = new ToppingCheese(topping1);

		log.info(topping2.getName());
		
		PizzaFamilySize toppingBig = new PizzaFamilySize(topping2);
		log.info(toppingBig.getName());
		log.info("Price: {}",toppingBig.getPrice());

		
	}
	

}
