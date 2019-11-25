package com.learn.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orm.entity.DevPgJoin;
@Repository
public interface DevPgJoinRepository extends JpaRepository<DevPgJoin, String>{

}
