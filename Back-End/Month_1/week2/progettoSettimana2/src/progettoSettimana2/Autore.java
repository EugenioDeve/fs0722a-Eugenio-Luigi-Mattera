package progettoSettimana2;

public class Autore {
	
	String nome;
	String cognome;
	public Autore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		String str = this.nome + " " + this.cognome;
		return str;
	}

}
