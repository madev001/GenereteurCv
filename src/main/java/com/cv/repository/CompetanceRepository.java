package com.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.entities.Competance;

@Repository
public interface CompetanceRepository extends JpaRepository <Competance,Long>{

}
