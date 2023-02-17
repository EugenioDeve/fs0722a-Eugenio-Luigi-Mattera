package dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Evento;
import entities.Partecipazione;
import entities.Persona;
import entities.Stato;
import utils.JpaUtil;

public class PartecipazioneDAO {

	private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(int id, int evId, Stato stato) {

		Partecipazione p = new Partecipazione();

		try {
			Persona pe = em.find(Persona.class, id);
			
			if(pe==null) {
				System.out.println("persona con id " + id + "non è stato trovato");
				return;
			}
			
			Evento ev = em.find(Evento.class, evId);
			
			if(ev==null) {
				System.out.println("evento con id " + id + "non è stato trovato");
				return;
			}
			p.setPersona(pe);
			p.setEvento(ev);
			p.setStato(stato);
			
			
			t.begin();
			em.persist(p);
			t.commit();

			System.out.println("Partecipazione aggiunta con successo");

		} catch (Exception ex) {
			System.out.println("Errore nell'inserimento della Partecipazione");
			System.out.println(ex);
		}
	}
	
	public static void deleteById(int id) {
		Partecipazione e = em.find(Partecipazione.class, id);
		if(e==null) {
			System.out.println("partecipazione con id " + id + "non è stato trovato");
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		System.out.println("partecipazione con id " + id + " è stato eliminato");
		
	}
	
	public static Partecipazione getEventoById(int id) {
		Partecipazione e = em.find(Partecipazione.class, id);
		if(e==null) {
			System.out.println("partecipazione con id " + id + "non è stato trovato");
			return null;
		}
		
		System.out.println("Dati evento:");
		System.out.println(e);
		return e;
	}
	
}
