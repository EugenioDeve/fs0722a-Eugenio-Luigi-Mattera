package progettoSettimana2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import Enum.Genere;

public class Libro extends Prodotti {

	Autore autore;
	Genere genere;
	
	public Libro(long isbn, String titolo, int anno, int pagine, Autore autore, Genere genere) {
		super(isbn, titolo, anno, pagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		String str ="ISBN: " + this.isbn + " - Titolo: " + this.titolo + " - Anno: " + this.anno + " - Pagine: " + this.pagine + " - Autore: " + this.autore + " - Genere: " + this.genere;
		return str;
	}

	@Override
	protected Object getAutore() {
		return this.autore.nome;
	}

	@Override
	protected Object getCognomeAutore() {
		return this.autore.cognome;
	}
	
	@Override
	public String preparaStringa() {
		String str = this.isbn + "@" + this.titolo + "@" + this.anno + "@" + this.pagine + "@" + this.autore + "@" + this.genere;
		return str;
	}
	
	@Override
	protected void upload(File f, String e) throws IOException {
		FileUtils.writeStringToFile(f, this.preparaStringa(), e, true);
	}

}
