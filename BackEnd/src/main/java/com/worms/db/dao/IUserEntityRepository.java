package com.worms.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worms.db.entities.User;

@Repository
public interface IUserEntityRepository extends JpaRepository<User, Integer> {

}
