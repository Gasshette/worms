package com.worms.db.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Factory hibernate.
 */
public final class HibernateSessionFactory {

	private static final Logger LOG = LogManager.getLogger();

	private static SessionFactory sessionFactory;

	/**
	 * Constructeur de l'objet.
	 */
	private HibernateSessionFactory() {
		super();
		HibernateSessionFactory.LOG.error("Ne pas utiliser le constructeur");
	}

	/**
	 * Recupere la session factory.
	 *
	 * @return la session factory.
	 * @since Hibernate 5
	 */
	public static synchronized SessionFactory getSessionFactory() {
		if (HibernateSessionFactory.sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			HibernateSessionFactory.sessionFactory = configuration.buildSessionFactory();
		}
		return HibernateSessionFactory.sessionFactory;
	}

	// /**
	// * Recupere la session factory.
	// *
	// * @return la session factory.
	// * @since Hibernate 4
	// */
	// public static synchronized SessionFactory getSessionFactory() {
	// Configuration configuration = new Configuration();
	// configuration.configure("hibernate.cfg.xml");
	// ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// .applySettings(configuration.getProperties()).build();
	// HibernateSessionFactory.sessionFactory =
	// configuration.buildSessionFactory(serviceRegistry);
	// }
}
