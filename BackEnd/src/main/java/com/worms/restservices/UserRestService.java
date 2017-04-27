package com.worms.restservices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.worms.db.dao.IUserEntityRepository;
import com.worms.db.entities.User;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
public class UserRestService {

	@Autowired
	private IUserEntityRepository userRepository;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	@ResponseBody
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		// return "classpath:src/main/resources/templates/greeting";
		return "greeting";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listAll() {
		 return userRepository.findAll();
		 
//		 List<User> userList = null;
		 
//		JSONParser parser = new JSONParser();
//		
//		Object obj = null;
//		try {
//			obj = parser.parse(new FileReader("resources/users.json"));
//		} catch (FileNotFoundException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JSONObject jsonObject = (JSONObject) obj;
//		return (List<User>) obj;
	}

	// @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	// public User getOne(@PathVariable("id") Integer id) {
	// return userRepository.findOne(id);
	// }
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
