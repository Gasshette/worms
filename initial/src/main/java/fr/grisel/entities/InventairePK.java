package fr.grisel.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inventaire database table.
 * 
 */
@Embeddable
public class InventairePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_user", insertable=false, updatable=false)
	private int idUser;

	@Column(name="id_item", insertable=false, updatable=false)
	private int idItem;

	public InventairePK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdItem() {
		return this.idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InventairePK)) {
			return false;
		}
		InventairePK castOther = (InventairePK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.idItem == castOther.idItem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.idItem;
		
		return hash;
	}
}