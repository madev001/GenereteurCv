package com.cv.repository;

import com.cv.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository <Formation , Long>{

	@Query("select f from Formation f where f.utilisateur=:x ")
	List<Formation> getAllFormation(@Param("x") Utilisateur u);
}
