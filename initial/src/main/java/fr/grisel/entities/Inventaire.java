package fr.grisel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventaire database table.
 * 
 */
@Entity
@NamedQuery(name="Inventaire.findAll", query="SELECT i FROM Inventaire i")
public class Inventaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InventairePK id;

	private int munitions;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Inventaire() {
	}

	public InventairePK getId() {
		return this.id;
	}

	public void setId(InventairePK id) {
		this.id = id;
	}

	public int getMunitions() {
		return this.munitions;
	}

	public void setMunitions(int munitions) {
		this.munitions = munitions;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}