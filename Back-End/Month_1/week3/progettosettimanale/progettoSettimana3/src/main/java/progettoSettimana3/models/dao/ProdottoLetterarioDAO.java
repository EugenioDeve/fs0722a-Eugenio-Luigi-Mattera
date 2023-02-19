package progettoSettimana3.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import progettoSettimana3.models.Prodotti;


public class ProdottoLetterarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProdottoLetterarioDAO.class);

	public void save(Prodotti object) {
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

	public void refresh(Prodotti object) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	public Prodotti getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			return em.find(Prodotti.class, id);

		} finally {
			em.close();
		}

	}

	public void delete(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			Prodotti e = em.find(Prodotti.class, id);

			em.remove(e);

			transaction.commit();
			System.out.println("Prodotto con ISBN " + id + "rimosso correttamente");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Error deleting object with id: " + id + " " + ex);
			throw ex;

		} finally {
			em.close();
		}
	}
	
	public void cercaPerAnno(int anno) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT p FROM Prodotti p WHERE anno = :n");
		q.setParameter("n", anno);

		List<Prodotti> res = q.getResultList();

		for (Prodotti p : res) {
			System.out.println(p);
		}
	}
	
	public void cercaPerAutore(String name) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		//Cerco l'id dell'autore in base al nome inserito
		Query q = em.createQuery("SELECT a.id FROM Autore a WHERE a.nome LIKE :n");
		q.setParameter("n", name);
		
		if (q.getResultList().size()==0) {
			System.out.println("L'autore inserito non è nel nostro database");
		}
		
		List<Integer> res = q.getResultList();;
		
		//Cerco i prodtti in base all'id prima ottenuto
		Query q2 = em.createQuery("SELECT l FROM Libro l  WHERE autore_id = :n");
		q2.setParameter("n", res.get(0));
		
		List<Prodotti> res2 = q2.getResultList();
		
		if (q2.getResultList().size()==0) {
			System.out.println("L'autore non ha scritto nessun libro");
		}
		
		System.out.println("Lista prodotti scritti da: " + name);
		for ( Prodotti p: res2) {
			System.out.println(p);
		}
	}
	
	public Prodotti cercaPerTitolo(String titolo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		//EFFETTUO UNA RICERCA SUL TITOLO O SU UNA PARTE DI ESSO
		Query q = em.createQuery("SELECT p FROM Prodotti p  WHERE titolo LIKE :n ");
		q.setParameter("n", "%" + titolo + "%");
		
		List<Prodotti> res = q.getResultList();
		
		
		for (Prodotti p : res) {
			System.out.println(p);
		}
		
		return res.get(0);
	}
}
