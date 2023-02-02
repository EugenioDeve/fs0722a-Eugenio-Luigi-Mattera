
public class Main {

	public static void main(String[] args) {

		Articolo a1 = new Articolo(0, "Tastiera", 20.0, 5);
		Articolo a2 = new Articolo(1, "Mouse", 10.0, 5);

		Cliente c1 = new Cliente(1, "Mario", "Rossi", "prova@prova.it", "10/01/2023");

		Articolo[] elenco = new Articolo[2];
		elenco[0] = a1;
		elenco[1] = a2;

		Carrello cart = new Carrello(c1.codiceCliente, elenco);
		
		System.out.println("Il totale del tuo carrello è: " + cart.totale + " €");
	}

}
