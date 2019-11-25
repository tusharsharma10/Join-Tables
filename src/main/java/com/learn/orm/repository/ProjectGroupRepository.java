package com.learn.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orm.entity.ProjectGroup;
@Repository
public interface ProjectGroupRepository extends JpaRepository<ProjectGroup,String>  {

}
