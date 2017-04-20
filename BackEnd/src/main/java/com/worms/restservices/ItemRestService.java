package com.worms.restservices;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worms.db.dao.IItemEntityRepository;
import com.worms.db.entities.Item;

@RestController
public class ItemRestService {

//	@Autowired
//	private IItemEntityRepository itemRepository;
//	
//	@RequestMapping(value="/items", method=RequestMethod.GET)
//	public List<Item> listAll(){
//		return itemRepository.findAll();
//	}
//	
//	@RequestMapping(value="/items/{id}", method=RequestMethod.GET)
//	public Item getOne(@PathVariable("id") Integer id){
//		return itemRepository.findOne(id);
//	}
//	
//	@RequestMapping(value="/items/create", method=RequestMethod.PUT)
//	public Item create(@RequestBody Item item){
//		return itemRepository.save(item);
//	}
//	
//	@RequestMapping(value="/items/delete", method=RequestMethod.DELETE)
//	public void delete(@RequestBody Item item){
//		itemRepository.delete(item);
//	}
	
}
