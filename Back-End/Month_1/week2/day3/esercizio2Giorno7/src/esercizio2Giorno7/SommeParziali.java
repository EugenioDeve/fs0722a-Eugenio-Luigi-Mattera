package esercizio2Giorno7;

public class SommeParziali extends Thread {

	private int inizio;
	private int fine;
	private int[] numeri;
	int sommaParziale;

	public SommeParziali(int inizio, int fine, int[] numeri) {
		this.inizio = inizio;
		this.fine = fine;
		this.numeri = numeri;
		this.sommaParziale = 0;
	}

	@Override
	public void run() {	
		this.calcoloSomma();
	}
	
	public int calcoloSomma() {
		int sommaAppoggio=0;
		for (int i = this.inizio; i < this.fine; i++) {
			sommaAppoggio += this.numeri[i];
		}
		return this.sommaParziale = sommaAppoggio;
	}

}
