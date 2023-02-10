package progettoSettimana2;

import java.io.File;
import java.io.IOException;

public abstract class Prodotti {

	long isbn;
	String titolo;
	int anno;
	int pagine;
	
	public Prodotti(long isbn, String titolo, int anno, int pagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.anno = anno;
		this.pagine = pagine;
	}

	public long getIsbn() {
		return isbn;
	}

	public int getAnno() {
		return anno;
	}

	protected abstract Object getAutore();

	protected abstract Object getCognomeAutore();

	protected abstract void upload(File f, String e) throws IOException;

	protected abstract String preparaStringa();
	
	

}
