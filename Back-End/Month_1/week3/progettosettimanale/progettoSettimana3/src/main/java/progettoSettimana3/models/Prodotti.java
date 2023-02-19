package progettoSettimana3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Prodotti {
	
	@Id
	@GeneratedValue
	private long isbn;
	private String titolo;	
	private int anno;
	private int pagine;
	
	public Prodotti(long isbn, String titolo, int anno, int pagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.anno = anno;
		this.pagine = pagine;
	}

}
