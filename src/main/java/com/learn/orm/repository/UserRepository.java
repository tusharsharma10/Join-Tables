package com.learn.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orm.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
