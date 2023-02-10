package progettoSettimana2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import Enum.Periodicita;

public class Rivista extends Prodotti{

	Periodicita periodicita;

	public Rivista(long isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
		super(isbn, titolo, anno, pagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		String str = "ISBN: " + this.isbn + " - Titolo: " + this.titolo + " - Anno: " + this.anno + " - Pagine: " + this.pagine + " - Periodicità: " + this.periodicita;
		return str;
	}

	@Override
	protected Object getAutore() {
		return null;
	}

	@Override
	protected Object getCognomeAutore() {
		return null;
	}
	
	@Override
	public String preparaStringa() {
		String str = this.isbn + "@" + this.titolo + "@" + this.anno + "@" + this.pagine + "@" + this.periodicita;
		return str;
	}
	
	@Override
	protected void upload(File f, String e) throws IOException {
		FileUtils.writeStringToFile(f, this.preparaStringa(), e, true);
	}
	
}
