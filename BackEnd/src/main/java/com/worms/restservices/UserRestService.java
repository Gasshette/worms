package com.worms.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worms.db.dao.IUserEntityRepository;
import com.worms.db.entities.User;

@RestController
public class UserRestService {

	@Autowired
	private IUserEntityRepository userRepository;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> listAll(){
		System.out.println("coucou je suis la methode listAll()");
		return userRepository.findAll();
	}
	
//	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
//	public User getOne(@PathVariable("id") Integer id){
//		return userRepository.findOne(id);
//	}
//	
//	@RequestMapping(value="/users/create", method=RequestMethod.PUT)
//	public User create(@RequestBody User user){
//		return userRepository.save(user);
//	}
//	
//	@RequestMapping(value="/users/delete", method=RequestMethod.DELETE)
//	public void delete(@RequestBody User user){
//		userRepository.delete(user);
//	}
	
}
