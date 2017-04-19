package com.worms.db.entities;
// Generated 13 avr. 2017 14:41:15 by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user", catalog = "game", uniqueConstraints = { 
	@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "login") 
})
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String login;
	private String password;
	private String email;
	private Integer points;
	
	@Autowired
	private Set<ItemInInventaire> itemsInInventaire;

	public User() {
	}

	public User(String login, String password, String email, Integer points, Set<ItemInInventaire> inventaires) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.points = points;
		this.itemsInInventaire = inventaires;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login", unique = true)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", unique = true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ItemInInventaire> getInventaires() {
		return this.itemsInInventaire;
	}

	public void setInventaires(Set<ItemInInventaire> itemsInInventaire) {
		this.itemsInInventaire = itemsInInventaire;
	}

}
