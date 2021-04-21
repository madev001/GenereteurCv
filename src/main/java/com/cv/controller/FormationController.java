package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;

@Controller
public class FormationController {
	
	@Autowired
	FormationRepository fr;
	@Autowired
	UtilisateurRepository ur;

	/*
	@RequestMapping(value = "/saveFormation", method = { RequestMethod.GET, RequestMethod.POST })
	public void saveFormation(@ModelAttribute Formation formation,@RequestParam("id") Long id )
	{
		Utilisateur u = ur.getUtilisateur(id);
		//formation.setEtablissement(formation.getEtablissement());
		formation.setUtilisateur(u);
		fr.save(formation);
	
	}
	*/
	@RequestMapping(value = "/saveFormation", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addProfile(Utilisateur utilisateur, @ModelAttribute Formation formation,@RequestParam("id") Long id) {
        
        ModelAndView mav = new ModelAndView("Carriere");
        Utilisateur u = ur.getUtilisateur(id);
		Formation f = new Formation();
		f.setEtablissement(formation.getEtablissement());
		f.setDescription(formation.getDescription());
		f.setFormation_debut_annee(formation.getFormation_debut_annee());
		f.setFormation_debut_mois(formation.getFormation_debut_mois());
		f.setFormation_fin_annee(formation.getFormation_fin_annee());
		f.setFormation_fin_mois(formation.getFormation_fin_mois());
		f.setIntitule(formation.getIntitule());
		f.setLocalite(formation.getLocalite());
		f.setUtilisateur(u);
		fr.save(f);
        
        mav.addObject("formation",new Formation());
        mav.addObject("utilisateur",utilisateur);
        return mav;
    }
}
