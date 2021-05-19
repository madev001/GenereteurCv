package com.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cv.entities.Profile;
import com.cv.entities.Utilisateur;
@Repository
public interface ProfileRepository  extends JpaRepository<Profile,Long>{

	@Query("select p from Profile p where p.utilisateur=:x ")
	public Profile getProfile(@Param("x") Utilisateur u);
}
