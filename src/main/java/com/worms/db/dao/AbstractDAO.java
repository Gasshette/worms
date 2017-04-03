package com.worms.db.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


/**
 * Un exemple de DAO generique. <br/>
 *
 * @param <T> Le type d'element manipule
 */
public abstract class AbstractDAO<T> {
	protected static final Logger LOG = LogManager.getLogger();
	
	//Represent the entity we're dealing with. getEntityClass will tell us which DAOEntity it is
	private Class<T> entityClass;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Constructeur de l'objet.
	 */
	protected AbstractDAO() {
		super();
		//Vraiment nécessaire ? cf findById() method
		//sessionFactory = HibernateSessionFactory.getSessionFactory();
	}

	/**
	 * Donne la classe associée a l'entité cible par ce DAO.
	 *
	 * @return la classe associee a l'entite cible.
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		if (this.entityClass == null) {
			Type mySuperclass = this.getClass().getGenericSuperclass();
			// On prend dynamiquement le type generique passé a la classe
			Type tType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
			String tName = tType.getTypeName();
			try {
				this.entityClass = (Class<T>) Class.forName(tName);
			} catch (Exception e) {
				AbstractDAO.LOG.error("Impossible de trouver la classe de l'entité associée au DAO", e);
			}
		}
		return this.entityClass;
	}

	/**
	 * Insert l'objet dans la base.
	 * 
	 * Insert Method. Persist() is almost equals to save(). Just no INSERT executed outside the transaction. Refer to :
	 * http://stackoverflow.com/questions/5862680/whats-the-advantage-of-persist-vs-save-in-hibernate
	 * We are here using save() because we need the saved instance as return value
	 *
	 * @param transientInstance
	 *            l'objet a inserer
	 * @param uneSession
	 *            la session hibernate a utiliser
	 * @return l'objet insere
	 */
	public T persist(T transientInstance, Session uneSession) {
		LOG.debug("persisting instance");
		Transaction tx = uneSession.beginTransaction();
		try {
			
			uneSession.save(transientInstance); 
			LOG.debug("persist successful");
			tx.commit();
		}
		catch (RuntimeException re) {
			tx.rollback();
			LOG.error("persist failed", re);
			throw re;
		}
		
		return transientInstance;
	}
	
	
	/**
	 * Met a jour l'objet dans la base.
	 *
	 *Update method. persist() will throw a EntityExistsException if the object already exists in the DB.
	 *That's why we use merge, which will set back the object from transient state (ex-persistent) to persistent state.
	 *
	 * @param detachedInstance
	 *            l'objet a mettre a jour
	 * @param uneSession
	 *            la session hibernate a utiliser
	 * @return l'objet mis a jour
	 * @throws ExceptionDao
	 *             si une erreur survient
	 */
	public T merge(T detachedInstance, Session uneSession) {
		LOG.debug("merging instance");
		Transaction tx = uneSession.beginTransaction();
		try {
			T result = entityManager.merge(detachedInstance);
			LOG.debug("merge successful");
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			tx.rollback();
			LOG.error("merge failed", re);
			throw re;
		}
	}

	/**
	 * Supprime l'objet de la base.
	 *
	 * @param persistentInstance
	 *            l'objet a supprimer
	 * @param uneSession
	 *            la session hibernate a utiliser
	 */
	public void remove(T persistentInstance, Session uneSession) {
		LOG.debug("removing instance");
		Transaction tx = uneSession.beginTransaction();
		try {
			uneSession.remove(persistentInstance);
			LOG.debug("remove successful");
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			LOG.error("remove failed", re);
			throw re;
		}
	}
	
	/**
	 * Supprime l'objet de la base en fonction de son id.
	 *
	 * @param id
	 *            l'id de l'objet a supprimer
	 * @param uneSession
	 *            la session hibernate à utiliser
	 */
	public void removeById(Integer id, Session uneSession) {
		LOG.debug("removing instance with the id : " + id);
		Transaction tx = uneSession.beginTransaction();
		try {
			uneSession.remove(findById(id, uneSession));
			LOG.debug("remove successful");
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			LOG.error("remove failed", re);
			throw re;
		}
	}

	/**
	 * Selectionne un objet en fonction de sa clef primaire.
	 *
	 * @param id
	 *            l'id de l'objet
	 * @param uneSession
	 *            la session hibernate a utiliser
	 * @return l'objet trouve ou null si aucun
	 */
	public T findById(Integer id, Session session) {
		LOG.debug("getting instance with id: " + id);
		try {
			T instance = session.find(this.getEntityClass(), id);
			LOG.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}

}