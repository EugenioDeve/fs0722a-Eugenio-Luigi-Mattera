package progettoSettimana3.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {
	
	
	@Id
	@SequenceGenerator(name = "utenti_id_seq", sequenceName = "utenti_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utenti_id_seq")
	private long numeroTessera;
	
	private String nome;
	private String cognome;
	
	@Column(name="data_di_nascita")
	private LocalDate dataDiNascita;


}
