package com.worms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worms.db.dao.IUserEntityRepository;

@SpringBootApplication
public class WebWormsApplication implements CommandLineRunner {

	@Autowired
	IUserEntityRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebWormsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		List<User> listUser = userRepository.findAll();
//		
//		 for (Iterator<User> iterator = listUser.iterator();
//		 iterator.hasNext();) {
//		 User utilisateur = iterator.next();
//		
//		 System.out.println(utilisateur.getLogin() + ", " +
//		 utilisateur.getEmail());
//		 }

//		User testUpdated = userRepository.findOne(16);
//		System.out.println(testUpdated);
	}
}
