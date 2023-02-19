package progettoSettimana3.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import progettoSettimana3.models.Prodotti;
import progettoSettimana3.models.Utente;

public class UtenteDAO {

	private static final Logger logger = LoggerFactory.getLogger(UtenteDAO.class);

	public void save(Utente object) {
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

	public void refresh(Utente object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Utente getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Utente.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(Utente object) {
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
	
	public Utente getByTessera(Long num) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		//EFFETTUO UNA RICERCA SUL TITOLO O SU UNA PARTE DI ESSO
		Query q = em.createQuery("SELECT u FROM Utente u  WHERE numerotessera = :n ");
		q.setParameter("n", num);
		
		List<Utente> res = q.getResultList();
		
		
		return res.get(0);
	}
	
}
