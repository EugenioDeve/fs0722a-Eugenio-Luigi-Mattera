package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Persona;
import entities.Sesso;
import utils.JpaUtil;

public class PersonaDAO {

	private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(String nome, String cognome, String email, LocalDate data, Sesso sesso) {

		Persona p = new Persona();

		try {
			
			p.setNome(nome);
			p.setCognome(cognome);
			p.setEmail(email);
			p.setDataDiNascita(data);
			p.setSesso(sesso);
			
			
			t.begin();
			em.persist(p);
			t.commit();

			System.out.println("Persona aggiunta con successo");

		} catch (Exception ex) {
			System.out.println("Errore nell'inserimento della persona");
			System.out.println(ex.getMessage());
		}
	}
	
	public static void deleteById(int id) {
		Persona p = em.find(Persona.class, id);
		if(p==null) {
			System.out.println("Persona con id " + id + "non è stata trovata");
			return;
		}
		
		t.begin();
		em.remove(p);
		t.commit();
		System.out.println("Persona con id " + id + " è stata eliminata");
		
	}
}
