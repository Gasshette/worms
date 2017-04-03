package com.worms.db.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.worms.db.dao.UserDAO;
import com.worms.db.entities.User;
import com.worms.db.iservices.IService;
import com.worms.db.util.HibernateSessionFactory;

public class UserService
implements IService<User>{
	
	private UserDAO userDAO;
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor of UserService
	 */
	public UserService(){
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		userDAO = new UserDAO();
	}
	
	public User get(Integer identifier) {
		User user = new User();
		//this session will be limited by the try...catch
		try (Session session = sessionFactory.openSession();) {
			user = userDAO.findById(identifier, session);
		}catch(NullPointerException er){
			er.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
	}
	
	/**
	 * add a user in the database
	 */
	public User add(User user) {
		try(Session session = sessionFactory.openSession();){
				user = userDAO.persist(user, session);
		}
		catch(Exception e){
			e.getMessage();
		}
		
		return user;
	}
	
	/**
	 * Delete a user from the database
	 * @param user : the user which will be deleted
	 */
	public void delete(User user){
		try(Session session = sessionFactory.openSession();){
			userDAO.remove(user, session);
		}catch(Exception e){
			LOG.error("Delete by Object fail : " + e.getMessage());
		}
	}
	
	/**
	 * Delete a user from the database based on his id
	 * @param id : id of the user you want to delete
	 */
	public void delete(Integer id){
		try(Session session = sessionFactory.openSession();){
			userDAO.removeById(id, session);
		}catch(Exception e){
			LOG.error("Delete by id fail : " + e.getMessage());
		}
	}
	
	/**
	 * Check if a user exist in the database with specified login and password.
	 * It compare the login and password from the database with those the user seized
	 * @param unLogin : login of the user
	 * @param unPassword : password of the user
	 * @return null if the authentication fail, the user object if the authentication success
	 */
	public User authentication(String unLogin, String unPassword){
		User userAuth = new User();
		
		try(Session session = sessionFactory.openSession();){
			userAuth = userDAO.authentifier(unLogin, unPassword, session);
		}
		catch(Exception e){
			LOG.error("Authentication fail : " + e.getMessage());
		}
		
		if(userAuth == null){
			return null;
		}
		return userAuth;
	}
	
	@SuppressWarnings("unchecked")
	public User update(User user){
		//let's do a simple insert while merge doesn't work
//		int result = 0;
//		
//		Session session = sessionFactory.openSession();
//		Transaction tx  = session.beginTransaction();
//		Query<User> query = session.createQuery("UPDATE User SET login=:unLogin");
//		query.setParameter("unLogin", "testUpdated");
//		result = query.executeUpdate();
//		tx.commit();
//		return result;
//		
		try(Session session = sessionFactory.openSession();){
			System.out.println("user avant =" + user.toString());
			userDAO.merge(user, session);
			System.out.println("user après =" + user.toString());
		}
		catch(Exception e){
			LOG.error("Update fail : " + e.getMessage());
		}
		return user;
	}
}
