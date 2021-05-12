package com.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cv.entities.Loisire;
import com.cv.entities.Utilisateur;

@Repository
public interface LoisireRepository extends JpaRepository <Loisire,Long>{

	@Query("select l from Loisire l where l.utilisateur=:x ")
	List<Loisire> getAllLoisire(@Param("x") Utilisateur u);
}
