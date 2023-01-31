import java.util.Arrays;

public class Sim {
	
	String numero;
	int credito;
	Chiamate[] lastCalls;
	
	public Sim(String numero) {
		this.numero = numero;
		this.credito = 0;
		this.lastCalls = new Chiamate[0];
	}
	
	void stampaDati() {
		System.out.println("Complimenti hai creato una nuova SIM!");
		System.out.println("Il tuo numero di telefono è: " + this.numero);
		System.out.println("Il credito residuo è: " + this.credito);
		System.out.println("Le tue ultime 5 chiamate: " + Arrays.toString(this.lastCalls));
	}

}
