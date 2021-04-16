package com.cv.repository;

import com.cv.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
