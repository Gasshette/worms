package com.worms.db.dao;
// Generated 31 mars 2017 20:38:36 by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.worms.db.entities.Item;
import com.worms.db.entities.User;


/**
 * Home object for domain model class Item.
 * @see toto.Item
 * @author Hibernate Tools
 */
@Stateless
public class ItemDAO extends AbstractDAO<Item> {

//	private static final Log log = LogFactory.getLog(ItemDAO.class);

//	@PersistenceContext
//	private EntityManager entityManager;

//	public void persist(Item transientInstance, Session uneSession) {
//		log.debug("persisting Item instance");
//		Transaction tx = uneSession.beginTransaction();
//		try {
//			
//			System.out.println(transientInstance);
//			//entityManager.persist(transientInstance);
//			log.debug("persist successful");
//			tx.commit();
//		} catch (RuntimeException re) {
//			log.error("persist failed", re);
//			tx.rollback();
//			throw re;
//		}
//	}
//
//	public void remove(Item persistentInstance) {
//		log.debug("removing Item instance");
//		try {
//			entityManager.remove(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}
//
//	public Item merge(Item detachedInstance) {
//		log.debug("merging Item instance");
//		try {
//			Item result = entityManager.merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Item findById(Integer id) {
//		log.debug("getting Item instance with id: " + id);
//		try {
//			Item instance = entityManager.find(Item.class, id);
//			log.debug("get successful");
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
}
