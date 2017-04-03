package com.worms.db.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.worms.db.dao.ItemDAO;
import com.worms.db.entities.Item;
import com.worms.db.iservices.IService;
import com.worms.db.util.HibernateSessionFactory;

public class ItemService implements IService<Item> {

	private ItemDAO itemDAO;
	private SessionFactory sessionFactory;
	
	public ItemService(){
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		itemDAO = new ItemDAO(); 
	}
	
	/**
	 * get an entry from the database
	 * @param identifier
	 * @return one entry of the DB as per the identifier
	 */
	public Item get(Integer identifier) {
		Item item = new Item();
		//this session will be limited by the try...catch
		try (Session session = sessionFactory.openSession();) {
			item = itemDAO.findById(identifier, session);
		}catch(NullPointerException er){
			er.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public Item add(Item item) {
		try(Session session = sessionFactory.openSession();){
			item = itemDAO.persist(item, session);
		}catch(Exception e){
			e.getMessage();
		}
		
		return item;
	}

}
