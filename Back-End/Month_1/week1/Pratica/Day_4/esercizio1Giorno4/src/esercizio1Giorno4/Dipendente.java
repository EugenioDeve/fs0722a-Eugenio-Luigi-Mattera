package esercizio1Giorno4;

public class Dipendente {

	double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	double importoOrarioStraordinario;
	private Livello livello;
	Dipartimento dipartimento;

	public Dipendente(int matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = this.stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
	}

	public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario,
			Livello livello, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	static double calcolaPaga(Dipendente d) {
		return d.stipendio;
	}
	
	static double calcolaPaga(Dipendente d, int h) {
		return d.stipendio + (d.importoOrarioStraordinario*h);
	}
	
	public Livello promuovi() {
		Livello nuovoLivello = this.livello;
		switch(this.livello) {
			case OPERAIO:
				nuovoLivello = Livello.IMPIEGATO;
				this.stipendio = this.stipendioBase * 1.2;
				break;
			case IMPIEGATO:
				nuovoLivello = Livello.QUADRO;
				this.stipendio = this.stipendioBase * 1.5;
				break;
			case QUADRO:
				nuovoLivello = Livello.DIRIGENTE;
				this.stipendio = this.stipendioBase * 2;
				break;
			case DIRIGENTE:
				nuovoLivello = Livello.DIRIGENTE;
				System.out.println("Errore! Impossibile promuovere in quanto già DIRIGENTE");
				break;
		}
		
		return this.livello = nuovoLivello;
		
	}

	public void stampaDatiDipendente() {
		System.out.println("----------------------------------");
		System.out.printf(
				"Matricola: %d %nStipendio base: %.2f %nStipendio: %.2f %nImporto straordinari: %.2f %nLivello: %s %nDipartimento: %s%n",
				getMatricola(), getStipendioBase(), getStipendio(), getImportoOrarioStraordinario(), getLivello(),
				getDipartimento());
		System.out.println("----------------------------------");
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}

}
