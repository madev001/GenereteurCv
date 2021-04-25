package com.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cv.entities.Experience;
import com.cv.entities.Utilisateur;
@Repository
public interface ExperienceRepository extends JpaRepository <Experience,Long>{

	@Query("select e from Experience e where e.utilisateur=:x ")
	List<Experience> getAllExperience(@Param("x") Utilisateur u);
}
