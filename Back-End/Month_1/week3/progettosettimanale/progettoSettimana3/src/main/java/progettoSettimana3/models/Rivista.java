package progettoSettimana3.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends Prodotti{
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista(long isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
		super(isbn, titolo, anno, pagine);
		this.periodicita = periodicita;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + this.getIsbn() + " - Titolo: " + this.getTitolo() + " - Anno: " + this.getAnno() + " - Pagine: " + this.getPagine() + " - Periodicità: " + this.getPeriodicita();
	}

}
