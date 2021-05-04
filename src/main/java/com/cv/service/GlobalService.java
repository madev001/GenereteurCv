package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Competance;
import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;
import com.cv.repository.CompetanceRepository;
import com.cv.repository.UtilisateurRepository;

@Service
public class GlobalService {

	@Autowired
	FormationService fs;
	@Autowired
	ExperienceService es;
	@Autowired
	LangueService ls;
	@Autowired
	CompetanceRepository cr;
	@Autowired
	UtilisateurRepository ur;
	
	public  ModelAndView getAllinfo(Long id)
	{
		ModelAndView mav = new ModelAndView("Model1");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
}
