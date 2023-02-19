package progettoSettimana3.models.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import progettoSettimana3.models.Prestito;
import progettoSettimana3.models.Prodotti;

public class PrestitoDAO {

	private static final Logger logger = LoggerFactory.getLogger(PrestitoDAO.class);

	public void save(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	public void refresh(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Prestito getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Prestito.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Prestito object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(object);

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}
	
	public void prestitoDaTessera(long num) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Prestito p WHERE utente_numerotessera = :n AND data_rest_effettiva IS NULL");
		q.setParameter("n", num);
		
		List<Prestito> res = q.getResultList();
		
		for (Prestito p : res) {
			System.out.println(p.getProdottoPrestato());
		}	
	}
	
	public void prestitoNonReso() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		LocalDate data = LocalDate.now();
		
		Query q = em.createQuery("SELECT p FROM Prestito p WHERE data_rest_effettiva IS NULL AND data_rest_prevista < :n");
		q.setParameter("n", data);
		List<Prestito> res = q.getResultList();
		
		for (Prestito p : res) {
			System.out.println(p);
		}
	}
	
}
