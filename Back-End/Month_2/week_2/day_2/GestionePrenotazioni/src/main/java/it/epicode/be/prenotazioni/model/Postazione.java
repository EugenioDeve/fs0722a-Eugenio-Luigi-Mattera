package it.epicode.be.prenotazioni.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Data;

@Data
@Entity
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codice;
	private String descrizione;
	private Integer numeroMassimoOccupanti;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@ManyToOne
	private Edificio edificio;
	
//	@OneToMany(mappedBy = "postazione")
//	@OrderBy(value = "dataPrenotata")
//	private List<Prenotazione> listaPrenotazioni;
}
