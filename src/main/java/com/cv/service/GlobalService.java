package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;

@Service
public class GlobalService {

	@Autowired
	FormationService fs;
	@Autowired
	ExperienceService es;
	@Autowired
	UtilisateurRepository ur;
	
	public  ModelAndView getAllinfo(Long id)
	{
		ModelAndView mav = new ModelAndView("Model1");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("experiences",experiences);
        return mav;
		
	}
}
