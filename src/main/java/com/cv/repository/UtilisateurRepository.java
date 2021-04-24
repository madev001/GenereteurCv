package com.cv.repository;

import com.cv.entities.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

	@Query("select u from Utilisateur u where u.id=:x ")
	public Utilisateur getUtilisateur(@Param("x") Long id);
}
