package com.worms.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worms.db.entities.ItemInInventaire;
import com.worms.db.entities.ItemInInventaireId;

@Repository
public interface IItemInInventaireRepository extends JpaRepository<ItemInInventaire, ItemInInventaireId>{

}
