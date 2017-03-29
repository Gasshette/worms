package fr.grisel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String login;

	private String password;

	private int points;

	//bi-directional many-to-one association to Inventaire
	@OneToMany(mappedBy="user")
	private List<Inventaire> inventaires;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Inventaire> getInventaires() {
		return this.inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public Inventaire addInventaire(Inventaire inventaire) {
		getInventaires().add(inventaire);
		inventaire.setUser(this);

		return inventaire;
	}

	public Inventaire removeInventaire(Inventaire inventaire) {
		getInventaires().remove(inventaire);
		inventaire.setUser(null);

		return inventaire;
	}

}