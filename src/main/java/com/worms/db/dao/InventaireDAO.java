package com.worms.db.dao;
// Generated 31 mars 2017 20:38:36 by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.worms.db.entities.ItemInInventaire;
import com.worms.db.entities.ItemInInventaire_Id;
import com.worms.db.util.HibernateSessionFactory;

/**
 * Home object for domain model class Inventaire.
 * 
 * @see ItemInInventaire.Inventaire
 * @author Hibernate Tools
 */
@Stateless
public class InventaireDAO extends AbstractDAO<ItemInInventaire> {

	private static final Log log = LogFactory.getLog(InventaireDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	// Insert Method. Persist() is almost equals to save(). Just no INSERT
	// executed outside the transaction. Refer to :
	// http://stackoverflow.com/questions/5862680/whats-the-advantage-of-persist-vs-save-in-hibernate
	// public void persist(Inventaire transientInstance) {
	// log.debug("persisting Inventaire instance");
	// try {
	// entityManager.persist(transientInstance);
	// log.debug("persist successful");
	// } catch (RuntimeException re) {
	// log.error("persist failed", re);
	// throw re;
	// }
	// }

	// Delete method
	// public void remove(Inventaire persistentInstance) {
	// log.debug("removing Inventaire instance");
	// try {
	// entityManager.remove(persistentInstance);
	// log.debug("remove successful");
	// } catch (RuntimeException re) {
	// log.error("remove failed", re);
	// throw re;
	// }
	// }

	// Update method. persist() will throw a EntityExistsException if the object
	// already exists in the DB.
	// That's why we use merge, which will put back the object from transient
	// state (ex-persistent) to persistent state.
	// public Inventaire merge(Inventaire detachedInstance) {
	// log.debug("merging Inventaire instance");
	// try {
	// Inventaire result = entityManager.merge(detachedInstance);
	// log.debug("merge successful");
	// return result;
	// } catch (RuntimeException re) {
	// log.error("merge failed", re);
	// throw re;
	// }
	// }

	// public Inventaire persist(Inventaire inventaire, Session uneSession) {
	// LOG.debug("persisting instance");
	// Transaction tx = uneSession.beginTransaction();
	// try {
	// uneSession.save(inventaire);
	// LOG.debug("persist successful");
	// tx.commit();
	// } catch (RuntimeException re) {
	// tx.rollback();
	// LOG.error("persist failed", re);
	// throw re;
	// }
	//
	// return inventaire;
	// }

	/**
	 * Select() method. We override this method from Abstract method to eb able
	 * to use InventaireId as parameter. InventaireId contain the primary key
	 * for our Inventaire To be clear, we pass a couple of primary key as
	 * parameter, and after hibernate magicness, we'll get the associated
	 * Inventaire.
	 * 
	 * @param id
	 *            : id of the object InventaireId
	 * @return an instance of Inventaire.
	 */
	public ItemInInventaire findById(ItemInInventaire_Id inventaireId, Session uneSession) {
		log.debug("getting Inventaire instance with idUser : " + inventaireId.getIdUser() + "; idItem : "
				+ inventaireId.getIdItem());
		ItemInInventaire instance = null;
		try {
			if (inventaireId != null) {
				instance = uneSession.find(ItemInInventaire.class, inventaireId);
				log.debug("get successful");
			}
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		return instance;
	}
}
