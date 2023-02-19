package progettoSettimana3.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prestiti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Utente utente;

	@ManyToOne
	private Prodotti prodottoPrestato;

	@Column(name = "data_inzio_prestito")
	private LocalDate dataInzio;

	@Column(name = "data_rest_prevista")
	private LocalDate dataResPrevista;

	@Column(name = "data_rest_effettiva")
	private LocalDate dataResEff;


}
