package com.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.entities.Langue;

@Repository
public interface LangueRepository extends JpaRepository <Langue,Long>{

}
