package com.worms.db.services;

import org.junit.Test;

import com.worms.db.dao.UserDAO;
import com.worms.db.entities.User;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;


public class UserServiceTest {

	private UserService us;
	
	public UserServiceTest(){
		us = new UserService();
	}
	
	@BeforeClass
	public static void clearDatabase(){
		//clear database, just keep one user,item and inventaire for tests
	}
	
	@AfterClass
	public static void resetDatabase(){
		//Resetdatabase
		
	}
	
	@Test
	public void getUserById(){
		//We're supposed to get user with id 1, called test.
		User user = us.get(1);
		
		Assert.assertNotNull("user ne doit pas être null", user);
	}
	
	@Test
	public void getUserbyBadId(){
		User user = us.get(30);
		Assert.assertNull("user doit être null, car un mauvais id est passé en paramètre", user);
	}
	
	@Test
	public void addUser(){
		User user = new User();
		user.setEmail("createdByTest@test.tst");
		user.setLogin("createdByTest");
		user.setPassword("createdByTest");
		
		user = us.add(user);
		
		Assert.assertNotNull("L'id de l'objet user ne doit pas être null.", user.getId());
	}
	
//	@Test(expected=Exception.class)
//	public void addUserWithExistingEMail(){
//		//We are here trying to add a user with existing email.
//		//We are supposed to get : MySQLIntegrityConstraintViolationException
//		User user = new User();
//		user.setLogin("differentLogin");
//		user.setPassword("differentPassword");
//		user.setEmail("test@test.test");
//		user.setPoints(0);
//		
//		us.add(user);
//	}
//	
//	@Test(expected=Exception.class)
//	public void addUserWithExistingLogin(){
//		//We are here trying to add a user with existing email
//		//We are supposed to get : MySQLIntegrityConstraintViolationException
//		User user = new User();
//		user.setLogin("test");
//		user.setPassword("differentPassword");
//		user.setEmail("different@diff.diff");
//		user.setPoints(0);
//		
//		us.add(user);
//	}
	
	@Test
	public void deleteUserById(){
		us.delete(3);
		User user = us.get(3);

		Assert.assertNull("user doit être null", user);
	}
	
	@Test
	public void deleteUserByObject(){
		User user = us.get(9);
		us.delete(user);
		user = us.get(9);
		Assert.assertNull("user doit être null", user);
	}
	
	@Test
	public void authentication(){
		User user = us.authentication("test", "test");
		
		Assert.assertNotNull("user doit contenir le user qui s'authentifie, donc ne pas être null.", user);
	}
	
	@Test
	public void updatePersistentUser(){
		User user = us.get(1);
		user.setLogin("testUpdated");
		
		us.update(user);
		
		User user2 = us.get(1);
		
		Assert.assertEquals("Les valeurs doivent être identiques entre la base de données et celle spécifiée.",
							user.getLogin(), user2.getLogin());
	}
	
//	@Test
//	public void updateUserByHQLRequest(){
//		boolean flag = false;
//		User user = us.get(1);
//		//user.setLogin("testUpdated");
//		
//		int res = us.update(user);
//		if(res > 0){
//			flag = true;
//		}
//		
//		Assert.assertTrue("Le résultat doit être supérieur à zéro (0)", flag);
//	}
}
