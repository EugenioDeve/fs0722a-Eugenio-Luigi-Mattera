package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="eventi")
@Getter
@Setter
@ToString
public class Evento {
	
	//COLUMNS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	
	@Column(name = "data_evento")
	private LocalDate dataEvento;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento")
	private TipoEvento tipoEvento;
	
	@Column(name = "numero_massimo_partecipanti")
	private int numeroMassimoPartecipanti;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "evento_partecipazione",
		joinColumns = @JoinColumn( name = "evento_id" ),
		inverseJoinColumns = @JoinColumn( name = "partecipazione_id" )
	)
	private Set<Partecipazione> partecipazioni;

	
	//GETTERS - SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
	

	
	
}
