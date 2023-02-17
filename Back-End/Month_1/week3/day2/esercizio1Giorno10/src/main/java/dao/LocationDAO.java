package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Location;
import utils.JpaUtil;

public class LocationDAO {
	
	private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void save(String nome, String citta) {

		Location l = new Location();

		try {
			
			l.setNome(nome);
			l.setCitta(citta);
			
			
			t.begin();
			em.persist(l);
			t.commit();

			System.out.println("Partecipazione aggiunta con successo");

		} catch (Exception ex) {
			System.out.println("Errore nell'inserimento della Partecipazione");
		}
	}

}
