package com.project.article.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.article.model.Login;


@Repository
public interface Repo extends JpaRepository<Login, Integer>{
	@Query(value="select * from login where Username = ?1", nativeQuery = true)
	public Login findByUsername(String Username); 

}
