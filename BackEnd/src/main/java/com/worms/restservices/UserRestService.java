package com.worms.restservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.worms.db.dao.IUserEntityRepository;
import com.worms.db.entities.User;


//TODO : Implement Jersey annotation (@GET, @POST, @Path and @PathParams, and more if needed)
@RestController
public class UserRestService {

	@Autowired
	private IUserEntityRepository userRepository;

	/**
	 * Method calling findAll() Method from JPARepository
	 * @return all users found in the database
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listAll() {
		return userRepository.findAll();
	}
	
	/**
	 * 
	 * @param id : represent a user's id
	 * @return the user defined by the parameter "id"
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable("id") Integer id) {
		return userRepository.findOne(id);
	}

	// TODO : implementation of different URL
	//Needed : a definitive database schema
	//
	// @RequestMapping(value = "/users/create", method = RequestMethod.PUT)
	// public User create(@RequestBody User user) {
	// return userRepository.save(user);
	// }
	//
	// @RequestMapping(value = "/users/delete", method = RequestMethod.DELETE)
	// public void delete(@RequestBody User user) {
	// userRepository.delete(user);
	// }

}
