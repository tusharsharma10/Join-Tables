package com.learn.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orm.entity.DevPgToRevJoin;
@Repository
public interface DevPgToRevJoinRepository extends JpaRepository<DevPgToRevJoin, Integer>{

}
