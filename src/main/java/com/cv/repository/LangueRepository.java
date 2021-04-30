package com.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;

@Repository
public interface LangueRepository extends JpaRepository <Langue,Long>{

	@Query("select l from Langue l where l.utilisateur=:x")
	List<Langue> getAllLangue(@Param("x") Utilisateur u);
}
