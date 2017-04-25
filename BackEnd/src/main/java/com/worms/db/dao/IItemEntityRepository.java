package com.worms.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worms.db.entities.Item;

@Repository
public interface IItemEntityRepository extends JpaRepository<Item, Integer> {

}
