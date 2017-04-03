package com.worms.db.services;

import org.junit.Test;

import com.worms.db.entities.ItemInInventaire;
import com.worms.db.entities.ItemInInventaire_Id;
import com.worms.db.entities.Item;
import com.worms.db.entities.User;

import org.junit.Assert;

public class ItemInInventaireServiceTest {
	
	private ItemInInventaireService is;
	
	public ItemInInventaireServiceTest(){
		this.is = new ItemInInventaireService();
	}
	
	@Test
	public void addInventaire(){
		//We are here using the user "test", id = 1
		
		//Get user test
		UserService us = new UserService();
		User user = us.get(1);
		
		//get item
		ItemService is = new ItemService();
		Item item = is.get(3);
		
		//Create inventaire
		ItemInInventaire inventaire = new ItemInInventaire();
		ItemInInventaire_Id inventaireId = new ItemInInventaire_Id(user.getId(), item.getId());
		inventaire.setId(inventaireId);
		
		//System.out.println("inventaire : " + inventaire.toString());
		
		ItemInInventaireService invServ = new ItemInInventaireService();
		inventaire = invServ.add(inventaire);
		
		Assert.assertNotNull("La quantité de munitions ne doit pas être à null. Elle est définie à 0 par défaut dans la abse de données.", inventaire.getMunitions());
	}
	
	@Test
	public void getItemInInventaire(){
		
		ItemInInventaire_Id invId = new ItemInInventaire_Id();
		invId.setIdUser(1);
		invId.setIdItem(2);
		ItemInInventaire inventaire = is.get(invId);
		
		Assert.assertNotNull("inventaire ne doit pas être null", inventaire);
	}
	

}
