package com.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cv.entities.Competance;
import com.cv.entities.Utilisateur;

@Repository
public interface CompetanceRepository extends JpaRepository <Competance,Long>{

	@Query("select c from Competance c where c.utilisateur=:x  order by c.Niveau DESC")
	List<Competance> getAllCompetance(@Param("x") Utilisateur u);
}
