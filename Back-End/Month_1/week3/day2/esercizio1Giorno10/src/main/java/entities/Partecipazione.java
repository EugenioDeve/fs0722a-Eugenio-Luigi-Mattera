package entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="partecipazioni")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Partecipazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "persona_id", referencedColumnName = "id"
	)
	private Persona persona;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "evento_id", referencedColumnName = "id"
	)
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
}
