package com.worms.db.dao;
// Generated 31 mars 2017 20:38:36 by Hibernate Tools 5.2.1.Final

import java.util.List;

import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.worms.db.entities.User;

/**
 * Home object for domain model class User.
 * @see toto.User
 * @author Hibernate Tools
 */
@Stateless
public class UserDAO extends AbstractDAO<User> {

	//private static final Log log = LogFactory.getLog(UserDAO.class);
	
	/**
	 * Authentifie un utilisateur.
	 *
	 * @param unLogin
	 *            un login
	 * @param unPassword
	 *            un mot de passe
	 * @param pSession
	 *            une session
	 * @return l'utilisateur correspondant ou null si rien
	 * @throws Exception
	 *             si une erreur survient
	 */
	@SuppressWarnings("squid:S2068")
	public User authentifier(String unLogin, String unPassword, Session pSession) throws Exception {
		LOG.debug("authentifier {} Xxxx", unLogin);
		
		List<User> resultat = null;
		
		if (unLogin == null || unPassword == null || unLogin.trim().isEmpty() || unPassword.trim().isEmpty()) {
			throw new Exception("Parametres invalides");
		}
		
		try{
			// En HQL
			String request = "from " + this.getEntityClass().getName() + " where login=:unLogin and password=:unPwd";
			
			Query<User> query = pSession.createQuery(request, this.getEntityClass());
			query.setParameter("unLogin", unLogin);
			query.setParameter("unPwd", unPassword);
			
			resultat = query.getResultList();
			if (resultat == null || resultat.isEmpty()) {
				return null;
			}
			
			if (resultat.size() > 1) {
				LOG.error("An error occured. More than one result found.");
				throw new Exception("Plus d'un resultat trouve!");
			}
		}catch(RuntimeException e){
			LOG.error("RuntimeException error. Authentication failed");
		}catch(Exception er){
			LOG.error("Get Failed");
		}
		
		return resultat.get(0);
	}
}
