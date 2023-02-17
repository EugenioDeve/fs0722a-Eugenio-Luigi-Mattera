package dao;

import java.time.LocalDate;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.sun.jdi.Location;

import entities.Evento;
import entities.Partecipazione;
import entities.TipoEvento;
import utils.JpaUtil;

public class EventoDAO {
	
	private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void save(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo, int NumeroMaxPart) {
		
		Evento e = new Evento();
		
		
		try {
		e.setTitolo(titolo);
		e.setDataEvento(dataEvento);
		e.setDescrizione(descrizione);
		e.setTipoEvento(tipo);
		e.setNumeroMassimoPartecipanti(NumeroMaxPart);
		
		t.begin();
		
		em.persist(e);
		t.commit();
		
		System.out.println("Evento aggiunto con successo");
		
		} catch(Exception ex) {
			System.out.println("Errore nell'inserimento dell'Evento");
		}
	}
	
	public static void getEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		if(e==null) {
			System.out.println("L'evento con id " + id + "non è stato trovato");
			return;
		}
		
		System.out.println("Dati evento:");
		System.out.println(e);
	}
	
	public static void addPart(int id, int partId) {
		Evento e = em.find(Evento.class, id);
		
		Partecipazione p1 = em.find(Partecipazione.class, partId);
		
		e.setPartecipazioni( new HashSet<>() {{
			add(p1);
		}});
	}
	
	public static void deleteById(int id) {
		Evento e = em.find(Evento.class, id);
		if(e==null) {
			System.out.println("L'evento con id " + id + "non è stato trovato");
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		System.out.println("L'evento con id " + id + " è stato eliminato");
		
	}
	
	public static void refresh(int id, int numeroPartecipanti) {
		Evento e = em.find(Evento.class, id);
		if(e==null) {
			System.out.println("L'evento con id " + id + "non è stato trovato");
			return;
		}
		
		e.setNumeroMassimoPartecipanti(numeroPartecipanti);
		
		System.out.println("Numero temporaneo partecipanti: " + e.getNumeroMassimoPartecipanti());
		
		em.refresh(e);
		
		System.out.println("L'evento con id " + id + " è stato aggiornato");
		System.out.println("Numero partecipanti: " + e.getNumeroMassimoPartecipanti());
	}
	
	public static void closeEm() {
		em.close();
		emf.close();
	}
}
