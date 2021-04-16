package com.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.entities.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository <Experience,Long>{

}
