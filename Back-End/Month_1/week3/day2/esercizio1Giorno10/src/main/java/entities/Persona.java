package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="persone")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue
	private int id;
	
	private String nome;
	private String cognome;
	private String email;
	
	@Column(name="data_nascita")
	private LocalDate dataDiNascita;
	
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	
	@OneToMany( mappedBy = "persona" )
	private List<Partecipazione> partecipazioni;
	
}
