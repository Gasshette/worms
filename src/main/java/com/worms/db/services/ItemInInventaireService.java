package com.worms.db.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.worms.db.dao.InventaireDAO;
import com.worms.db.dao.ItemDAO;
import com.worms.db.entities.ItemInInventaire;
import com.worms.db.entities.ItemInInventaire_Id;
import com.worms.db.iservices.IService;
import com.worms.db.util.HibernateSessionFactory;

public class ItemInInventaireService implements IService<ItemInInventaire> {
	
	private InventaireDAO inventaireDAO;
	private SessionFactory sessionFactory;
	
	public ItemInInventaireService(){
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		inventaireDAO = new InventaireDAO(); 
	}
	
	//TODO : Deux id pour al clef primaire, donc on utilise un objet InventaireId
//	@Override
//	public Inventaire get(Inventaire inventaireId) {
//		Inventaire inventaire = new Inventaire();
//		//this session will be limited by the try...catch
//		try (Session session = sessionFactory.openSession();) {
//			inventaire = inventaireDAO.findById(identifier, session);
//		}catch(NullPointerException er){
//			er.printStackTrace();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return inventaire;
//		return null;
//	}

	@Override
	public ItemInInventaire add(ItemInInventaire inventaire) {
		try(Session session = sessionFactory.openSession();){
			inventaire = inventaireDAO.persist(inventaire, session);
		}catch(Exception e){
			LOG.error("Add failed.");
			e.printStackTrace();
			throw e;
		}
		return inventaire;
	}

	/**
	 * Get an entry from the database based on the object InventaireId
	 * @param inventaireId : represent the primary key of Inventaire table
	 * @return : an instance of Inventaire
	 */
	public ItemInInventaire get(ItemInInventaire_Id inventaireId) {
		ItemInInventaire inventaire = null;
		try(Session session = sessionFactory.openSession()){
			inventaire = inventaireDAO.findById(inventaireId, session);
			LOG.debug("Get Successful");
		}
		catch(Exception e){
			LOG.error("Get failed.");
			throw e;
		}
		return inventaire;
	}
}
