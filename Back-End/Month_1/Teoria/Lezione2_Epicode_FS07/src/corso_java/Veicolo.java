package corso_java;

public class Veicolo {
	
	String modello;
	String marca;
	String targa;
	String colore;
	int cilindrata;
	//String matricola;
	static int count = 0;
	static String tipo = "Tipo Veicolo"; 
	
	public Veicolo(String modello, String marca, String targa, String colore, int cilindrata) {
		this.modello = modello;
		this.marca = marca;
		this.targa = targa;
		this.colore = colore;
		this.cilindrata = cilindrata;
		//this.matricola = "AB000" + count;
		count++;
	}
	
	public Veicolo(String modello, String marca, int cilindrata) {
		this.modello = modello;
		this.marca = marca;
		this.cilindrata = cilindrata;
		//this.matricola = "AB000" + count;
		count++;
	}
	
	public Veicolo(String modello, String marca, String colore, int cilindrata) {
		this.modello = modello;
		this.marca = marca;
		this.colore = colore;
		this.cilindrata = cilindrata;
		//this.matricola = "AB000" + count;
		count++;
	}
	
	public void start() {
		System.out.println("Veicolo avviato");
	}
	
	public void stop() {
		System.out.println("Veicolo fermo");
	}
	
	public String info() {
		return this.marca + " " + this.modello + " " +
				this.colore + " cc." + this.cilindrata + " targa: " +
				this.targa;
	}
	
	public static void Test() {
		System.out.println("Veicolo!!!");
	}

}
