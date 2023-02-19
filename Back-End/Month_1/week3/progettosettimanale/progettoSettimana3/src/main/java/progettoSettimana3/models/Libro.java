package progettoSettimana3.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
public class Libro extends Prodotti {
	
	@ManyToOne
	private Autore autore;
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	public Libro(long isbn, String titolo, int anno, int pagine, Autore autore, Genere genere) {
		super(isbn, titolo, anno, pagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		String str ="ISBN: " + this.getIsbn() + " - Titolo: " + this.getTitolo() + " - Anno: " + this.getAnno() + " - Pagine: " + this.getPagine() + " - Autore: " + this.getAutore() + " - Genere: " + this.getGenere();
		return str;
	}

}
