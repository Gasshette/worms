package com.worms.db.entities;
// Generated 13 avr. 2017 14:41:15 by Hibernate Tools 5.2.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "inventaire", catalog = "game")
public class ItemInInventaire implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ItemInInventaireId id;
	
	@Autowired
	private Item item;
	
	@Autowired
	private User user;
	private int munitions;

	public ItemInInventaire() {
	}

	public ItemInInventaire(ItemInInventaireId id, Item item, User user, int munitions) {
		this.id = id;
		this.item = item;
		this.user = user;
		this.munitions = munitions;
	}

	@EmbeddedId
	@AttributeOverrides({ 
		@AttributeOverride(name = "idUser", column = @Column(name = "id_user", nullable = false)),
		@AttributeOverride(name = "idItem", column = @Column(name = "id_item", nullable = false)) 
	})
	public ItemInInventaireId getId() {
		return this.id;
	}

	public void setId(ItemInInventaireId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_item", nullable = false, insertable = false, updatable = false)
	public Item getItem() {
		return this.item;
	}
	
	//@JsonIgnore
	public void setItem(Item item) {
		this.item = item;
	}
	
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "munitions", nullable = false)
	public int getMunitions() {
		return this.munitions;
	}

	public void setMunitions(int munitions) {
		this.munitions = munitions;
	}

}
