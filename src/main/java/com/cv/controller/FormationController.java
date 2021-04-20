package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;

@Controller
public class FormationController {
	
	@Autowired
	FormationRepository fr;
	UtilisateurRepository ur;

	@PostMapping("/saveFormation")
	public void saveFormation(@ModelAttribute Formation formation )
	{
		//Utilisateur u = ur.getOne(id);
		//formation.setUtilisateur(u);
		fr.save(formation);
	
	}
}
