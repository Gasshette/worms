package com.worms.db.services;

import org.junit.Assert;
import org.junit.Test;

import com.worms.db.entities.Item;

public class ItemServiceTest {

	ItemService is;
	
	public ItemServiceTest(){
		is = new ItemService();
	}
	
	@Test
	public void addItem(){
		Item item = new Item();
		item.setDesignation("itemDeTest");
		item.setStock(10);
		
		is.add(item);
		
		Assert.assertNotNull("L'id de l'item ne doit pas être null", item.getId());
	}
}
